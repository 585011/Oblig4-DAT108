package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "Obl4", name = "deltager")
public class Deltager {

	@Id
	private String mobilnr;

	private String fornavn;
	private String etternavn;
	private String hashpass;
	private String kjonn;

	@ManyToOne
	@JoinColumn(name = "deltagerliste_id", referencedColumnName = "id")
	private Deltagerliste deltagerliste;

	public Deltager(String fornavn, String etternavn, String mobil, String kjonn, String pass) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobilnr = mobil;
		this.kjonn = kjonn;
		this.hashpass = pass;
	}

	public String getMobilnr() {
		return mobilnr;
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
		return hashpass;
	}

	public void setHashpass(String hashpass) {
		this.hashpass = hashpass;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public void setMobilnr(String mobilnr) {
		this.mobilnr = mobilnr;
	}

	@Override
	public String toString() {
		return "Deltager [mobilnr=" + mobilnr + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", hashpass="
				+ hashpass + ", kjonn=" + kjonn + "]";
	}

}
