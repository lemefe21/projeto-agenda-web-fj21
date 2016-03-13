package br.com.agenda.web.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.web.dao.ContatoDAO;
import br.com.agenda.web.modelo.Contato;
import br.com.agenda.web.mvc.interfaces.Logica;

public class ListaContatosLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Contato> listaContatos = new ContatoDAO().getLista();

		request.setAttribute("listaContatos", listaContatos);

		return "WEB-INF/jsp/lista-contatos.jsp";
	}

}
