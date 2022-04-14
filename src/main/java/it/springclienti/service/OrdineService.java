package it.springclienti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.springclienti.exception.OrdineException;
import it.springclienti.model.Ordine;
import it.springclienti.repository.OrdineRepository;

@Service
public class OrdineService {
	
	@Autowired
	OrdineRepository ordineRepo;
	
	public Page<Ordine> mostra(Pageable pageable){
		return ordineRepo.findAll(pageable);
	}
	
	public Ordine cerca(Long id) {
		Optional<Ordine> cerca = ordineRepo.findById(id);
		if(!cerca.isPresent()) {
			throw new OrdineException("ERRORE! Nessun ordine con questo ID!");
		}
		return cerca.get();
	}
	
	public Ordine inserisci(Ordine ordine) {
		return ordineRepo.save(ordine);
	}
	
	public void cancella(Long id) {
		Optional<Ordine> cerca = ordineRepo.findById(id);
		if(!cerca.isPresent()) {
			throw new OrdineException("ERRORE! Nessun ordine con questo ID!");
		}
		ordineRepo.deleteById(id);
	}
	

}
