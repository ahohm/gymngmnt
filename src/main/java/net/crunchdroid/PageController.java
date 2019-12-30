package net.crunchdroid;

import net.crunchdroid.dao.AppUserRepository;
import net.crunchdroid.model.Msg;
import net.crunchdroid.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CrunchDroid
 */
@Controller
public class PageController {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private MsgService msgService;

    @GetMapping("/plain-page")
    public String plainPage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", appUserRepository.findByUserName(userName));
        List<Msg> messages = new ArrayList<>();
        messages = msgService.findAllByDestination(appUserRepository.findByUserName(userName));
        model.addAttribute("messages", messages);
        return "plain-page";
    }

    @GetMapping("/pricing-tables")
    public String pricingTables() {
        return "pricing-tables";
    }

}
