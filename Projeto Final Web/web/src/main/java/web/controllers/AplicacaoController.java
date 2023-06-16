package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import web.model.Disciplinas;
import web.model.Estudantes;
import web.model.Professores;
import web.repository.DisciplinasRepository;
import web.repository.EstudantesRepository;
import web.repository.ProfessoresRepository;

@Controller
public class AplicacaoController {
@Autowired
	private EstudantesRepository er;
@Autowired
	private ProfessoresRepository pr;
@Autowired
	private DisciplinasRepository dr;

	@GetMapping("/cadastrarEstudantes")
	public String form(){
		return "aplicacao/formEstudantes";
	}
	
	@PostMapping("/cadastrarEstudantes")
	public String form(Estudantes estudante){
		
		er.save(estudante);
		return "redirect:/cadastrarEstudantes";
	}
	
	@GetMapping("/cadastrarProfessores")
	public String form2(){
		return "aplicacao/formProfessores";
	}
	
	@PostMapping("/cadastrarProfessores")
	public String form2(Professores professor){
		
		pr.save(professor);
		return "redirect:/cadastrarProfessores";
	}
	
	@GetMapping("/cadastrarDisciplinas")
	public String form3(){
		return "aplicacao/formDisciplinas";
	}
	
	@PostMapping("/cadastrarDisciplinas")
	public String form3(Disciplinas disciplina){
		
		dr.save(disciplina);
		return "redirect:/cadastrarDisciplinas";
	}	

	@GetMapping("/listaProfessores")
		public ModelAndView listaProfessores(){
			
			ModelAndView mv = new ModelAndView("aplicacao/listaProfessores");
			
			Iterable<Professores> professores = pr.findAll();			
			
			mv.addObject("professores", professores);
			return mv;
		}
	
	@GetMapping("/listaEstudantes")
		public ModelAndView listaEstudantes(){
		
			ModelAndView mv = new ModelAndView("aplicacao/listaEstudantes");
		
			Iterable<Estudantes> estudantes = er.findAll();			
		
			mv.addObject("estudantes", estudantes);
			return mv;
		}
	
	@GetMapping("/listaDisciplinas")
		public ModelAndView listaDisciplinas(){
	
			ModelAndView mv = new ModelAndView("aplicacao/listaDisciplinas");
	
			Iterable<Disciplinas> disciplinas = dr.findAll();			
	
			mv.addObject("disciplinas", disciplinas);
			return mv;
		}
}
