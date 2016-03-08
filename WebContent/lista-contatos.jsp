<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos</title>
	<style>
	table, th, td {
		border: 3px solid black;
		border-collapse: collapse;
	}
	
	th, td {
		padding: 5px;
	}
	</style>
</head>
<body>

	<jsp:useBean id="dao" class="br.com.agenda.web.dao.ContatoDAO"></jsp:useBean>

	<table>
		<tr>
			<th>Linha</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data Nascimento</th>
			<th>Remover</th>
			<th>Alterar</th>
		</tr>
		<c:forEach var="contato" items="${dao.lista}" varStatus="idLinha">
			<tr>
				<td>${idLinha.count}</td>
				<td>${contato.nome}</td>
				<td>${contato.email}</td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento}</td>
				<td><a href="">Remover</a></td>
				<td><a href="">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>