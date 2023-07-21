package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.DonationService;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FormFormController {

    private final DonationService donationService;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    // wyswietlenie formularza
    @GetMapping("/form")
    public String showForm(Model model) {

//        List<Category> categories = categoryService.findAll();
//        List<Institution> institutions = institutionService.findAll();
//        model.addAttribute("categories", categories);
//        model.addAttribute("institutions", institutions);
        model.addAttribute("donation", new Donation());

        return "form";
    }

    // obsluga formularza
    @PostMapping(path = "/form")
    String processForm(@Valid Donation donation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        donationService.save(donation);
        return "redirect:/form-confirmation";
    }

}

