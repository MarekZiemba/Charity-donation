package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DonationService {

    public final DonationRepository donationRepository;

    public Page<Donation> findAll(Pageable pageable) {
        return donationRepository.findAll(pageable);
    }

    public int totalQuantity() {
        return donationRepository.sumAllQuantities();
    }

    public long totalDonations() {
        return donationRepository.count();
    }

    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    public void update(Donation donation){
        donationRepository.save(donation);
    }

    public void deleteById(Long id){
        Donation donation = donationRepository.findById(Donation.class, id);
        donation.removeAllCategories();
        donationRepository.deleteById(id);
    }

    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    public Donation findById(Long id) {
        return donationRepository.findById(id).get();
    }

    public List<Donation> findByQuantity(int quantity) {
        return donationRepository.findByQuantity(quantity);
    }

    public List<Donation> findByQuantityBetween(int quantity1, int quantity2) {
        return donationRepository.findByQuantityBetween(quantity1, quantity2);
    }

    public List<Donation> findByPickUpDateAndPickupTimeOrderByPickupTime(LocalDate pickUpDate, LocalTime pickupTime) {
        return donationRepository.findByPickUpDateAndPickUpTimeOrderByPickUpTime(pickUpDate, pickupTime);
    }

    public List<Donation> findByPickUpDateBetweenOrderByPickUpDate(LocalDate pickUpDate1, LocalDate pickUpDate2) {
        return donationRepository.findByPickUpDateBetweenOrderByPickUpDate(pickUpDate1, pickUpDate2);
    }

    public  List<Donation> findByCategory(Category category) {
        return donationRepository.findByCategoriesContains(category);
    }

    public  List<Donation> findByCategoryName(String name) {
        return donationRepository.findByCategoriesName(name);
    }

    public  List<Donation> findByInstitution(Institution institution) {
        return donationRepository.findByInstitution(institution);
    }

    public  List<Donation> findByInstitutionName(String name) {
        return donationRepository.findByInstitutionName(name);
    }
    
}
