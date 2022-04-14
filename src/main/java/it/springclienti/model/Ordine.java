package it.springclienti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @ManyToOne
    @NotNull
	private Cliente cliente;
    @ManyToMany
	private List<Prodotto> prodotti;
    
    
    public double calcolaTotale() {
    	double totale = 0;
    	for (Prodotto prodotto : prodotti) {
			totale += prodotto.getPrezzo();
		}
    	return totale;
    }
	

}
