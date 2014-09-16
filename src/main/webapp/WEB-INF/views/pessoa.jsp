<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Flyway Mind Blowing</title>
	</head>
	<body>
	
	<form:form method="POST" modelAttribute="pessoa" action="pessoa">
    <form:hidden path="id"/> 
    <table>
        <tr>
            <td><form:label path="nome">Nome</form:label></td>
            <td><form:input path="nome" /></td>
        </tr>
        <tr>
            <td><form:label path="idade">Idade</form:label></td>
            <td><form:input path="idade" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Salvar"/>
            </td>
        </tr>
    </table> 

</form:form>
	
	<table>
		<tr>
			<td>Nomes</td>
		</tr>
		<c:forEach items="${pessoas}" var="pessoa">
		<tr>
			<td>${pessoa.nome}</td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>