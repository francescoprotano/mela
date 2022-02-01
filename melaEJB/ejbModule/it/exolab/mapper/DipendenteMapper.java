package it.exolab.mapper;

import java.util.List;

import it.exolab.model.Dipendente;

public interface DipendenteMapper {
	
	void add(Dipendente dipendente);
	List<Dipendente> findAll();

}
