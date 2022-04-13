package it.springclienti.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.springclienti.model.Cliente;
import it.springclienti.model.Ordine;
import it.springclienti.model.Prodotto;
import it.springclienti.model.ProdottoAlimentare;
import it.springclienti.repository.ClienteRepository;
import it.springclienti.repository.OrdineRepository;
import it.springclienti.repository.ProdottoRepository;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	ProdottoRepository prodottoRepo;
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	OrdineRepository ordineRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		Prodotto smartphone = new Prodotto();
		smartphone.setMarca("Apple");
		smartphone.setNome("Apple Iphone");
		smartphone.setPrezzo(1000.00);
		prodottoRepo.save(smartphone);
		
		Prodotto cuffie = new Prodotto();
		cuffie.setMarca("Razer");
		cuffie.setNome("Razer Abyssus");
		cuffie.setPrezzo(69.99);
		prodottoRepo.save(cuffie);
		
		ProdottoAlimentare carne = new ProdottoAlimentare();
		carne.setCalorie(300);
		carne.setMarca("Amadori");
		carne.setNome("Polpettone Amadori");
		carne.setPrezzo(4.99);
		carne.setTipoAlimento("Carne");
		carne.setVegan(false);
		prodottoRepo.save(carne);
		
		Cliente cliente1 = new Cliente();
		cliente1.setCognome("Zucchetti");
		cliente1.setNome("Maria");
		cliente1.setNumeroTelefonico("3287722344");
		clienteRepo.save(cliente1);
		
		
		Ordine ordine1 = new Ordine();
		ordine1.setCliente(cliente1);
		List<Prodotto> prodottiOrdine1 = new ArrayList<>();
		prodottiOrdine1.add(carne);
		prodottiOrdine1.add(carne);
		prodottiOrdine1.add(cuffie);
		ordine1.setProdotti(prodottiOrdine1);
		ordineRepo.save(ordine1);
		
		
		
		
	}

}
