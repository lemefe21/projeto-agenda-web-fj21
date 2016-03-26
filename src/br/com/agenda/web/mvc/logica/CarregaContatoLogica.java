package br.com.agenda.web.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.web.dao.ContatoDAO;
import br.com.agenda.web.modelo.Contato;
import br.com.agenda.web.mvc.interfaces.Logica;

public class CarregaContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connection = (Connection) request.getAttribute("conexao");
		
		if(request.getParameter("id") != null) {

			String idContato = request.getParameter("id");
			Contato contato = new ContatoDAO(connection).buscaPorID(Long.parseLong(idContato));
			request.setAttribute("idContato", contato.getId());
			request.setAttribute("nomeContato", contato.getNome());
			request.setAttribute("emailContato", contato.getEmail());
			request.setAttribute("enderecoContato", contato.getEndereco());
			request.setAttribute("dataNascimentoContato", contato.getDataFormatada());

		}

		return "WEB-INF/jsp/formulario-contatos.jsp";

	}

}
