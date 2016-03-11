<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" required="true"	%>
<%@ attribute name="descricao" required="true" %>
<%@ attribute name="atributo" required="true" %>
<%@ attribute name="tipo" required="true" %>
<%@ attribute name="valor" required="true" %>

<label for="${id}">${descricao} </label>
<input type="${tipo}" id="${id}" name="${atributo}" value="${valor}"/>
