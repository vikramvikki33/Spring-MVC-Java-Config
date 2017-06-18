package com.sounds.bvs.controllers;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sounds.bvs.data.domain.SubClients;
import com.sounds.bvs.data.service.SubClientsService;

@Controller
@RequestMapping("/admin_subclients")
public class SubClientsController {

	private static final Logger logger = Logger.getLogger(ClientController.class.getName());

	@Autowired
	private SubClientsService subClientsService;


	@RequestMapping(value="/subClients", method=RequestMethod.GET)
	public String goToClient(Model model) {
		logger.info("Invoking goToSubClients");
		model.addAttribute("subClients" , this.subClientsService.findAll());
		return "subclients_list";
	}

	@RequestMapping(value="/edit_subClient/{clientId}", method=RequestMethod.GET)
	public String edit(@PathVariable("clientId") int clientId, Model model) {
		logger.info("Invoking subClient edit");
		model.addAttribute("clients", this.subClientsService.findById(clientId));
		return "add_subclient";
	}

	@RequestMapping(value="/add_subClient")
	public String addClient(Model model) {
		logger.info("Invoking subclient add");
		model.addAttribute("subClients", new SubClients());
		return "add_subclient";
	}

	@RequestMapping(value="/save_subClient", method=RequestMethod.POST)
	public String saveClient(@Valid @ModelAttribute SubClients subclients, Errors errors) {
		logger.info("Invoking saveClient and client id is " + subclients.getId());
		if (errors.hasErrors()) return "add_client";
		if(subclients.getId() == 0) {
			this.subClientsService.save(subclients);
		}else {
			this.subClientsService.update(subclients);
		}

		return "redirect:/admin/subclients";
	}

	@RequestMapping(value="/remove_subClient/{clientId}", method=RequestMethod.GET)
	public String removeClient(@PathVariable("clientId") int clientId) {
		logger.info("Calling deleting the clientId" + clientId);
		this.subClientsService.delete(clientId);
		return "redirect:/admin/subclients";
	}

	@RequestMapping(value="/back_to_client")
	public String back() {
		return "redirect:/admin/clients";
	}
}
