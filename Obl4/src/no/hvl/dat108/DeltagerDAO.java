package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltagerDAO {

	@PersistenceContext(name="deltagerPU")
	private EntityManager em;
	
	public List<Deltager> hentAlleBrukere(){
		return em.createQuery("SELECT d FROM Deltager d ORDER BY d.fornavn", Deltager.class).getResultList();
	}
	
	public Deltager hentDeltager(String mobilnr) {
		return em.find(Deltager.class, mobilnr);
	}
//	public synchronized Deltagerliste hentDeltagerliste(int id) {
//		return em.find(Deltagerliste.class, id);
//	}
	public void lagreNyDeltager(Deltager deltager) {
		em.persist(deltager);
	}
	
	public void oppdaterDeltagerliste(Deltagerliste deltagerliste) {
		em.merge(deltagerliste);
	}
	
}
