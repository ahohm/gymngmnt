package net.crunchdroid.webControl;

import net.crunchdroid.dao.AppUserRepository;
import net.crunchdroid.model.Msg;
import net.crunchdroid.service.AbonnementFactureService;
import net.crunchdroid.service.MsgService;
import net.crunchdroid.service.ProduitFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FactureWebCtrl {
    @Autowired
    private ProduitFactureService produitFactureService;

    @Autowired
    private AbonnementFactureService abonnementFactureService;

    @Autowired
    private MsgService msgService;

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/factureAbonnement")
    private String getAbonnementFacturePage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        model.addAttribute("afactures", abonnementFactureService.findAll());


        return "abonnementfacture";
    }

    @GetMapping("/factureProduit")
    private String getProduitFacturePage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        model.addAttribute("pfactures", produitFactureService.findAll());


        return "abonnementfacture";
    }
}
