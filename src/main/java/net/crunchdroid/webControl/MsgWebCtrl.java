package net.crunchdroid.webControl;

import net.crunchdroid.dao.AppUserRepository;
import net.crunchdroid.model.Msg;
import net.crunchdroid.model.user.AppUser;
import net.crunchdroid.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MsgWebCtrl {

    @Autowired
    private MsgService msgService;

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/msg")
    public String getMsgPage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        return "msg";
    }

    @GetMapping("/listEnvoye")
    public String getMsgEnvoyePage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        messages = msgService.findAllBySource(appUserRepository.findByUserName(userName));
        model.addAttribute("messagesenvoye", messages);

        return "msglistenvoye";
    }

    @GetMapping("/msg/{id}")
    public String getOneMsgPage(Model model, @PathVariable long id, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        model.addAttribute("msg", msgService.getOneById(id));

        return "onemsgpage";
    }

    @GetMapping("/newMsg")
    public String getMsgFormPage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        model.addAttribute("newmsg", new Msg());
        model.addAttribute("listDest", appUserRepository.findAll());

        return "msgform";
    }

    @PostMapping("/addMsg")
    public String addMsg(Model model, Msg msg, Principal principal) {

        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));

        msg.setSource(appUserRepository.findByUserName(userName));
        long id = msg.getDestination().getUserId();
        msg.setDestination(appUserRepository.findOne(id));
        msg.setDateTime(LocalDateTime.now());
        msgService.save(msg);

        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        return "msg";
    }

    @GetMapping("/deleteMsg/{id}")
    public String msgDelete(Model model, @PathVariable long id, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);

        msgService.delete(id);

        return "msg";
    }
}
