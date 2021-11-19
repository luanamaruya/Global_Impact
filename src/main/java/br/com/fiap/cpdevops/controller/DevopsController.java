package br.com.fiap.cpdevops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.cpdevops.exception.InvestNotFoundException;
import br.com.fiap.cpdevops.model.Invest;
import br.com.fiap.cpdevops.service.InvestService;


@Controller
@RequestMapping
public class DevopsController {
	
	@Autowired
	private InvestService service;
	

	
	@GetMapping("/")
	public String invest(Model model) {
		List<Invest> listInvests = service.listAll();
		model.addAttribute("listInvest", listInvests);
		model.addAttribute("pageTitle", "D.INVEST");
		return "index";
	}
	
	@GetMapping("/cadastroInvest")
	public String newInvest(Model model) {
		//model.addAttribute("invest", "");
		model.addAttribute("invest", new Invest());
		model.addAttribute("pageTitle", "Novo Aporte");
		return "cadastroInvest";
	}
	
	
	@PostMapping("/index/save")
	public String saveInvest(Invest invest, RedirectAttributes ra) {
		service.save(invest);
		ra.addFlashAttribute("message", "Aporte realizado com sucesso!");
		return "redirect:/";
	}
	
	
	@GetMapping("/invest/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
		try {
			Invest invest = service.getById(id);
			model.addAttribute("invest", invest);
			model.addAttribute("pageTitle", "Atualizar Investimento" + id);
			return "cadastroInvest";
		} catch (InvestNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
			return "redirect:/";
		}
	}
	
	@GetMapping("invest/delete/{id}")
	public String deleteInvest(@PathVariable("id") Long id, RedirectAttributes ra) {
		try {
			service.deleteById(id);
			ra.addFlashAttribute("message", "Aporte posicao" + id + "deletado do sistema.");
		} catch (Exception e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/";
	}
	
}
