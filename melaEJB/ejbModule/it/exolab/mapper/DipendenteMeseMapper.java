package it.exolab.mapper;


import it.exolab.model.DipendenteMese;
import it.exolab.model.Presenza;

public interface DipendenteMeseMapper {
	
	void add(Presenza presenza);
	DipendenteMese find(DipendenteMese dipendenteMese);
	void updateStato(DipendenteMese dipendenteMese);

}
