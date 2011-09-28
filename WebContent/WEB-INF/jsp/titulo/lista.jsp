<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<table>
	<thead>
		<tr>
			<th>Código</th><th>Tópico</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${tituloList}" var="titulo">
			<tr>
				<td>${titulo.id }</td>
				<td>${titulo.titulo }</td>
			
				
						<td><a href="buscaPorTitulo2?id=${titulo.id }">Ver comentários</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

