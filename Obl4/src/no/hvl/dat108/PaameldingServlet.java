package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaameldingServlet
 */
@WebServlet("/paamelding")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Redirecte? getRequestDispatcher til paameldingsbekreftelse?
//		String fornavn = request.getParameter("fornavn");
//		String etternavn = request.getParameter("etternavn");
//		String mobil = request.getParameter("mobil");
//		String passord = request.getParameter("passord");
//		String passordRep = request.getParameter("passordRepeter"); //treng kanskje ikkje dinna?
//		String kjonn = request.getParameter("kjonn");
//		
//		//M� hashe passorde og bruke det som passord i db
//		PassordUtil passUtil = new PassordUtil();
//		String hashPassord = passUtil.krypterPassord(passord);
//		
		
		
		//m� legge til deltager med DAO greier
		Deltagerliste deltagerliste = new Deltagerliste(request);
		if(deltagerliste.isAllInputGyldig()) {
			HttpSession sesjon = request.getSession(false);
			Deltager nyDeltager = deltagerliste.lagDeltager();
			deltagerDAO.lagreNyDeltager(nyDeltager);
//			deltagerDAO.oppdaterDeltagerliste(deltagerliste);
//			request.getSession().removeAttribute("deltagerliste");
//			request.setAttribute("deltagerliste", deltagerliste);
			if(sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);
			request.getSession().setAttribute("fornavn", deltagerliste.getFornavn());
			request.getSession().setAttribute("etternavn", deltagerliste.getEtternavn());
			request.getSession().setAttribute("mobil", deltagerliste.getMobil());
			request.getSession().setAttribute("passord", deltagerliste.getPassord());
			request.getSession().setAttribute("kjonn", deltagerliste.getKjonn());
			request.setAttribute("deltagerliste", deltagerliste);
//			request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
			
			response.sendRedirect("paameldingsbekreftelse");
		} else {
			deltagerliste.settOppFeilMeldinger();
			request.setAttribute("deltagerliste", deltagerliste);
			response.sendRedirect("paamelding");
		}
		
		//Litt rart � sende til jsp'en sia forward skal skje i doPost()?
		//Bruka sendRedirect() forel�pig
//		response.sendRedirect("paameldingsbekreftelse.html");
//		request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
	}
}
