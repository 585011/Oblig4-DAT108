package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//		//Må hashe passorde og bruke det som passord i db
//		PassordUtil passUtil = new PassordUtil();
//		String hashPassord = passUtil.krypterPassord(passord);
//		
		//må legge til deltager med DAO greier
		Deltagerliste deltagerliste = new Deltagerliste(request);
		if(deltagerliste.isAllInputGyldig()) {
			Deltager nyDeltager = deltagerliste.lagDeltager();
			deltagerDAO.lagreNyDeltager(nyDeltager);
			deltagerDAO.oppdaterDeltagerliste(deltagerliste);
			request.getSession().removeAttribute("deltagerliste");
//			request.setAttribute("deltagerliste", deltagerliste);
//			request.setAttribute("fornavn", fornavn);
//			request.setAttribute("etternavn", etternavn);
//			request.setAttribute("mobil", mobil);
//			request.setAttribute("passord", hashPassord);
//			request.setAttribute("kjonn", kjonn);
//			request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
			response.sendRedirect("paameldingsbekreftelse.html");
		} else {
			deltagerliste.settOppFeilMeldinger();
			request.setAttribute("deltagerliste", deltagerliste);
			response.sendRedirect("paamelding");
		}
		
		//Litt rart å sende til jsp'en sia forward skal skje i doPost()?
		//Bruka sendRedirect() foreløpig
//		response.sendRedirect("paameldingsbekreftelse.html");
//		request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
	}
}
