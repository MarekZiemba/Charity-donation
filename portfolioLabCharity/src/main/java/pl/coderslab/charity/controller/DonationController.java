package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.entity.*;
import pl.coderslab.charity.service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@Controller
public class DonationController {

    private final DonationRepository donationRepository;



    private final DonationService donationService;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    @PostMapping(path = "/donation")
    void save(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate pickUpDate, @RequestParam LocalTime pickUpTime, @RequestParam int quantity, @RequestParam String street, @RequestParam String city, @RequestParam String pickUpComment, @RequestParam String institutionName, @RequestParam String categoryName) {

        final Donation donation = new Donation();

        donation.setQuantity(quantity);
        donation.setStreet(street);
        donation.setStreet(city);
        donation.setPickUpDate(pickUpDate);
        donation.setPickUpTime(pickUpTime);
        donation.setPickUpComment(pickUpComment);

        Institution institution = new Institution();
        institution.setName(institutionName);
        institutionService.save(institution);
        donation.setInstitution(institution);

        Category category = new Category();
        category.setName(categoryName);
        categoryService.save(category);
        donation.setCategory(category);

        donationService.save(donation);
    }

    @GetMapping(path = "/donations", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Donation> donations = donationService.findAll();
        return donations.toString();
    }

    @GetMapping(path = "/donation/DateAndTime", produces = "text/plain;charset=utf-8")
    String findByDateAndTime(@RequestParam("pickUpDate") LocalDate pickUpDate, @RequestParam("pickUpTime") LocalTime pickUpTime) {
        final List<Donation> donations = donationService.findByPickUpDateAndPickupTimeOrderByPickupTime(pickUpDate, pickUpTime);
        return donations.toString();
    }

    @GetMapping(path = "/donation/DateAndTimeBetween", produces = "text/plain;charset=utf-8")
    String findByDateBetween(@RequestParam("pickUpDate") LocalDate pickUpDate1, @RequestParam("pickUpTime") LocalDate pickUpDate2) {
        final List<Donation> donations = donationService.findByPickUpDateBetweenOrderByPickUpDate(pickUpDate1, pickUpDate2);
        return donations.toString();
    }

    @GetMapping(path = "/donation/institution", produces = "text/plain;charset=utf-8", params = "id")
    String findByInstitution(Institution institution) {
        final List<Donation> donations = donationService.findByInstitution(institution);
        return donations.toString();
    }

    @GetMapping(path = "/donation/institution", produces = "text/plain;charset=utf-8", params = {"firstName", "lastName"})
    String findByInstitutionFullName(@RequestParam("name") String name) {
        final List<Donation> donations = donationService.findByInstitutionName(name);
        return donations.toString();
    }

    @GetMapping(path = "/donation/category", produces = "text/plain;charset=utf-8", params = "id")
    String findByCategory(Category category) {
        final List<Donation> donations = donationService.findByCategory(category);
        return donations.toString();
    }

    @GetMapping(path = "/donation/category", produces = "text/plain;charset=utf-8", params = "name")
    String findByCategoryByName(@RequestParam("name") String name) {
        final List<Donation> donations = donationService.findByCategoryName(name);
        return donations.toString();
    }
    

    @DeleteMapping(path = "/donation/{id}")
    void deleteById(@PathVariable Long id) {
        donationService.deleteById(id);
    }
}



