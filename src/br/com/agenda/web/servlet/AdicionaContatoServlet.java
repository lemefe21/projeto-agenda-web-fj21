package br.com.agenda.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.web.dao.ContatoDAO;
import br.com.agenda.web.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataParam = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataParam);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			out.println("Erro na conversão da data de nascimento!");
			return; //para a execu��o do m�todo
		}

		Contato contato = new Contato(nome, email, endereco, dataNascimento);

		Connection connection = (Connection) request.getAttribute("conexao");
		ContatoDAO dao = new ContatoDAO(connection);
		dao.adiciona(contato);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/contato-adicionado.jsp");
		dispatcher.forward(request, response);


	}

}
