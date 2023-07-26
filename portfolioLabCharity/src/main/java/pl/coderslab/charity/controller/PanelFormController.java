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


