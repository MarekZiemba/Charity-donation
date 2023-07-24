package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.security.UserRegistrationDTO;
import pl.coderslab.charity.security.ValidationException;
import pl.coderslab.charity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class RegistrationFormController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // wyświetlenie formularza rejestracji użytkownika
    @GetMapping(path = "/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDTO());
        return "register";
    }

    // obsługa formularza rejestracji użytkownika
    @PostMapping(path = "/register")
    public String processRegistrationForm(@ModelAttribute("user") @Valid UserRegistrationDTO userDTO,
                                          BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        // Sprawdzenie, czy hasło i powtórzone hasło są zgodne
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.user",
                    "Hasło i powtórzone hasło nie zgadzają się");
            return "register";
        }

        // Tworzenie obiektu User na podstawie UserRegistrationDTO i zapis do bazy danych
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        List<String> validationFailures = validate(user);
        if(validationFailures.isEmpty()){
            userRepository.save(user);
            return "redirect:/login";
        } else {
            throw new ValidationException(validationFailures);
        }


    }

    private List<String> validate(User user) {
        Optional<User> byUser = userRepository.findUserByEmail(user.getEmail());
        if(byUser.isPresent()){
            return Arrays.asList("emailAlreadyExists");
        }
        return Collections.emptyList();
    }

}
