package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Estudantes;
import web.repository.EstudantesRepository;

@Controller
public class EstudantesController {
    @Autowired
    private EstudantesRepository er;

    @GetMapping("/cadastrarEstudantes")
    public String cadastrarEstudantes(Model model) {
        model.addAttribute("estudante", new Estudantes());
        return "aplicacao/cadastrarEstudantes";
    }

    @PostMapping("/cadastrarEstudantes")
    public String cadastrarEstudantes(@ModelAttribute("estudante") Estudantes estudante) {
        er.save(estudante);
        return "redirect:/cadastrarEstudantes";
    }

    @GetMapping("/listarEstudantes")
    public String listarEstudantes(Model model) {
        Iterable<Estudantes> estudante = er.findAll();
        model.addAttribute("estudantes", estudante);
        return "aplicacao/listaEstudantes";
    }
}
