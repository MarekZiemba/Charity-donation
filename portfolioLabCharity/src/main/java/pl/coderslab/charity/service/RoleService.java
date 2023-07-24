package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.repository.RoleRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public void save(Role role) {
        roleRepository.save(role);
    }

    public void update(Role role){
        roleRepository.save(role);
    }

    public void deleteById(Long id){
        Role role = roleRepository.findById(Role.class, id);
        role.removeUser();
        roleRepository.deleteById(id);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    public List<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

}
