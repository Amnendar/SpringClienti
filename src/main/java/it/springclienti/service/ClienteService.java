package it.springclienti.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.springclienti.exception.ClienteException;
import it.springclienti.model.Cliente;
import it.springclienti.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	
	public Page<Cliente> mostraTutti(Pageable pageable){
		return clienteRepo.findAll(pageable);
	}
	
	
	public Cliente trovaPerId(Long id) throws ClienteException {
		Optional<Cliente> cerca = clienteRepo.findById(id);
		if(!cerca.isPresent()) {
			throw new ClienteException("ERRORE! Nessun cliente con questo ID!");
		}
		else {
			return cerca.get();
		}
	}
	
	
	public Cliente salva(Cliente cliente) {
		cliente.setDataInserimento(LocalDate.now());
		return clienteRepo.save(cliente);
	}
	
	
	public void cancella(Long id) throws ClienteException {
		Optional<Cliente> trova = clienteRepo.findById(id);
		if(!trova.isPresent()) {
			throw new ClienteException("ERRORE! Nessun cliente con questo ID!");
		}
		else {
			Cliente cancella = trova.get();
			clienteRepo.delete(cancella);
			System.out.println("Cliente cancellato correttamente!");
		}
	}
	
	
	public Cliente aggiorna(Long id, Cliente aggiornare) throws ClienteException {
		Optional<Cliente> cerca = clienteRepo.findById(id);
		if(!cerca.isPresent()) {
			throw new ClienteException("ERRORE! Nessun cliente con questo ID!");
		}
		Cliente aggiorna = cerca.get();
		aggiorna.setCognome(aggiornare.getCognome());
		aggiorna.setDataInserimento(aggiornare.getDataInserimento());
		aggiorna.setNome(aggiornare.getNome());
		aggiorna.setId(aggiorna.getId());
		aggiorna.setNumeroTelefonico(aggiornare.getNumeroTelefonico());
		aggiorna.setOrdini(aggiornare.getOrdini());
		return aggiorna;
	}
	
	
	

}
