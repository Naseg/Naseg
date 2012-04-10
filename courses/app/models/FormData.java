package models;

import authtoken.validator.AuthenticityToken;

/* FACILE CHE NON SERVE A UN NIENTE */

public class FormData {

	@AuthenticityToken
	public String authtoken;

	public String name;

}

