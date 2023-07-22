package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ConfirmationFormController {
    @GetMapping(path = "/confirmation")
    String showForm(Model model) {
        return "confirmation";
    }
}
