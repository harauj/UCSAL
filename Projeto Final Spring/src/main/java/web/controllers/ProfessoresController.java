package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Professores;
import web.repository.ProfessoresRepository;

@Controller
public class ProfessoresController {
    @Autowired
    private ProfessoresRepository pr;

    @GetMapping("/cadastrarProfessores")
    public String cadastrarProfessores(Model model) {
        model.addAttribute("professor", new Professores());
        return "aplicacao/cadastrarProfessores";
    }

    @PostMapping("/cadastrarProfessores")
    public String cadastrarProfessores(@ModelAttribute("professor") Professores professor) {
        pr.save(professor);
        return "redirect:/cadastrarProfessores";
    }

    @GetMapping("/listarProfessores")
    public String listarEstudantes(Model model) {
        Iterable<Professores> professor = pr.findAll();
        model.addAttribute("professores", professor);
        return "aplicacao/listarProfessores";
    }
}
