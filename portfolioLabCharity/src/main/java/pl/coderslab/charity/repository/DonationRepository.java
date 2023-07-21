package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d")
    int sumAllQuantities();

    @Query("SELECT COUNT(d) FROM Donation d")
    long countAllDonations();

    @Override
    @EntityGraph(attributePaths = {"category", "institution"})
    List<Donation> findAll();

    @Override
    @EntityGraph(attributePaths = {"category", "institution"})
    Optional<Donation> findById(Long id);

    @EntityGraph(attributePaths = {"category", "institution"})
    List<Donation> findByQuantity(int quantity);

    @EntityGraph(attributePaths = {"category", "institution"})
    List<Donation> findByQuantityBetween(int quantity1, int quantity2);

    @EntityGraph(attributePaths = {"category", "institution"})
    List<Donation> findByPickUpDateAndPickUpTimeOrderByPickUpTime(LocalDate pickUpDate, LocalTime pickupTime);

    @EntityGraph(attributePaths = {"category", "institution"})
    List<Donation> findByPickUpDateBetweenOrderByPickUpDate(LocalDate pickUpDate1, LocalDate pickUpDate2);

    @EntityGraph(attributePaths = {"category", "institution"})
    List<Donation> findByCategory(@Param("category") Category category);

    @EntityGraph(attributePaths = {"category", "institution"})
    List<Donation> findByCategoryName(String name);

    @EntityGraph(attributePaths = {"category", "institution"})
    List<Donation> findByInstitution(@Param("institution") Institution institution);

    @EntityGraph(attributePaths = {"category", "institution"})
    List<Donation> findByInstitutionName(String name);

    Donation findById(Class<Donation> donationClass, Long id);

}
