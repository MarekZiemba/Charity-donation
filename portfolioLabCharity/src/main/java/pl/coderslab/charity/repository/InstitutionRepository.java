package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    @Override
    List<Institution> findAll();

    @Override
    Optional<Institution> findById(Long id);

    List<Institution> findByName(String name);

    @Query(value = "SELECT * FROM institutions ORDER BY RAND() LIMIT 8", nativeQuery = true)
    List<Institution> findRandomInstitutions();

    Institution findById(Class<Institution> institutionClass, Long Id);

}
