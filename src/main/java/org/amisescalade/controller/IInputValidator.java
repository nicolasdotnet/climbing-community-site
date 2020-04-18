package org.amisescalade.controller;

public interface IInputValidator {
	
	// TODO vérification de la saisie avec Spring Validator ?
	
	public Boolean validateCharacter(String input) throws Exception;
        
        public Boolean validateIsEmpty (String input) throws Exception;

}
