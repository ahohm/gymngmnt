package net.crunchdroid.webControl;

import net.crunchdroid.dao.AbonnementFactureDao;
import net.crunchdroid.dao.AppUserRepository;
import net.crunchdroid.dto.AbonnementActiveDto;
import net.crunchdroid.dto.AbonnementDto;
import net.crunchdroid.model.*;
import net.crunchdroid.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AbonnementWebCtrl {

    @Autowired
    private AbonnementService abonnementService;

    @Autowired
    private AbonneService abonneService;

    @Autowired
    private DesciplineService desciplineService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AbonnementFactureService abonnementFactureService;
    @Autowired
    private AbonnementFactureDao abonnementFactureDao;
    @Autowired
    private MsgService msgService;

    @GetMapping("/abonnements")
    public String getAbonnementPage(Model model, Principal principal) {

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        List<AbonnementActiveDto> abonnementActiveDtos = new ArrayList<>();
        List<Abonnement> abonnements = abonnementService.findAll();
        boolean active = false;
        for (Abonnement abonnement : abonnements) {
            active = abonnement.getFin().isAfter(LocalDate.now());
            Abonne a = abonnementFactureService.getAllByAbonnement(abonnement).getAbonne();
            abonnementActiveDtos.add(new AbonnementActiveDto(abonnement, active, a));
        }


        model.addAttribute("abonnementActiveDtos", abonnementActiveDtos);
        return "abonnement";
    }

    // add abonnement faut ajouter aussi une facture

    @GetMapping("/addAbonnement")
    public String getAddAbonnementPage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        AbonnementDto abonnementDto = new AbonnementDto();

        model.addAttribute("abonnementDto", abonnementDto);
        model.addAttribute("abonnes", abonneService.findAll());

        return "abonnement";
    }

    @PostMapping("/saveabonnement")
    public String getSaveAbonnementPage(Model model, AbonnementDto abonnementDto, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);


        Abonnement abonnement = new Abonnement();
        abonnement.setFin(abonnementDto.getFin());
        abonnement.setDebut(abonnementDto.getDebut());
        abonnement.setDescipline(desciplineService.getOneById(abonnementDto.getDescipline()));

        Abonne abonne = abonneService.getOneById(abonnementDto.getAbonneid());

        AbonnementFacture abonnementFacture = new AbonnementFacture();
        abonnementFacture.setAbonne(abonne);
        abonnementFacture.setAbonnement(abonnement);
        abonnementFactureService.save(abonnementFacture);


        List<AbonnementActiveDto> abonnementActiveDtos = new ArrayList<>();
        List<Abonnement> abonnements = abonnementService.findAll();
        boolean active = false;
        for (Abonnement abnmnt : abonnements) {
            active = abnmnt.getFin().isAfter(LocalDate.now());
            Abonne a = abonnementFactureService.getAllByAbonnement(abnmnt).getAbonne();
            abonnementActiveDtos.add(new AbonnementActiveDto(abnmnt, active, a));
        }


        model.addAttribute("abonnementActiveDtos", abonnementActiveDtos);
        return "abonnement2";
    }

    @GetMapping("/deleteAbonnement/{id}")
    public String deleteAbonnement(Model model, Principal principal, @PathVariable long id) {

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        abonnementService.delete(id);
        List<AbonnementActiveDto> abonnementActiveDtos = new ArrayList<>();
        List<Abonnement> abonnements = abonnementService.findAll();
        boolean active = false;
        for (Abonnement abnmnt : abonnements) {
            active = abnmnt.getFin().isAfter(LocalDate.now());
            Abonne a = abonnementFactureService.getAllByAbonnement(abnmnt).getAbonne();
            abonnementActiveDtos.add(new AbonnementActiveDto(abnmnt, active, a));
        }


        model.addAttribute("abonnementActiveDtos", abonnementActiveDtos);
        return "abonnement2";
    }
}
