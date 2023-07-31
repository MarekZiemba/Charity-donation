package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.SendEmailService;
import pl.coderslab.charity.service.UserService;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ResetPasswordController {

    private final UserService userService;
    private final SendEmailService sendEmailService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/resetPassword")
    public String showResetPasswordForm() {
        return "resetPassword";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam("email") String email, Model model) {
        Optional<User> optionalUser = userService.findUserByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Generuj i zapisz token resetowania hasła
            String resetToken = generateResetToken();
            user.setResetToken(resetToken);
            userService.save(user);

            // Wyślij e-mail z linkiem resetującym hasło
            String subject = "Resetowanie hasła";
            String body = "Kliknij w link poniżej, aby zresetować hasło:\n\n"
                    + "<a href=http://localhost:8080/resetPasswordConfirm?token=" + resetToken
                    + "> Kliknij tutaj</a>";
            sendEmailService.sendActivationMail(email, subject, body);

            model.addAttribute("successMessage",
                    "Wysłaliśmy e-mail z linkiem resetującym hasło.");
        } else {
            model.addAttribute("errorMessage",
                    "Podany adres e-mail nie istnieje w bazie danych.");
        }
        return "index";
    }

    @GetMapping("/resetPasswordConfirm")
    public String showResetPasswordConfirmForm(@RequestParam("token") String token, Model model) {
        Optional<User> optionalUser = userService.findUserByResetToken(token);
        if (optionalUser.isPresent()) {
            // Sprawdź, czy token nie wygasł, jeśli wszystko w porządku, przekieruj do formularza zmiany hasła
            User user = optionalUser.get();
            if (isResetTokenValid(user)) {
                model.addAttribute("resetToken", token);
                return "resetPasswordConfirm";
            } else {
                model.addAttribute("errorMessage",
                        "Link resetujący hasło wygasł. Spróbuj ponownie.");
            }
        } else {
            model.addAttribute("errorMessage",
                    "Nieprawidłowy token resetowania hasła.");
        }
        return "resetPasswordConfirm";
    }

    @PostMapping("/resetPasswordConfirm")
    public String resetPasswordConfirm(@RequestParam("token") String token,
                @RequestParam("password") String password,
                @RequestParam("confirmPassword") String confirmPassword,
                Model model) {
        Optional<User> optionalUser = userService.findUserByResetToken(token);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (isResetTokenValid(user)) {
                if (password.equals(confirmPassword)) {
                    // Zmiana hasła i usunięcie tokena resetowania
                    user.setPassword(passwordEncoder.encode(password));
                    user.setResetToken(null);
                    userService.save(user);
                    model.addAttribute("successMessage",
                            "Twoje hasło zostało zresetowane.");
                    return "login";
                } else {
                    model.addAttribute("errorMessage",
                            "Podane hasła nie pasują do siebie.");
                }
            } else {
                model.addAttribute("errorMessage",
                        "Link resetujący hasło wygasł. Spróbuj ponownie.");
            }
        } else {
            model.addAttribute("errorMessage",
                    "Nieprawidłowy token resetowania hasła.");
        }
        return "resetPasswordConfirm";
    }

    // Metoda generująca unikalny token resetowania hasła (można dostosować wg potrzeb)
    private String generateResetToken() {
        return UUID.randomUUID().toString();
    }

    // Metoda sprawdzająca, czy token resetowania jest wciąż ważny (np. ważność 24 godziny)
    private boolean isResetTokenValid(User user) {
        return user.getResetToken() != null && !user.getResetToken().isEmpty();
    }
}
