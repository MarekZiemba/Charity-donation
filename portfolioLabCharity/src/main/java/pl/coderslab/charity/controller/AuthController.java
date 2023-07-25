package pl.coderslab.charity.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.DisabledException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RequestMapping("")
public class AuthController {

    @GetMapping(path = "/login")
    String login() {
        return "login";
    }

    @ExceptionHandler(DisabledException.class)
    public String handleDisabledException(Model model) {
        model.addAttribute("errorMessage",
                "Użytkownik nie jest aktywowany. Skontaktuj się z administratorem");
        return "redirect:/login";
    }

    @PostMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login";
    }

}
