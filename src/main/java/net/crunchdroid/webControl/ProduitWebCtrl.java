package net.crunchdroid.webControl;

import net.crunchdroid.dao.AppUserRepository;
import net.crunchdroid.model.Msg;
import net.crunchdroid.model.Produit;
import net.crunchdroid.service.MsgService;
import net.crunchdroid.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProduitWebCtrl {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private MsgService msgService;


    @GetMapping("/produits")
    public String getProduitPage(Model model, Principal principal) {

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("produits", produitService.findAll());

        return "produit";
    }

    @GetMapping("addProduit")
    public String getAddProduitPage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("newproduit", new Produit());

        return "produit";
    }

    @PostMapping("/saveproduit")
    public String saveaProduit(Model model, Produit produit, Principal principal) {

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        produit.setImage("/images/" + produit.getImage());
        produitService.save(produit);

        return this.getProduitPage(model, principal);
    }

    @GetMapping("/deleteProduit/{id}")
    public String deleteProduit(@PathVariable long id, Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        produitService.delete(id);
        return this.getProduitPage(model, principal);
    }

    @GetMapping("/updateProduit/{id}")
    public String updateproduit(@PathVariable long id, Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("updateproduit", produitService.getOneById(id));
        return "produit";
    }

    @PostMapping("/saveupdateproduit")
    public String saveUpdatedproduit(Model model, Produit produit, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        produitService.save(produit);
        return this.getProduitPage(model, principal);
    }

}
