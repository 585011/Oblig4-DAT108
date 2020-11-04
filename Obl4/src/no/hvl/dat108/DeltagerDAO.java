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
		return em.createQuery("SELECT d FROM Deltager d ORDER BY fornavn", Deltager.class).getResultList();
	}
	
	public synchronized Deltager hentDeltager(String mobilnr) {
		return em.find(Deltager.class, mobilnr);
	}
	public synchronized Deltagerliste hentDeltagerliste(int id) {
		return em.find(Deltagerliste.class, id);
	}
	public synchronized void lagreNyDeltager(Deltager deltager) {
		em.persist(deltager);
	}
	
	public void oppdaterDeltagerliste(Deltagerliste deltagerliste) {
		em.merge(deltagerliste);
	}
	
}
