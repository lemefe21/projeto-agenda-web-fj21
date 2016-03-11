package br.com.agenda.web.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Executando a logica...");
		System.out.println("Retornando a nome da página JSP...");

		return "primeira-logica.jsp";

	}

}
