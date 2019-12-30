package net.crunchdroid;

import net.crunchdroid.service.AbonneService;
import net.crunchdroid.service.ExpiredAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class BootstrapApp {


    public static void main(String[] args) {
        SpringApplication.run(BootstrapApp.class, args);
        LocalDateTime d = LocalDateTime.now();
        System.out.println(d);


    }
}
