package web.ucsal.aula13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.ucsal.aula13.repository.LivrosRepository;
import web.ucsal.aula13.model.Livros;

@Controller
public class LivrosController {
    @Autowired
    private final LivrosRepository livrosRepository;

    public LivrosController(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    @GetMapping("/livros")
    public String listarLivros(Model model) {
        model.addAttribute("livros", livrosRepository.findAll());
        return "livros";
    }

    @GetMapping("/livros/cadastro")
    public String exibirFormularioCadastro() {
        return "cadastro";
    }

    @PostMapping("/livros/cadastro")
    public String cadastrarLivros(Livros livro) {
        livrosRepository.save(livro);
        return "redirect:/livros";
    }
}
