package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.DonationService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationFormController {
    
    private final DonationService donationService;

    @GetMapping(path = "/admin/donation/remove")
    String processRemoveDonation(@RequestParam Long id) {
        donationService.deleteById(id);
        return "redirect:/admin/donation/list";
    }

    @GetMapping(path = "/admin/donation/list")
    String showDonationList(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "20") int size,
                               Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Donation> donations = donationService.findAll(pageable);
        model.addAttribute("donations", donations);
        return "admin/donation/list";
    }
    
}
