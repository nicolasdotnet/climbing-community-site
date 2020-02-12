package org.amisescalade.controller;

public interface IInputValidator {
	
	// TODO vérification de la saisie avec Spring Validator ?
	
	public Boolean ValidateCharacter(String input) throws Exception;

}
