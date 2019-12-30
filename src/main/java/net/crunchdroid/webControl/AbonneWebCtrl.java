package net.crunchdroid.webControl;

import net.crunchdroid.dao.AppUserRepository;
import net.crunchdroid.dto.AbonneIsActiveDto;
import net.crunchdroid.model.Abonne;
import net.crunchdroid.model.AbonnementFacture;
import net.crunchdroid.model.Msg;
import net.crunchdroid.service.AbonneService;
import net.crunchdroid.service.AbonnementFactureService;
import net.crunchdroid.service.MsgService;
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
public class AbonneWebCtrl {

    @Autowired
    private AbonneService abonneService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AbonnementFactureService abonnementFactureService;

    @Autowired
    private MsgService msgService;


    @GetMapping("/abonnes")
    public String getAbonnePage(Model model, Principal principal) {

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
//        model.addAttribute("abonnes", abonneService.findAll());
        List<Abonne> abonnes = abonneService.findAll();
        List<AbonneIsActiveDto> listIsActive = new ArrayList<>();
        boolean isActive = false;
        for (Abonne abonne : abonnes) {
            isActive = false;
            List<AbonnementFacture> abonnementFactures = abonnementFactureService.getAllByAbonne(abonne);
            for (AbonnementFacture abonnementFacture : abonnementFactures) {
                if (abonnementFacture.getAbonnement().getFin().isAfter(LocalDate.now())) {
                    isActive = true;
                }
            }
            listIsActive.add(new AbonneIsActiveDto(abonne, isActive));

        }
        model.addAttribute("abonnes", listIsActive);

        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        return "abonne";
    }


    @GetMapping("addAbonne")
    public String getAddAbonnePage(Model model, Principal principal) {

        model.addAttribute("newabonne", new Abonne());

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));

        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        return "ajouterAbonne";
    }

    @PostMapping("/saveabonne")
    public String saveabonne(Model model, Abonne abonne, Principal principal) {

        abonne.setImage("/images/" + abonne.getImage());
        abonneService.save(abonne);

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        return this.getAbonnePage(model, principal);
    }

    @GetMapping("/deleteAbonne/{id}")
    public String deleteAbonne(@PathVariable long id, Model model, Principal principal) {
        abonneService.delete(id);
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        return this.getAbonnePage(model, principal);
    }

    @GetMapping("/updateAbonne/{id}")
    public String updateAbonne(@PathVariable long id, Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("updateabonnne", abonneService.getOneById(id));
        return "ajouterAbonne";
    }

    @PostMapping("/saveupdateabonne")
    public String saveUpdatedAbonne(Model model, Abonne abonne, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        abonneService.save(abonne);
        return this.getAbonnePage(model, principal);
    }


}
