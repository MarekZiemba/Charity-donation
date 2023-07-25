package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.*;
import pl.coderslab.charity.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    private List<String> validate(User user) {
        Optional<User> byUser = userRepository.findByUsername(user.getUsername());
        if(byUser.isPresent()){
            return Arrays.asList("usernameAlreadyExists");
        }
        return Collections.emptyList();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user){
        userRepository.save(user);
    }

    public void deleteById(Long id){
        User user = userRepository.findById(User.class, id);
        user.removeRoles();
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public  List<User> findByRoles(Role role) {
        return userRepository.findByRoles(role);
    }

    public  List<User> findByRoleName(String name) {
        return userRepository.findByRolesName(name);
    }

    public User getLoggedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            User user = userRepository.findByUsername(username).orElse(null);
            return user;
        }
        return null;
    }

}
