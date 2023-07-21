package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FormFormController {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    @GetMapping("/form")
    public String showForm(Model model) {

        List<Category> categories = categoryService.findAll();
        List<Institution> institutions = institutionService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("institutions", institutions);
        model.addAttribute("donation", new Donation());

        return "form";
    }

}
