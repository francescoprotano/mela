package it.exolab.mapper;

import java.util.List;

import it.exolab.model.Mese;

public interface MeseMapper {
	
	List<Mese> findAll();
	void updateChiuso(Mese mese);

}
