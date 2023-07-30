package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

@Controller
@RequiredArgsConstructor
public class AccountActivationController {

    private final UserRepository userRepository;

    @GetMapping("/activate")
    public String activateAccount(@RequestParam("token") String token) {
        User user = userRepository.findByActivationToken(token);
        if (user != null) {
            user.setEnabled(true);
            user.setActivationToken(null);
            userRepository.save(user);
            // Przekierowanie na stronę informującą o pomyślnej aktywacji konta
            return "redirect:/accountActivated";
        } else {
            // Przekierowanie na stronę informującą o nieudanej aktywacji konta (nieprawidłowy token)
            return "redirect:/activationFailed";
        }
    }

    @GetMapping("/accountActivated")
    public String accountActivated() {
        // Widok z informacją o pomyślnej aktywacji konta
        return "accountActivated";
    }

    @GetMapping("/activationFailed")
    public String activationFailed() {
        // Widok z informacją o nieudanej aktywacji konta (nieprawidłowy token)
        return "activationFailed";
    }

}
