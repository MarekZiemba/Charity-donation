package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.*;
import pl.coderslab.charity.service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/donations")
public class DonationController {

    private final DonationService donationService;
    private final InstitutionService institutionService;

    @PostMapping(path = "/")
    void save(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate pickUpDate,
              @RequestParam LocalTime pickUpTime,
              @RequestParam int quantity,
              @RequestParam String street,
              @RequestParam String city,
              @RequestParam String zipCode,
              @RequestParam String phone,
              @RequestParam String pickUpComment,
              @RequestParam String institutionName,
              @RequestParam("categoryId") Long[] categoryId){

        Donation.builder()
                .pickUpTime(pickUpTime)
                .pickUpDate(pickUpDate)
                .quantity(quantity)
                .street(street)
                .city(city)
                .zipCode(zipCode)
                .phone(phone)
                .pickUpComment(pickUpComment)
                .build();

        final Donation donation = new Donation();

        Set<Category> categories = Arrays.stream(categoryId)
                .map(id -> new Category())
                .collect(Collectors.toSet());
        donation.setCategories(categories);

        Institution institution = new Institution();
        institution.setName(institutionName);
        institutionService.save(institution);
        donation.setInstitution(institution);

        donationService.save(donation);
    }

    @GetMapping(path = "/", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Donation> donations = donationService.findAll();
        return donations.toString();
    }

    @GetMapping(path = "/DateAndTime", produces = "text/plain;charset=utf-8")
    String findByDateAndTime(@RequestParam("pickUpDate") LocalDate pickUpDate,
                             @RequestParam("pickUpTime") LocalTime pickUpTime) {
        final List<Donation> donations = donationService.findByPickUpDateAndPickupTimeOrderByPickupTime(pickUpDate, pickUpTime);
        return donations.toString();
    }

    @GetMapping(path = "/DateAndTimeBetween", produces = "text/plain;charset=utf-8")
    String findByDateBetween(@RequestParam("pickUpDate") LocalDate pickUpDate1,
                             @RequestParam("pickUpTime") LocalDate pickUpDate2) {
        final List<Donation> donations = donationService.findByPickUpDateBetweenOrderByPickUpDate(pickUpDate1, pickUpDate2);
        return donations.toString();
    }

    @GetMapping(path = "/institution", produces = "text/plain;charset=utf-8", params = "id")
    String findByInstitution(Institution institution) {
        final List<Donation> donations = donationService.findByInstitution(institution);
        return donations.toString();
    }

    @GetMapping(path = "/institution", produces = "text/plain;charset=utf-8", params = {"firstName", "lastName"})
    String findByInstitutionFullName(@RequestParam("name") String name) {
        final List<Donation> donations = donationService.findByInstitutionName(name);
        return donations.toString();
    }

    @GetMapping(path = "/category", produces = "text/plain;charset=utf-8", params = "id")
    String findByCategory(Category category) {
        final List<Donation> donations = donationService.findByCategory(category);
        return donations.toString();
    }

    @GetMapping(path = "/category", produces = "text/plain;charset=utf-8", params = "name")
    String findByCategoryByName(@RequestParam("name") String name) {
        final List<Donation> donations = donationService.findByCategoryName(name);
        return donations.toString();
    }

    @DeleteMapping(path = "/{id}")
    void deleteById(@PathVariable Long id) {
        donationService.deleteById(id);
    }
}



