package br.com.rgp.rbc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rgp.rbc.model.Configuracao;
import br.com.rgp.rbc.service.ConfiguracaoService;
import br.com.rgp.rbc.service.IConfiguracaoService;
import br.com.rgp.rbc.service.IRecommendationService;

@Controller
public class ComputerController {

	@Autowired
	private IConfiguracaoService configuracaoService;
	
	@Autowired
	private IRecommendationService recommendationService;

	@RequestMapping("/pesquisa")
	public String search(Configuracao configuracao) {
		return "configuracao/pesquisa";
	}
	
	@RequestMapping(value = "/pesquisa", method = RequestMethod.POST)
	public ModelAndView searchConfigurationResult(Configuracao searchConfig, BindingResult result, Model model, RedirectAttributes redAttributes) {
		
		model.addAttribute("configuracoes", recommendationService.searchForRecommendedConfigurations(searchConfig));
		
		return new ModelAndView("configuracao/resultadoPesquisa");
	}

	@RequestMapping("/cadastro")
	public ModelAndView newConfiguration(Configuracao configuracao) {
		ModelAndView model = new ModelAndView("configuracao/cadastro");
		model.addObject("localArquivo", ConfiguracaoService.DB_FILE_PATH);
		return model;
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public ModelAndView register(@Valid Configuracao configuracao, BindingResult result, Model model, RedirectAttributes redAttributes) {

		if (result.hasErrors()) {
			return newConfiguration(configuracao);
		}
		
		configuracaoService.save(configuracao);
		redAttributes.addFlashAttribute("mensagem", "Configuração salva com sucesso!");
		return new ModelAndView("redirect:/cadastro");
	}

	
	@RequestMapping("/database")
	public String listConfiguration(Model model) {

		model.addAttribute("localArquivo", ConfiguracaoService.DB_FILE_PATH);
		model.addAttribute("configuracoes", configuracaoService.listAllConfigurations());

		return "configuracao/lista";
	}

}
