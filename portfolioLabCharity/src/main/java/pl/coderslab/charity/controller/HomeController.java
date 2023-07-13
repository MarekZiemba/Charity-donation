package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@AllArgsConstructor
@Controller
public class HomeController {

    private final DonationRepository donationRepository;

//    public DonationController(DonationRepository donationRepository) {
//        this.donationRepository = donationRepository;
//    }

    @GetMapping("/")
    public String showSummary(Model model) {
        // Suma wartości liczbowych pola "quantity"
        int totalQuantity = donationRepository.findAll()
                .stream()
                .mapToInt(Donation::getQuantity)
                .sum();

        // Suma wszystkich donations (liczba wpisów)
        long totalDonations = donationRepository.count();

        model.addAttribute("totalQuantity", totalQuantity);
        model.addAttribute("totalDonations", totalDonations);

        return "summary";
    }

}
