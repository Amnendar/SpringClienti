package it.springclienti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import it.springclienti.exception.ClienteException;
import it.springclienti.model.Cliente;
import it.springclienti.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	

	//CRUD base
	
	@GetMapping("/mostra")
	@Operation(summary = "Mostra Tutti Clienti", description = "Restituisce tutti i clienti presenti nel sistema")
	public ResponseEntity<Page<Cliente>> mostraTutti(Pageable pageable){
		Page<Cliente> clienti = clienteService.mostraTutti(pageable);
		if(clienti.hasContent()) {
			return new ResponseEntity<>(clienti, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>(clienti, HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping("/cerca/{id}")
	@Operation(summary = "Mostra Tutti Clienti", description = "Restituisce tutti i clienti presenti nel sistema")
	public ResponseEntity<Cliente> cerca(@PathVariable Long id) throws ClienteException{
		Cliente cerca = clienteService.trovaPerId(id);
		return new ResponseEntity<>(cerca, HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/inserisci")
	@Operation(summary = "", description = "")
	public ResponseEntity<Cliente> inserisci(@RequestBody Cliente cliente){
		clienteService.salva(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	@Operation(summary = "", description ="")
	public ResponseEntity<String> cancella(@PathVariable Long id) throws ClienteException {
		clienteService.cancella(id);
		return new ResponseEntity<>("Cliente cancellato correttamente!", HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/aggiorna/{id}")
	@Operation(summary = "", description ="")
	public ResponseEntity<Cliente> aggiorna(@PathVariable Long id, @RequestBody Cliente cliente) throws ClienteException{
		clienteService.aggiorna(id, cliente);
		return new ResponseEntity<>(cliente, HttpStatus.ACCEPTED);
	}
	
	
	
	
}
