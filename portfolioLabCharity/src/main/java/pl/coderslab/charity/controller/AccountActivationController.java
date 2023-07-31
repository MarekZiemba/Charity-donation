package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.RoleService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountActivationController {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @GetMapping("/activate")
    public String activateAccount(@RequestParam("token") String token) {
        User user = userRepository.findByActivationToken(token);
        if (user != null) {
            user.setEnabled(true);
            user.setActivationToken(null);
            userRepository.save(user);

            // Dodaj rolę 'ROLE_USER' dla aktywowanego użytkownika
            List<Role> roles = roleService.findByName("ROLE_USER");
            if (!roles.isEmpty()) {
                Role userRole = roles.get(0);
                user.getRoles().add(userRole);
                userRepository.save(user);
            }

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
