package no.hvl.dat108;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="Obl4", name="deltagerliste")
public class Deltagerliste {
	
	@Id
	private int id;
	
	@OneToMany(mappedBy = "deltagerliste", fetch = FetchType.EAGER)
	private List<Deltager> deltagere;

	public int getId() {
		return id;
	}
	
	public List<Deltager> hentDeltagere() {
		return deltagere;
	}
	public void leggTilDeltager(Deltager deltager) {
		deltagere.add(deltager);
	}
}
