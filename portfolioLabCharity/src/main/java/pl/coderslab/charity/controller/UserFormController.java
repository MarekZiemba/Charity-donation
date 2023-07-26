package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class UserFormController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;


    // wyswietlenie formularza dodawania użytkownika
    @GetMapping(path = "/admin/user/add")
    String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/user/add";
    }

    // obsluga formularza dodawania użytkownika
//    @PostMapping(path = "/admin/user/add")
//    String processAddUserForm(@Valid User user, BindingResult bindingResult, @RequestParam String newPassword) {
//        if (bindingResult.hasErrors()) {
//            return "user/add";
//        }
//        // Jeśli podano nowe hasło, zaktualizuj je w encji użytkownika
//        if (!newPassword.isEmpty()) {
//            user.setPassword(passwordEncoder.encode(newPassword));
//        }
//        // Usuń pole newPassword przed zapisem do bazy danych
//        user.setNewPassword(null);
//        userService.save(user);
//        return "redirect:/admin/user/list";
//    }
    @PostMapping(path = "/admin/user/add")
    String processAddUserForm(@Valid UserRegistrationDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/user/add";
        }
        User user = User.builder()
                .username(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .dateOfBirth(userDTO.getDateOfBirth())
                .profilePhotoUrl(userDTO.getProfilePhotoUrl())
                .enabled(userDTO.getEnabled())
                .roles(userDTO.getRoles())
                .build();

        userService.save(user);
        return "redirect:/admin/user/list";
    }

    @GetMapping(path = "/admin/user/edit")
    String showEditUserForm(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "admin/user/edit";
    }

//    @PostMapping(path = "/admin/user/edit")
//    String processEditUserForm(@Valid User user, BindingResult bindingResult, @RequestParam String newPassword) {
//        if (bindingResult.hasErrors()) {
//            return "user/edit";
//        }
//        // Jeśli podano nowe hasło, zaktualizuj je w encji użytkownika
//        if (!newPassword.isEmpty()) {
//            user.setPassword(passwordEncoder.encode(newPassword));
//        }
//        // Usuń pole newPassword przed zapisem do bazy danych
//        user.setNewPassword(null);
//
//        userService.update(user);
//        return "redirect:/admin/user/list";
//    }
@PostMapping(path = "/admin/user/edit")
String processEditUserForm(@Valid UserRegistrationDTO userDTO, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        return "admin/user/edit";
    }
    User user = userService.findById(userDTO.getId());
    if (user == null) {
        // Obsługa błędu, gdy użytkownik o podanym ID nie został znaleziony
        // ...
    }

    // Aktualizuj dane użytkownika na podstawie danych z UserRegistrationDTO
    user.setUsername(userDTO.getUsername());
    user.setEmail(userDTO.getEmail());
    user.setFirstName(userDTO.getFirstName());
    user.setLastName(userDTO.getLastName());

    // Jeśli podano nowe hasło, zaktualizuj je w encji użytkownika
    if (!userDTO.getPassword().isEmpty()) {
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    }

    userService.update(user);
    return "redirect:/admin/user/list";
}

    @GetMapping(path = "/admin/user/remove")
    String processRemoveUser(@RequestParam Long id) {
        userService.deleteById(id);
        return "redirect:/admin/user/list";
    }

    // wyswietlanie listy wszystkich użytkownikówbo
    @GetMapping(path = "/admin/user/list")
    String showUserList(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "20") int size,
                        Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userService.findAll(pageable);
        model.addAttribute("users", users);
        return "admin/user/list";
    }

    @GetMapping(path = "/admin/user/search")
    String showSearchUserForm() {
        return "admin/user/search";
    }

    @GetMapping(path = "/admin/user/search", params = "username")
    String findByUsernameContains(@RequestParam String username, Model model) {
        List<User> users = userService.findByUsernameContains(username);
        model.addAttribute("users", users);
        return "admin/user/list";
    }

    @GetMapping(path = "/admin/user/search", params = "email")
    String findUserByEmailContains(@RequestParam String email, Model model) {
        List<User> users = userService.findUserByEmailContains(email);
        model.addAttribute("users", users);
        return "admin/user/list";
    }

    @GetMapping(path = "/admin/user/search", params = {"firstName", "lastName"})
    String findByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        List<User> users = userService.findByFirstNameAndLastName(firstName,  lastName);
        model.addAttribute("users", users);
        return "admin/user/list";
    }

    @GetMapping(path = "/admin/user/search/role", params = "name")
    String findByRoleName(@RequestParam String name, Model model) {
        List<User> users = userService.findByRoleName(name);
        model.addAttribute("users", users);
        return "admin/user/list";
    }

    // umieszczenie w modelu pod kluczamim 'roles' kolekcji obiektow Role
    @ModelAttribute("roles")
    Collection<Role> roles() {
        return roleService.findAll();
    }

}
