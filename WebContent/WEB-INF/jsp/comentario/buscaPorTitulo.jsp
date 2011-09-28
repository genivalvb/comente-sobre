<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<c:forEach items="${comentarioList}" var="comentario" varStatus="status">
<div id="tituloComentario">
<p>
	<c:if test="${status.count == 1 }">
		<h2>Tópico: ${comentario.titulo }</h2> 
	</c:if>

	<h3>Email: ${comentario.email }</h3>
</p>
</div>
<div id="corpoComentario">
<p>
	Comentário: ${comentario.descricao }
</p><br/>
</div>

</c:forEach>
