package it.springclienti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordine {
	
	@Id
	private Long id;
    @ManyToOne
	private Cliente cliente;
    @ManyToMany
	private List<Prodotto> prodotti;
	

}
