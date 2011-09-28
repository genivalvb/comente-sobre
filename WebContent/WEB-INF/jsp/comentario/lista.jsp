<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<table>
<c:forEach items="${comentarioList}" var="comentario">
	<tbody>
		
			<tr>
			<td>-------------------------------------------------------</td>
				<td>${comentario.titulo }</td>
			</tr>
			<tr>
				<td>Id: ${comentario.id }</td>
				<td>Email: ${comentario.email }</td>
			</tr>
			<tr>
				<td>${comentario.descricao }</td>
				
			</tr>
		
	</tbody>
	</c:forEach>
</table>

