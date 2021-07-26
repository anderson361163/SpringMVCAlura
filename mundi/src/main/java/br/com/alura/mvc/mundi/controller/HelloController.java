package br.com.alura.mvc.mundi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello") //o método que atende uma requisição HTTP se chama action
	public String hello(Model model) {
		
		/*
		 * Para editar uma página JSP existia o HttpServletRequest request, 
		 * porém para fazer essas edições existe a classe Model
		 * e ao invés de usar o request.
		 * 
		 * ---------------ANTES----------------------------
		 * 
		 * 	public String hello(HttpServletRequest request) {
		 *        request.setAttribute("nome", "Mundo");
		 *  }
		 *
		 * ---------------DEPOIS----------------------------
		 * 
		 * 
		 */
		model.addAttribute("nome", "Mundo");
	
		
		
		return "hello";
	}
	
}
