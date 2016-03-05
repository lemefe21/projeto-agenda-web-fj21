package br.com.agenda.web.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// Desing Pattern - Factory
	// (encapsula a cria��o de um objeto complexo)
	public Connection getConnection() {

		try {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Erro ao registrar o drive de conex�o para base de dados fj21...");
				e.printStackTrace();
			}

			System.out.println("Conectando a base de dados fj21...");

			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "homepc21");


		} catch (SQLException e) {

			System.err.println("Erro ao conectar com a base de dados fj21!");
			throw new RuntimeException(e);

		}

	}

}
