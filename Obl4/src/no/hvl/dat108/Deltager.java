package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "obl4", name = "deltager")
public class Deltager {

	@Id
	private String mobil;

	private String fornavn;
	private String etternavn;
	private String passord;
	private String kjonn;

//	@ManyToOne
//	@JoinColumn(name = "deltagerliste_id", referencedColumnName = "id")
//	private Deltagerliste deltagerliste;

	public Deltager() {
		
	}
	
	public Deltager(String fornavn, String etternavn, String mobil, String pass, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.kjonn = kjonn;
		this.passord = pass;
	}

	public String getMobilnr() {
		return mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getHashpass() {
		return passord;
	}

	public void setHashpass(String hashpass) {
		this.passord = hashpass;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public void setMobilnr(String mobilnr) {
		this.mobil = mobilnr;
	}

	@Override
	public String toString() {
		return "Deltager [mobilnr=" + mobil + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", passord="
				+ passord + ", kjonn=" + kjonn + "]";
	}

}
