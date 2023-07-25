package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

@Controller
@RequiredArgsConstructor
public class PanelFormController {
    @GetMapping(path = "/admin/panel")
    String showForm(Model model) {
        return "admin/panel";
    }
}


//    private final UserService userService;
//
//    @GetMapping(path = "/admin/panel")
//    String showForm(Model model) {
//        User loggedUser = userService.getLoggedUser();
//        if (loggedUser != null && loggedUser.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN"))) {
//            return "admin/panel";
//        } else {
//            return "redirect:/";
//        }
//    }
