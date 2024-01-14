package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.entity.Ticket;
import com.gl.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketsController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/list")
	public String listTickets(Model model) {
		List<Ticket> tickets = ticketService.findAll();

		model.addAttribute("tickets", tickets);
		return "tickets/list-tickets";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		List<Ticket> tickets = ticketService.search(keyword);

		model.addAttribute("tickets", tickets);
		return "tickets/list-tickets";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute(ticket);
		return "tickets/tickets-form";
	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket theTicket) {

		// save the ticket pobject
		ticketService.save(theTicket);
		return "redirect:/tickets/list";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ticketId") int ticketId, Model model) {

		// get the ticket from the database
		Ticket theTicket = ticketService.findbyId(ticketId);
		model.addAttribute("ticket", theTicket);
		return "tickets/tickets-form";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("ticketId") int ticketId, Model model) {
		ticketService.deleteById(ticketId);
		return "redirect:/tickets/list";
	}

	@PostMapping("/viewTicket")
	public String viewTicket(@RequestParam("ticketId") int ticketId, Model model) {

		// get the ticket from the database
		Ticket theTicket = ticketService.findbyId(ticketId);
		model.addAttribute("ticket", theTicket);
		return "tickets/view-ticket";
	}

}
