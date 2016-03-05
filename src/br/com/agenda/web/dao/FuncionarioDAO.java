package br.com.agenda.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.agenda.web.exception.DAOException;
import br.com.agenda.web.factory.ConnectionFactory;
import br.com.agenda.web.modelo.Funcionario;

public class FuncionarioDAO {

	private Connection connection;

	public FuncionarioDAO() {

		this.connection = new ConnectionFactory().getConnection();
		try {

			System.out.println("Conectado! " + " - Conexão fechada: " + connection.isClosed());

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}
	
	public void adiciona(Funcionario funcionario){
		
		String sql = "insert into funcionario (nome, usuario, senha) values (?,?,?)";

		try{

			PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());

			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()){
				funcionario.setId(rs.getLong(1));
				System.out.println("Adicionado com sucesso!");
				System.out.println(funcionario);
				
			}
			
			stmt.close();

		}catch(SQLException e){
			throw new DAOException(e);

		}
		
	}
	
	public void fecharConexao(){

		try {

			System.out.println("Fechando conexão...");
			this.connection.close();
			System.out.println("Conexão fechada: " + this.connection.isClosed());

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}
	
}
