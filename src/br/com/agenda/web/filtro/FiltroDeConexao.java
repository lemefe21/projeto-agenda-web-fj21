package br.com.agenda.web.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.agenda.web.factory.ConnectionFactory;

@WebFilter("/*")
public class FiltroDeConexao implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		try(Connection connection = ConnectionFactory.getInstance().getConnection()){
			
			//pendura o objeto connection no request
			request.setAttribute("conexao", connection);
			
			chain.doFilter(request, response);
			
			connection.close();
			
			System.out.println("Filtro Conexao conexão fechada:" +  connection.isClosed());
			
		} catch (SQLException e) {
			new ServletException(e);
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
