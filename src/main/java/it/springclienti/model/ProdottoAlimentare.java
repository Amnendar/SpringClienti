package it.springclienti.model;

import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "alimentareId")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdottoAlimentare extends Prodotto {

	
	private int calorie;
	private String tipoAlimento;
	private boolean isVegan;
	
	
	
}
