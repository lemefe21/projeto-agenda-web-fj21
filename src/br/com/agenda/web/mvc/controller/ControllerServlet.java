package br.com.agenda.web.mvc.controller;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.web.mvc.interfaces.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{

	private static final long serialVersionUID = 7414463475675903060L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parametro = request.getParameter("logica");  //ex: mvc?logica= (PrimeiraLogica)
		String nomeDaClasse = "br.com.agenda.web.mvc.logica." + parametro; //path da classe PrimeiraLogica exemplo

		try {

			Class<?> classe = Class.forName(nomeDaClasse);

			//cria uma instancia por
			//polimorfismo para executar as logicas
			Logica logica = (Logica) classe.newInstance();

			//chama o método executa de cada classe que implementa a interface Logica
			String pagina = logica.executa(request, response);

			//encaminha para o retorno do método executa(request, response)
			request.getRequestDispatcher(pagina).forward(request, response);

		}catch(Exception e) {
			throw new ServerException("A lógica de negócios causou uma exceção.", e);
		}

	}

}
