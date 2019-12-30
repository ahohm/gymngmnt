package net.crunchdroid.batch;

import net.crunchdroid.dao.AppUserRepository;
import net.crunchdroid.model.Abonne;
import net.crunchdroid.model.Abonnement;
import net.crunchdroid.model.ExpiredAbonnement;
import net.crunchdroid.model.Msg;
import net.crunchdroid.model.user.AppUser;
import net.crunchdroid.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
@ConditionalOnProperty(name = "spring.enable.scheduling")
public class EmailMsgBatchBean {

    List<ExpiredAbonnement> expiredAbonnements = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AbonnementService abonnementService;
    @Autowired
    private AbonneService abonneService;
    @Autowired
    private AbonnementFactureService abonnementFactureService;
    @Autowired
    private ExpiredAbonnementService expiredAbonnementService;
    @Autowired
    private MsgService msgService;
    @Autowired
    private MailConfig mailConfig;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Autowired
    private net.crunchdroid.batch.Service service;

    /*  check if internet available*/
    public static boolean isInternetAvailable() throws IOException {
        return isHostAvailable("google.com") || isHostAvailable("amazon.com")
                || isHostAvailable("facebook.com") || isHostAvailable("apple.com");
//            return false;
    }

    private static boolean isHostAvailable(String hostName) throws IOException {
        try (Socket socket = new Socket()) {
            int port = 80;
            InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
            socket.connect(socketAddress, 3000);

            return true;
        } catch (UnknownHostException unknownHost) {
            return false;
        }
    }

    /*@Scheduled(cron = "0 17 * * FRI")*/
    @Scheduled(cron = "0/05 * * * * *")
    public void calculateAbscence() throws IOException {

        logger.info("sending mail and message");

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(this.mailConfig.getHost());
        javaMailSender.setPort(this.mailConfig.getPort());
        javaMailSender.setUsername(this.mailConfig.getUsername());
        javaMailSender.setPassword(this.mailConfig.getPassword());
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");
        javaMailSender.setJavaMailProperties(javaMailProperties);

        List<Abonnement> abonnements = new ArrayList<>();
        abonnements = abonnementService.findAll();


        List<ExpiredAbonnement> expiredAbonnements = expiredAbonnementService.findAll();

        for (Abonnement abonnement : abonnements) {


            List<Abonnement> listNonActiveAb = new ArrayList<>();

            for (ExpiredAbonnement nonActive : expiredAbonnements) {
                listNonActiveAb.add(nonActive.getAbonnement());
            }

            if (!(listNonActiveAb.contains(abonnement))) {
                if (abonnement.getFin().isBefore(LocalDate.now())) {
                    ExpiredAbonnement naab = new ExpiredAbonnement();
                    naab.setAbonnement(abonnement);
                    expiredAbonnementService.save(naab);

                    Abonne abonne = abonnementFactureService.getAllByAbonnement(abonnement).getAbonne();

                    SimpleMailMessage mailMessage = new SimpleMailMessage();
                    mailMessage.setFrom("noReply@no.replay");
                    mailMessage.setSubject("Expired");
                    mailMessage.setCc(abonne.getMail());
                    String text = "mr." + abonne.getNom() + " " + abonne.getPrenom() + ". \n "
                            + "votre abonnement de descipline" + abonnement.getDescipline().getLibel() + "" +
                            "va etre expiré aujourd'hui.";

                    mailMessage.setText(text);
                    SmsRequest smsRequest = new SmsRequest(abonne.getTelephone(), text);

                    Msg msg = new Msg();
                    msg.setText(text);
                    msg.setDateTime(LocalDateTime.now());
                    msg.setObject("Expiration");

                    if (isInternetAvailable()) {
                        javaMailSender.send(mailMessage);
                        service.sendSms(smsRequest);
                    } else {
                        logger.warn("no internet connection available");
                    }
                }
            }


        }
    }
}
