package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

public class Validator {

	public static final String ANY_LETTER = "[a-zA-Z������]";
	public static final String UPPERCASE_FIRST = "[A-Z���]";

	public boolean isAllInputGyldig(HttpServletRequest req) {
		return isValidFirstname(req.getParameter("fornavn")) && 
				isValidLastname(req.getParameter("etternavn")) &&
				isValidMobil(req.getParameter("mobil")) &&
				passordMinlengde(req.getParameter("passord")) &&
				liktPassord(req.getParameter("passord"), req.getParameter("passordRepeter"));

	}

	public static boolean isValidFirstname(String fornavn) {
		if (fornavn == null) {
			return false;
		}
		return fornavn.matches("^" + UPPERCASE_FIRST + "[a-zA-Z������\\s-]{1,19}$");
	}

	public static boolean isValidLastname(String etternavn) {
		if (etternavn == null) {
			return false;
		}
		return etternavn.matches("^" + UPPERCASE_FIRST + "[a-zA-Z������-]" + "{1,19}$");
	}

	public static boolean isValidMobil(String mobil) {
		if (mobil == null) {
			return false;
		}
		return mobil.matches("^\\d{8}$");
	}

	public static boolean passordMinlengde(String pass) {
		if (pass == null) {
			return false;
		}
		return pass.matches("[a-zA-Z������0-9]{4,}$");
	}

	public static boolean liktPassord(String pass1, String pass2) {
		return pass1.equals(pass2);
	}
}
