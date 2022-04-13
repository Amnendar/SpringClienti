package it.springclienti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.springclienti.model.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

}
