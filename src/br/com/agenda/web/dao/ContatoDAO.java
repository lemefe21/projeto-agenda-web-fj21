package br.com.agenda.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.agenda.web.exception.DAOException;
import br.com.agenda.web.factory.ConnectionFactory;
import br.com.agenda.web.modelo.Contato;

public class ContatoDAO {

	private Connection connection;

	public ContatoDAO() {

		this.connection = new ConnectionFactory().getConnection();
		try {

			System.out.println("Conectado! " + " - Conexão fechada: " + connection.isClosed());

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public ContatoDAO(Connection connection){
		//construtor criado para ser utilizado pelo FiltroConexao
		this.connection = connection;
	}

	public void adiciona(Contato contato){

		String sql = "insert into CONTATOS (nome, email, endereco, dataNascimento) values (?,?,?,?)";

		try{

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		}catch(SQLException e){
			throw new DAOException(e);
		}

	}

	public List<Contato> getLista(){

		try{

			List<Contato> listaContatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from CONTATOS");
			ResultSet result = stmt.executeQuery();

			while(result.next()){

				Contato contato = parseResultSetToContato(result);
				listaContatos.add(contato);

			}

			result.close();
			stmt.close();

			return listaContatos;

		}catch(SQLException e){
			throw new DAOException(e);

		}

	}

	public List<Contato> buscaPorNome(String nome){

		try{

			List<Contato>lista = new ArrayList<Contato>();

			String sql = "select * from CONTATOS where nome like ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, nome + "%");

			ResultSet result = stmt.executeQuery();

			while(result.next()){

				Contato contato = parseResultSetToContato(result);
				lista.add(contato);

			}

			result.close();
			stmt.close();

			return lista;

		}catch(SQLException e){
			throw new DAOException(e);
		}

	}

	public Contato buscaPorID(Long id){

		try{

			Contato contato = null;

			String sql = "select * from CONTATOS where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet result = stmt.executeQuery();

			while(result.next()){
				contato = parseResultSetToContato(result);
			}

			result.close();
			stmt.close();

			return contato;

		}catch(SQLException e){
			throw new DAOException(e);
		}

	}

	public void alteraContato(Contato contato){

		String sql = "update CONTATOS set nome=?, email=?, endereco=?, dataNascimento=? where id=?";

		try{

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();

		}catch(SQLException e){
			throw new DAOException(e);
		}

		System.out.println("Contato ID: " + contato.getId() + " alterado com sucesso!");

	}

	public void removeContato(Contato contato){

		String sql = "delete from CONTATOS where id=?";

		try{

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());

			stmt.execute();
			stmt.close();

		}catch(SQLException e){
			throw new DAOException(e);
		}

		System.out.println("Contato ID: " + contato.getId() + " removido com sucesso!");

	}

	private Contato parseResultSetToContato(ResultSet result) throws SQLException {

		Contato contato = new Contato();
		contato.setId(result.getLong("id"));
		contato.setNome(result.getString("nome"));
		contato.setEmail(result.getString("email"));
		contato.setEndereco(result.getString("endereco"));

		Calendar data = Calendar.getInstance();
		data.setTime(result.getDate("dataNascimento"));
		contato.setDataNascimento(data);

		return contato;
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
