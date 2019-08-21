package org.olddriver.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LearnController {
	
	@RequestMapping(value= {"/learnController"})
	public String learnController(Model model) {
		model.addAttribute("learnModel", "learnModel");
		return "index";
	}
	
	@RequestMapping(value= {"/learnRequestParam"})
	public String learnRequestParam(@RequestParam String learnRequestParam) {
		System.out.println(learnRequestParam);
		return "index";
	}
}
