package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.security.UserRegistrationDto;
import pl.coderslab.charity.security.ValidationException;
import pl.coderslab.charity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.charity.service.SendEmailService;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class RegistrationFormController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SendEmailService sendEmailService;
    private final Environment env;

    // wyświetlenie formularza rejestracji użytkownika
    @GetMapping(path = "/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }

    // obsługa formularza rejestracji użytkownika
    @PostMapping(path = "/register")
    public String processRegistrationForm(@ModelAttribute("user") @Valid UserRegistrationDto userDTO,
                                          BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        // Sprawdzenie, czy hasło i powtórzone hasło są zgodne
        if (!userDTO.getNewPassword().equals(userDTO.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.user",
                    "Hasło i powtórzone hasło nie zgadzają się");
            return "register";
        }

        if (userRepository.findUserByEmail(userDTO.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "error.user", "Podany email jest już zarejestrowany");
            return "register";
        }

        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            bindingResult.rejectValue("username", "error.user", "Podany username jest już zajęty");
            return "register";
        }

        // Tworzenie obiektu User na podstawie UserRegistrationDTO i zapis do bazy danych
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getNewPassword()));
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        // Ustawienie aktywacji na false i wygenerowanie unikalnego tokena
        user.setEnabled(false);
        user.setActivationToken(UUID.randomUUID().toString());
            userRepository.save(user);

        // Wysyłanie emaila z linkiem aktywacyjnym
        String activationLink = env.getProperty("app.baseurl") + "/activate?token=" + user.getActivationToken();
        String emailBody = "Witaj " + user.getFirstName() + ",\n\nKliknij poniższy link, aby aktywować swoje konto:\n\n <a href='" + activationLink + "'> Kliknij tutaj</a>";
        sendEmailService.sendActivationMail(user.getEmail(), "Aktywacja konta", emailBody);


        return "redirect:/login";
    }

}
