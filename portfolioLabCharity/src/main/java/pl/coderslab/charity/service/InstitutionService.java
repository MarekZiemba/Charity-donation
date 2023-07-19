package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutionService {
    
    public final InstitutionRepository institutionRepository;

    public void save(Institution institution) {
        institutionRepository.save(institution);
    }

    public void update(Institution institution){
        institutionRepository.save(institution);
    }

    public void deleteById(Long id){
        institutionRepository.deleteById(id);
    }

    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    public Institution findById(Long id) {
        return institutionRepository.findById(id).get();
    }

    public List<Institution> findByName(String name) {
        return institutionRepository.findByName(name);
    }
    
}
