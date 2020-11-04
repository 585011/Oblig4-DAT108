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
 * Servlet implementation class LogginnServlet
 */
@WebServlet("/logginn")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginMessage = "";
		if (request.getParameter("invalidlogin") != null) {
			loginMessage = "Ugyldig brukernavn og/eller passord";
		}

		request.setAttribute("loginMessage", loginMessage);

		// forwarde til JSP skal alltid skje i doGet()
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobilnr = request.getParameter("mobil");
		String passord = request.getParameter("passord");

		Deltager d1 = deltagerDAO.hentDeltager(mobilnr);
		if (mobilnr == null || d1 == null) {
			response.sendRedirect("loginn?invalidlogin");
		} else {
			if(riktigPassordOk(passord, d1.getHashpass()) ) {
				loggInn(request, d1);
				response.sendRedirect("deltagerliste");
			} else {
				response.sendRedirect("loginn?invalidlogin");
			}
		}
		response.sendRedirect("deltagerliste");
	}

	private static boolean loggetInn(HttpServletRequest req) {
		HttpSession sesjon = req.getSession(false);
		if (sesjon.getAttribute("LoggetInn") != null) {
			return true;
		}
		return false;
	}

	public static void loggInn(HttpServletRequest req, Deltager delt) {
		HttpSession sesjon = req.getSession(true);
		sesjon.setAttribute("fornavn", delt.getFornavn());
		sesjon.setAttribute("etternavn", delt.getEtternavn());
		sesjon.setAttribute("mobil", delt.getMobilnr());
		sesjon.setAttribute("passord", delt.getHashpass());
		sesjon.setAttribute("kjonn", delt.getKjonn());
		sesjon.setAttribute("LoggetInn", "LI");
	}

	public static void loggUt(HttpServletRequest req) {
		HttpSession sesjon = req.getSession(false);
		if (sesjon != null) {
			sesjon.invalidate();
		}
	}
	
	private boolean riktigPassordOk(String pass, String riktigPass) {
		PassordUtil pwUtil = new PassordUtil();
		return pwUtil.sjekkPassord(pass, riktigPass);
//		String hashPass = riktigPass.getPwd_hash();
//		String salte = riktigPass.getPwd_salt();
//		return Passordhjelper.validerMedSalt(pass, salte, hashPass);
	}

}
