<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Altera Contato Teste</title>
</head>
<body>

	<c:import url="cabecalho.jsp" />

	<c:choose>
		<c:when test="${not empty idContatoAlterar}">
			<h1>Altera contato ID ${idContatoAlterar}</h1>
		</c:when>
		<c:otherwise>
			<h1>Novo contato</h1>
		</c:otherwise>
	</c:choose>

	<c:import url="rodape.jsp" />

</body>
</html>