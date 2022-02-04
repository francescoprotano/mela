package it.exolab.validation;

import it.exolab.model.Dipendente;

public class Validation {
	
	
	private boolean checkEmail(String email) {
		if(email.contains(".") && email.contains("@") && 
				email.length()>10 && email.length()<30 ) {
			return true;
		}else return false;
	}
	
	private boolean checkNome(String nome) {
		if(!nome.matches("^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z._]+(?<![_.])$")){
			return false;
		}else return true;
	}
	
	private boolean checkCognome(String cognome) {
		if(!cognome.matches("^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z._]+(?<![_.])$")){
			return false;
		}else return true;
	}
	
	private boolean checkPassword(String password) {
		if(password.length()>6) {
			return true;
		}else return false;
	}
	
	
	
	
	public boolean checkNominativo(String nome, String cognome) {
		if( checkNome(nome) && checkCognome(cognome)) {
			return true;
		}else return false;
	}
	
	public boolean checkEmailAndPassword(String email, String password) {
		if(checkEmail(email) && checkPassword(password)) {
			return true;
		}else return false;
	}
	
	public boolean checkDipendente(Dipendente dipendente) {
		if(checkNominativo(dipendente.getNome(),dipendente.getCognome())) {
			return false;
		}else if(checkEmailAndPassword(dipendente.getEmail(), dipendente.getPassword())) {
			return false;
		}else return true;
	}

}
