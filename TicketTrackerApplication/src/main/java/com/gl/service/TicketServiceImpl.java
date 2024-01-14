package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.TicketRepository;
import com.gl.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public void save(Ticket theTicket) {
		// TODO Auto-generated method stub
		ticketRepository.save(theTicket);
	}

	@Override
	public Ticket findbyId(int ticketId) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(ticketId).get();
	}

	@Override
	public void deleteById(int ticketId) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(ticketId);
	}

	@Override
	public List<Ticket> search(String keywords) { 
        return ticketRepository.findByKeywords(keywords); 
    } 
}