package it.springclienti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.springclienti.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
	
	
}
