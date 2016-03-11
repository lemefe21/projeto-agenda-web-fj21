<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="agendaweb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adiciona Contato</title>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>

	<c:import url="cabecalho.jsp"/>

	<h1>Adiciona Contato Agenda Web</h1>
	<hr/>
	<form action="mvc?logica=AdicionaContatoLogica" method="post">
		<agendaweb:campoInput descricao="Nome" atributo="nome" tipo="text" id="nome" valor="${idContatoAlterar}"/><br/>
		<agendaweb:campoInput descricao="E-mail" atributo="email" tipo="text" id="email" valor="${idContatoAlterar}"/><br/>
		<agendaweb:campoInput descricao="Endereço" atributo="endereco" tipo="text" id="endereco" valor="${idContatoAlterar}"/><br/>
		<agendaweb:campoData descricao="Data Nascimento" id="dataNascimento" valor="${idContatoAlterar}"/><br/>
		<input type="submit" value="Gravar" />
	</form>
	<hr/>
	
	<c:import url="rodape.jsp"/>

</body>
</html>