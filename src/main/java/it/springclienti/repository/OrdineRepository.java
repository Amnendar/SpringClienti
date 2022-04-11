package it.springclienti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.springclienti.model.Ordine;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {

}
