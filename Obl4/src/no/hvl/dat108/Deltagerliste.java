package no.hvl.dat108;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

public class Deltagerliste {
	public static final String ANY_LETTER = "[a-zA-ZÊ¯Â∆ÿ≈]";
	public static final String UPPERCASE_FIRST = "[A-Z∆ÿ≈]";

	private String fornavn;
	private String etternavn;
	private String mobil;
	private String passord;
	private String repeterPassord;
	private String kjonn;

	private String fornavnF;
	private String etternavnF;
	private String mobilF;
	private String passordF;
	private String repeterPassordF;
//	private String kjonnF;

	public Deltagerliste() {

	}

	public Deltagerliste(HttpServletRequest req) {
		this.fornavn = req.getParameter("fornavn");
		this.etternavn = req.getParameter("etternavn");
		this.mobil = req.getParameter("mobil");
		this.passord = req.getParameter("passord");
		this.repeterPassord = req.getParameter("passordRepetert");
		this.kjonn = req.getParameter("kjonn");
	}

	public boolean isAllInputGyldig() {
		return isValidFirstname() && isValidLastname() && isValidMobil() && 
				passordMinlengde() && liktPassord();
	}

	public boolean isValidFirstname() {
		return fornavn != null && fornavn.matches("^" + UPPERCASE_FIRST + "[a-zA-ZÊ¯Â∆ÿ≈\\s-]{1,19}$");
	}

	public boolean isValidLastname() {
		return etternavn != null && etternavn.matches("^" + UPPERCASE_FIRST + "[a-zA-ZÊ¯Â∆ÿ≈-]" + "{1,19}$");
	}

	public boolean isValidMobil() {
		return mobil != null && mobil.matches("^\\d{8}$");
	}

	public boolean passordMinlengde() {
		return passord != null && passord.matches("[a-zA-ZÊ¯Â∆ÿ≈0-9]{4,}$");
	}

	public boolean liktPassord() {
		return passord.equals(repeterPassord);
	}
	
	public void settOppFeilMeldinger() {
		if(!isValidFirstname()) {
			fornavn = "";
			fornavnF = "Ugyldig fornavn";
		}
		if(!isValidLastname()) {
			etternavn = "";
			etternavnF = "Ugyldig etternavn";
		}
		if(!isValidMobil()) {
			mobil = "";
			mobilF = "Ugyldig mobilnummer";
		}
		if(!passordMinlengde()) {
			passord = "";
			passordF = "Ugyldig passord";
		}
		if(!liktPassord()) {
			repeterPassord = "";
			repeterPassordF = "MÂ vÊre likt som passord";
		}
	}

	public static String getAnyLetter() {
		return ANY_LETTER;
	}

	public static String getUppercaseFirst() {
		return UPPERCASE_FIRST;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public String getPassord() {
		return passord;
	}

	public String getRepeterPassord() {
		return repeterPassord;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getFornavnF() {
		return fornavnF;
	}

	public String getEtternavnF() {
		return etternavnF;
	}

	public String getMobilF() {
		return mobilF;
	}

	public String getPassordF() {
		return passordF;
	}

	public String getRepeterPassordF() {
		return repeterPassordF;
	}

	public Deltager lagDeltager() {
//		Passord pass = Passord.lagPassord(passord);
		PassordUtil pwUtil = new PassordUtil();
		passord = pwUtil.krypterPassord(passord);
		
//		String pass1 = Pas
		return new Deltager(fornavn, etternavn, mobil, passord, kjonn);
	}
	
}
