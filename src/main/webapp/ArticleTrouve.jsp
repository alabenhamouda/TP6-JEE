<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="metier.Article,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Resultat de la recherche!</h1>
	LES INFORMATIONS SUR L'ARTICLE RECHERCH
	<table>
		<tr>
			<th>Code</th>
			<th>Nom</th>
			<th>Description</th>
			<th>quantite</th>
			<th>prix</th>
		</tr>
		<%
		for (Article art : (ArrayList<Article>) request.getAttribute("products")) {
		%>
		<tr>
			<td><%=art.getCode()%></td>
			<td><%=art.getNom()%></td>
			<td><%=art.getDescription()%></td>
			<td><%=art.getQuantite()%></td>
			<td><%=art.getPrix()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<% Cookie[] cookies = request.getCookies(); %>
	TABLE DE COOKIES
	<table>
		<tr>
			<th>Cookie's name</th>	
			<th>Cookie's value </th>
		</tr>	
		<% for(Cookie c : cookies){ %>
			<tr>
				<td><%=c.getName() %>	
				<td><%=c.getValue() %>
			</tr>	
		<%} %>
	</table>
</body>
</html>