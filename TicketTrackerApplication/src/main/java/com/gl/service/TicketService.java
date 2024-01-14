package com.gl.service;

import java.util.List;

import com.gl.entity.Ticket;

public interface TicketService {

	public List<Ticket> findAll();

	public void save(Ticket theTicket);

	public Ticket findbyId(int ticketId);

	public void deleteById(int ticketId);
	
	public List<Ticket> search(String keywords);
}