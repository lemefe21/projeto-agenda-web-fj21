package br.com.agenda.web.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.web.dao.ContatoDAO;
import br.com.agenda.web.modelo.Contato;
import br.com.agenda.web.mvc.interfaces.Logica;

public class RemoveContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long id = Long.parseLong(request.getParameter("id"));

		Contato contato = new Contato();
		contato.setId(id);

		ContatoDAO dao = new ContatoDAO();
		dao.removeContato(contato);

		System.out.println("Excluindo contato " + contato.getId() + "...");

		//quem instancia a lista passa a ser a logica ListaContatosLogica
		//return "lista-contatos.jsp";

		return "mvc?logica=ListaContatosLogica";
	}

}
