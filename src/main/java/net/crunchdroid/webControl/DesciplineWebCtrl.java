package net.crunchdroid.webControl;

import net.crunchdroid.dao.AppUserRepository;
import net.crunchdroid.model.Descipline;
import net.crunchdroid.model.Msg;
import net.crunchdroid.service.DesciplineService;
import net.crunchdroid.service.MsgService;
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
public class DesciplineWebCtrl {

    @Autowired
    private DesciplineService desciplineService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private MsgService msgService;


    @GetMapping("/desciplines")
    public String getDesciplinePage(Model model, Principal principal) {

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("desciplines", desciplineService.findAll());

        return "descipline";
    }

    @GetMapping("/addDescipline")
    public String getAddDesciplinePage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("newdescipline", new Descipline());

        return "descipline";
    }

    @PostMapping("/savedescipline")
    public String saveaDescipline(Model model, Descipline descipline, Principal principal) {

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        desciplineService.save(descipline);

        return this.getAddDesciplinePage(model, principal);
    }

    @GetMapping("/deleteOneDescipline/{id}")
    public String deleteDescipline(@PathVariable long id, Model model, Principal principal) {
        desciplineService.delete(id);
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("desciplines", desciplineService.findAll());
        return "descipline";
    }

    @GetMapping("/updateDescipline/{id}")
    public String updatedescipline(@PathVariable long id, Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        model.addAttribute("updatedescipline", desciplineService.getOneById(id));
        return "descipline";
    }

    @PostMapping("/saveupdatedescipline")
    public String saveUpdateddescipline(Model model, Descipline descipline, Principal principal) {
        desciplineService.save(descipline);
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        return this.getAddDesciplinePage(model, principal);
    }
}
