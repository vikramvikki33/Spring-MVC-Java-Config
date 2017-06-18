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

import com.sounds.bvs.data.domain.Clients;
import com.sounds.bvs.data.service.ClientsService;

@Controller
@RequestMapping("/admin_clients")
public class ClientController {
	private static final Logger logger = Logger.getLogger(ClientController.class.getName());

	@Autowired
	private ClientsService clientsService;


	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public String goToClient(Model model) {
		logger.info("Invoking goToClients");
		model.addAttribute("clients" , this.clientsService.findAll());
		return "clients_list";
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long clientId, Model model) {
		logger.info("Invoking edit" + clientId);
		model.addAttribute("clients", this.clientsService.findById(clientId));
		return "add_client";
	}

	@RequestMapping(value="/add_client")
	public String addClient(Model model) {
		logger.info("Invoking addClient");
		model.addAttribute("clients", new Clients());
		return "add_client";
	}

	@RequestMapping(value="/save_client", method=RequestMethod.POST)
	public String saveClient(@Valid @ModelAttribute Clients clients, Errors errors) {
		logger.info("Invoking saveClient and client id is " + clients.getId());
		if (errors.hasErrors()) return "add_client";
		if(clients.getId() == null) {
			this.clientsService.save(clients);
		}else {
			this.clientsService.update(clients);
		}

		return back();
	}

	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String removeClient(@PathVariable("id") Long clientId) {
		logger.info("Calling deleting the clientId" + clientId);
		this.clientsService.delete(clientId);
		return back();
	}

	@RequestMapping(value="/back_to_client")
	public String back() {
		return "redirect:/admin_clients/clients";
	}
}
