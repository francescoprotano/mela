package it.exolab.mapper;

import java.util.List;

import it.exolab.model.Contratto;

public interface ContrattoMapper {
	
	void add(Contratto contratto);
	List<Contratto> findAll();
}
