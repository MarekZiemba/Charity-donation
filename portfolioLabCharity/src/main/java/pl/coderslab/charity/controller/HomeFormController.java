package pl.coderslab.charity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.DonationService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeFormController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

//    public DonationController(DonationRepository donationRepository) {
//        this.donationRepository = donationRepository;
//    }

    @GetMapping("/")
    public String showSummary(Model model) {
        // Suma wartości liczbowych pola "quantity"
        int totalQuantity = donationService.totalQuantity();
        model.addAttribute("totalQuantity", totalQuantity);


        // Suma wszystkich donations (liczba wpisów)
        long totalDonations = donationService.totalDonations();
        model.addAttribute("totalDonations", totalDonations);

        // Pobierz listę instytucji z serwisu InstitutionService
        List<Institution> institutions = institutionService.findRandomInstitutions();
        model.addAttribute("institutions", institutions);

        return "index";
    }

}
