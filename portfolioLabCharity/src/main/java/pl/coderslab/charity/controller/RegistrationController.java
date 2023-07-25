package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.security.ValidationException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(path = "/register", produces = "text/plain;charset=utf-8")
    public User registerUser(@RequestParam String email,
                             @RequestParam String password) throws ValidationException {
        User user = new User();
        user.setUsername(email);
        user.setPassword(passwordEncoder.encode(password));

        List<String> validationFailures = validate(user);
        if(validationFailures.isEmpty()){
            return userRepository.save(user);
        } else {
            throw new ValidationException(validationFailures);
        }
    }
    private List<String> validate(User user) {
        Optional<User> byUser = userRepository.findByUsername(user.getUsername());
        if(byUser.isPresent()){
            return Arrays.asList("emailAlreadyExists");
        }
        return Collections.emptyList();
    }
}
