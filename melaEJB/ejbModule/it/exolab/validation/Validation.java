package it.exolab.validation;

import it.exolab.exception.EmptyTextException;
import it.exolab.model.Dipendente;

public class Validation {
	
	
	public boolean checkEmail(String email) {
		if(email.contains(".") && email.contains("@") ) {
//				&& email.length()>10 && email.length()<30 ) {
			return true;
		}else return false;
	}
	
	public boolean checkPassword(String password) {
		if(password.length()>=6 && password.length()<30) {
			return true;
		}else return false;
	}
	
	private boolean checkNome(String nome) {
		if(nome.matches("^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z._]+(?<![_.])$")){
			return true;
		}else return false;
	}
	
	private boolean checkCognome(String cognome) {
		if(cognome.matches("^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z._]+(?<![_.])$")){
			return true;
		}else return false;
	}
	
	
	
	public boolean checkEmptyInput(Dipendente dipendente) throws EmptyTextException{
		if(dipendente.getCognome().equals("") || dipendente.getNome().equals("") ||
				dipendente.getEmail().equals("") || dipendente.getPassword().equals("")) {
			return false;
		}
		return true;
	}
		
	public boolean checkNullInput(Dipendente dipendente)  { //throws nullInputException
		if(dipendente.getCognome() == null || dipendente.getNome() == null ||
				dipendente.getEmail() == null || dipendente.getPassword() == null) {
			return false;
		}
		return true;
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
