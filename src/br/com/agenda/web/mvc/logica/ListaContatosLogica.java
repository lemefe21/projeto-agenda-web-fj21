package br.com.agenda.web.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.web.dao.ContatoDAO;
import br.com.agenda.web.modelo.Contato;
import br.com.agenda.web.mvc.interfaces.Logica;

public class ListaContatosLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connection = (Connection) request.getAttribute("conexao");
		
		//inversão de controle - ContatoDAO não cria mais a conexão com o banco
		//injeção de dependência - ContatoDAO agora passa a depender de uma conexão para ser criado 
		List<Contato> listaContatos = new ContatoDAO(connection).getLista();

		request.setAttribute("listaContatos", listaContatos);

		return "WEB-INF/jsp/lista-contatos.jsp";
	}

}
