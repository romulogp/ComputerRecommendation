package br.com.rgp.rbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rgp.rbc.service.IConfiguracaoService;

@Controller
public class ComputerController {

	@Autowired
	private IConfiguracaoService configuracaoService;

	@RequestMapping("/pesquisa")
	public String search() {
		return "search";
	}
	
	@RequestMapping("/cadastro")
	public String registerConfiguration() {
		return "configuracao/cadastro";
	}
	
	@RequestMapping("/configuracoes")
	public String listConfiguration(Model model) {
		
		model.addAttribute("configuracoes", configuracaoService.listAllConfigurations());
		
		return "configuracao/lista";
	}
	
}
