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
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class InstitutionFormController {

    private final InstitutionService institutionService;

    // wyswietlenie formularza
    @GetMapping(path = "/admin/institution/add")
    String showAddInstitutionForm(Model model) {
        model.addAttribute("institution", new Institution());
        return "admin/institution/add";
    }

    // obsluga formularza
    @PostMapping(path = "/admin/institution/add")
    String processAddInstitutionForm(@Valid Institution institution, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/institution/add";
        }
        institutionService.save(institution);
        return "redirect:/admin/institution/list";
    }

    @GetMapping(path = "/admin/institution/edit")
    String showEditInstitutionForm(@RequestParam Long id, Model model) {
        model.addAttribute("institution", institutionService.findById(id));
        return "admin/institution/edit";
    }

    @PostMapping(path = "/admin/institution/edit")
    String processEditInstitutionForm(@Valid Institution institution, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/institution/edit";
        }
        institutionService.update(institution);
        return "redirect:/admin/institution/list";
    }

    @GetMapping(path = "/admin/institution/remove")
    String processRemoveInstitution(@RequestParam Long id) {
        institutionService.deleteById(id);
        return "redirect:/admin/institution/list";
    }

    @GetMapping(path = "/admin/institution/list")
    String showInstitutionList(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "20") int size,
                               Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Institution> institutions = institutionService.findAll(pageable);
        model.addAttribute("institutions", institutions);
        return "admin/institution/list";
    }

    @GetMapping(path = "/admin/institution/search")
    String showSearchInstitutionForm() {
        return "admin/institution/search";
    }

    @GetMapping(path = "/admin/institution/search", params = "name")
    String findByName(@RequestParam String name, Model model) {
        List<Institution> institutions = institutionService.findByName(name);
        model.addAttribute("institutions", institutions);
        return "admin/institution/list";
    }
    
}
