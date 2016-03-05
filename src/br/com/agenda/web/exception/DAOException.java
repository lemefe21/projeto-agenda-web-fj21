package br.com.agenda.web.exception;

import java.sql.SQLException;

public class DAOException extends RuntimeException{

	private static final long serialVersionUID = -2777420833160310253L;

	public DAOException(SQLException e) {
	
		System.out.println(e.getMessage());
		
	}
	
}
