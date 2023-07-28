package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.security.UserRegistrationDTO;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoggedUserFormController {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(path = "/user/edit")
    String showEditUserForm(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user/edit";
    }

    @PostMapping(path = "/user/edit")
    String processEditUserForm(@Valid UserRegistrationDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        User user = userService.findById(userDTO.getId());
        if (user == null) {
            // Obsługa błędu, gdy użytkownik o podanym ID nie został znaleziony
            return "user/list";
        }

        // Aktualizuj dane użytkownika na podstawie danych z UserRegistrationDTO
        user.setPassword(userDTO.getConfirmPassword());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setProfilePhotoUrl(userDTO.getProfilePhotoUrl());

        // Jeśli podano nowe hasło, zaktualizuj je w encji użytkownika
        if (!userDTO.getNewPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDTO.getNewPassword()));
        }

        userService.update(user);
        return "redirect:/user/list";
    }

    @GetMapping(path = "/user/list")
    String showUserList( Model model) {
        User user = userService.getLoggedUser();
        model.addAttribute("user", user);
        return "user/list";
    }

    // umieszczenie w modelu pod kluczamim 'roles' kolekcji obiektow Role
    @ModelAttribute("roles")
    Collection<Role> roles() {
        return roleService.findAll();
    }

}
