package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query(value = "SELECT * FROM tickets t WHERE t.id like %:keywords% or t.title like %:keywords% or t.description like %:keywords% or t.date_created_on like :keywords", nativeQuery = true)
    List<Ticket> findByKeywords(@Param("keywords") String keywords);
}
