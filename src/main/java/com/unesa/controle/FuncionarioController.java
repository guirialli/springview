package com.unesa.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.unesa.model.DepartamentoRepository;
import com.unesa.model.Funcionario;
import com.unesa.model.FuncionarioRepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository repositorio;
	
	@Autowired
	DepartamentoRepository repositorioDepto;
	
	@GetMapping("/funcionarios")
	public String obterTodos(Model model) {
		model.addAttribute("funcionario", repositorio.findAll());
		return "funclist";
	}
	@GetMapping("/funcionarios/excluir")
	public String excluir(Model model, String matricula) {
		repositorio.deleteById(matricula);
		model.addAttribute("funcionario", repositorio.findAll());
		return "funclist";
		
	}
	@GetMapping("/funcionarios/cadastro")
	public String cadastar(Model model) {
		model.addAttribute("funcionario", repositorio.findAll());
		return "funcdata";
	}
	
	@GetMapping("/funcionarios/cadastro/{matricula}")
	public String cadastrar(Model model, @PathVariable String matricula) {
		Funcionario funcionario = repositorio.findById(matricula).get();
		model.addAttribute("depto", repositorioDepto.findAll());
		model.addAttribute("funcionario", funcionario);
		
		return "funcdata";
		
	}
	
	@PostMapping("/funcionarios/cadastro")
	public String cadastrar(Model model, @ModelAttribute("func") Funcionario func) {
		repositorio.save(func);
		model.addAttribute("funcionario", repositorio.findAll());
		return "funclist";
	}
	
}
