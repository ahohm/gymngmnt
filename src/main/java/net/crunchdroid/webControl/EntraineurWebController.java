package net.crunchdroid.webControl;

import net.crunchdroid.dao.AppUserRepository;
import net.crunchdroid.model.Entraineur;
import net.crunchdroid.model.Msg;
import net.crunchdroid.service.AbonnementFactureService;
import net.crunchdroid.service.EntraineurService;
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
public class EntraineurWebController {

    @Autowired
    private EntraineurService entraineurService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AbonnementFactureService abonnementFactureService;

    @Autowired
    private MsgService msgService;

    @GetMapping("/entraineurs")
    public String getEntraineurPage(Model model, Principal principal) {

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("entraineurs", entraineurService.findAll());

        return "entraineur";
    }

    @GetMapping("addEntraineur")
    public String getAddEntraineurPage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("newentraineur", new Entraineur());

        return "entraineur";
    }

    @PostMapping("/saveentraineur")
    public String saveaEntraineur(Model model, Entraineur entraineur, Principal principal) {

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        entraineur.setImage("/images/" + entraineur.getImage());
        entraineurService.save(entraineur);

        return this.getEntraineurPage(model, principal);
    }

    @GetMapping("/deleteEntraineur/{id}")
    public String deleteAbonne(@PathVariable long id, Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        entraineurService.delete(id);
        return this.getEntraineurPage(model, principal);
    }

    @GetMapping("/updateEntraineur/{id}")
    public String updateentraineur(@PathVariable long id, Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("updateentraineur", entraineurService.getOneById(id));
        return "entraineur";
    }

    @PostMapping("/saveupdateentraineur")
    public String saveUpdatedentraineur(Model model, Entraineur entraineur, Principal principal) {
        entraineurService.save(entraineur);
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        return this.getEntraineurPage(model, principal);
    }
}
