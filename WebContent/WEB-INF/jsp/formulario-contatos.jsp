<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="agendaweb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:choose>
	<c:when test="${not empty idContato}"><title>Altera Contato</title></c:when>
	<c:otherwise><title>Adiciona Contato</title></c:otherwise>
</c:choose>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>

	<c:import url="cabecalho.jsp"/>

	<c:choose>
		<c:when test="${not empty idContato}"><h1>Altera Contato ${idContato} na Agenda Web </h1></c:when>
		<c:otherwise><h1>Adiciona Novo Contato Agenda Web</h1></c:otherwise>
	</c:choose>
	
	<form action="mvc?logica=GerenciaContatoLogica" method="post">
		<c:choose>
			<c:when test="${not empty idContato}">
				<agendaweb:campoId descricao="ID Contato" nome="idContato" tipo="text" id="id" valor="${idContato}"/><br/>
			</c:when>
		</c:choose>
		<agendaweb:campoInput descricao="Nome" nome="nome" tipo="text" id="nome" valor="${nomeContato}"/><br/>
		<agendaweb:campoInput descricao="E-mail" nome="email" tipo="text" id="email" valor="${emailContato}"/><br/>
		<agendaweb:campoInput descricao="Endereço" nome="endereco" tipo="text" id="endereco" valor="${enderecoContato}"/><br/>
		<agendaweb:campoData descricao="Data Nascimento" id="dataNascimento" valor="${dataNascimentoContato}"/><br/>
		
		<c:choose>
			<c:when test="${not empty idContato}"><input type="submit" value="Alterar" /></c:when>
			<c:otherwise><input type="submit" value="Gravar" /></c:otherwise>
		</c:choose>
		
	</form>
	
	<c:import url="rodape.jsp"/>

</body>
</html>