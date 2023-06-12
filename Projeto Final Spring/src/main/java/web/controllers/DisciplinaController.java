package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Disciplinas;
import web.repository.DisciplinasRepository;
import web.model.Professores;
import web.repository.ProfessoresRepository;
import web.model.Estudantes;
import web.repository.EstudantesRepository;

@Controller
public class DisciplinaController {
    @Autowired
    private DisciplinasRepository dr;
    @Autowired
    private ProfessoresRepository pr;
    @Autowired
    private EstudantesRepository er;

    @GetMapping("/cadastrarDisciplinas")
    public String cadastrarDisciplinas(Model model) {
        model.addAttribute("disciplina", dr.findAll());
        model.addAttribute("estudante", er.findAll());
        model.addAttribute("professor", pr.findAll());
        model.addAttribute("novaDisciplina", new Disciplinas());
        return "aplicacao/cadastrarDisciplinas";
    }

    @PostMapping("/cadastrarDisciplinas")
    public String cadastrarDisciplinas(@ModelAttribute("novaDisciplina") Disciplinas disciplina) {
        dr.save(disciplina);
        return "redirect:/cadastrarDisciplinas";
    }

    @GetMapping("/listarDisciplinas")
    public String listarDisciplinas(Model model) {
        Iterable<Disciplinas> disciplina = dr.findAll();
        model.addAttribute("disciplinas", disciplina);
        return "aplicacao/listarDisciplinas";
    }

}
