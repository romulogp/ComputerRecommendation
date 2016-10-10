package br.com.rgp.rbccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComputerController {

	@RequestMapping("/search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("/register-configuration")
	public String registerConfiguration() {
		return "computer/register-configuration";
	}
		
}
