package br.com.rgp.rbc.controller;

import java.util.List;

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
import br.com.rgp.rbc.model.ConfiguracaoSimilaridade;
import br.com.rgp.rbc.service.ConfiguracaoService;
import br.com.rgp.rbc.service.IConfiguracaoService;
import br.com.rgp.rbc.service.IRecommendationService;
import br.com.rgp.rbc.service.RecommendationService;

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
		return new ModelAndView("redirect:/resultadoPesquisa");
	}

	@RequestMapping("/resultadoPesquisa")
	public String searchResult(Model model) {
		List<ConfiguracaoSimilaridade> confSm = recommendationService.searchForRecommendedConfigurations(new Configuracao("teste"));
		System.out.println(confSm.size());
//		model.addAttribute("configuracoes", recommendationService.searchForRecommendedConfigurations(searchConfig));
		model.addAttribute("configuracoes", confSm);
		
		return "configuracao/resultadoPesquisa";
	}
	
	@RequestMapping("/cadastro")
	public ModelAndView newConfiguration(Configuracao configuracao) {
		return new ModelAndView("configuracao/cadastro");
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

		model.addAttribute("configuracoes", configuracaoService.listAllConfigurations());

		return "configuracao/lista";
	}

//	public static void main(String[] args) {
//		IRecommendationService recommendationService = new RecommendationService();
//		recommendationService.searchForRecommendedConfigurations(new Configuracao("teste"));
//	}
	
}
