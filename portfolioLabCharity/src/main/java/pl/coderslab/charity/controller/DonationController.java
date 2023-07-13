package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.entity.Donation;

@AllArgsConstructor
@Controller
public class DonationController {

    private final DonationRepository donationRepository;

//    public DonationController(DonationRepository donationRepository) {
//        this.donationRepository = donationRepository;
//    }




}
