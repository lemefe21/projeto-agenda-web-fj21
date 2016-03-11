<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

	<c:import url="cabecalho.jsp"/>
	
	<!-- gerenciador de contatos sem o id será chamada a logica para incluisao -->
	<p><a href="mvc?logica=GerenciadorContatoLogica">Adiciona novo contato</a></p>

	<table>
		<tr>
			<th>Linha</th>
			<th>ID Contato</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data Nascimento</th>
			<th>Remover</th>
			<th>Alterar</th>
		</tr>
		
		<!-- itera a lista que foi inserida pelo request -->
		<c:forEach var="contato" items="${listaContatos}" varStatus="idLinha">
			<tr>
				<td>${idLinha.count}</td>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<td>
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail não informado!
						</c:otherwise>
					</c:choose>
				</td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
				
				<!-- chama a logica de remocao e passa o id do contato -->
				<td><a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a></td>
				
				<!-- chama a logica que gerencia o contato e passa o id para alteracao -->
				<td><a href="mvc?logica=GerenciadorContatoLogica&id=${contato.id}">Alterar</a></td>
				
			</tr>
		</c:forEach>
	</table>

	<c:import url="rodape.jsp"/>

</body>
</html>