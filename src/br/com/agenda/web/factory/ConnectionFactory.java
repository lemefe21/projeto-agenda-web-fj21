package br.com.agenda.web.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory instance;

	private ConnectionFactory() {
	}

	//Utilizando Design Pattern Singleton
	public static synchronized ConnectionFactory getInstance() {

		if (instance == null) {
			System.out.println("Conectando a base de dados da Agenda Web...");
			instance = new ConnectionFactory();
		}
		return instance;

	}

	// Desing Pattern - Factory
	// (encapsula a criação de um objeto complexo)
	public Connection getConnection() {

		try {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Erro ao registrar o drive de conexão para base de dados da Agenda Web...");
				e.printStackTrace();
			}
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "homepc");

		} catch (SQLException e) {
			System.err.println("Erro ao conectar com a base de dados da Agenda Web!");
			throw new RuntimeException(e);
		}

	}

}
