package br.com.agenda.web.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.web.dao.ContatoDAO;
import br.com.agenda.web.modelo.Contato;
import br.com.agenda.web.mvc.interfaces.Logica;

public class GerenciadorContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(request.getParameter("id") != null) {

			Contato contato = new ContatoDAO().buscaPorID(Long.parseLong(request.getParameter("id")));
			request.setAttribute("idContatoAlterar", request.getParameter("id"));
			//request.setAttribute("nomeAlterar", request.getParameter("id"));
			//request.setAttribute("endereco", request.getParameter("id"));
			//request.setAttribute("idContatoAlterar", request.getParameter("id"));

			return "gerencia-contatos.jsp";

		}else {

			//para novo contato id == null, não setamos os atributos
			return "gerencia-contatos.jsp";

		}

	}

}
