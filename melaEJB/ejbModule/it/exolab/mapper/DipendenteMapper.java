package it.exolab.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import it.exolab.model.Dipendente;

public interface DipendenteMapper {
	
	void add(Dipendente dipendente);
	List<Dipendente> findAll();
	Dipendente tuttoDelDipendente(String id_dipendente);
	Dipendente findByEmailAndPassword(Dipendente dipendente);
	Dipendente dipendenteConContrattoAttuale(String id_dipendente);
	void update(Dipendente dipendente);
	Dipendente findById(String id_dipendente);
	Dipendente findByEmail(String email);
	Dipendente findPresenzeRelativeAlDipendenteConStatoMeseAperto(@Param("id_dipendente")int id_dipendente, @Param("id_mese") int id_mese);

}
