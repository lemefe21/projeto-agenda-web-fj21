package br.com.agenda.web.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {

	String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
