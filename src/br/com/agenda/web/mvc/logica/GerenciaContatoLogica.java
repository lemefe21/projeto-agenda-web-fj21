package br.com.agenda.web.mvc.logica;

import java.rmi.ServerException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.web.dao.ContatoDAO;
import br.com.agenda.web.factory.ConnectionFactory;
import br.com.agenda.web.modelo.Contato;
import br.com.agenda.web.mvc.interfaces.Logica;

public class GerenciaContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String idContato = request.getParameter("idContato");

		Calendar dataNascimento = null;
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			throw new ServerException("A lógica de negócios causou uma exceção.", e);
		}

		Contato contato = new Contato(
				request.getParameter("nome"),
				request.getParameter("email"),
				request.getParameter("endereco"),
				dataNascimento);

		Connection connection = (Connection) request.getAttribute("conexao");
		ContatoDAO dao = new ContatoDAO(connection);

		if(idContato != null) {

			contato.setId(Long.parseLong(idContato));
			dao.alteraContato(contato);
			return "mvc?logica=ListaContatosLogica";

		}else {

			dao.adiciona(contato);
			return "mvc?logica=ListaContatosLogica";

		}

	}

}
