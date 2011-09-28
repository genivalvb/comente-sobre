<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<form id="comentarioForm" action="<c:url value="/adicionaComentario"/>" method="post">
	<fieldset>
		<legend>Criar novo comentário</legend>
		
		<label for="email">Email:</label>
		<input id="email" class="required" type="text" name="comentario.email" size=50 value="${comentario.email }"/>
		
		<label for="descricao">Descrição:</label><br/>
		<textarea id="descricao" class="required" name="comentario.descricao" cols=40 rows=4></textarea>
		
		<c:forEach items="${tituloList}" var="titulo">
			<input id="titulo" class="required" type="hidden" name="titulo.id" size=50 value="${titulo.id }"/>
			<input id="titulo" class="required" type="hidden" name="titulo.titulo" size=50 value="${titulo.titulo }"/>
		</c:forEach>
		<button type="submit">Enviar</button>
	</fieldset>
</form>
<script type="text/javascript">
	$('#comentarioForm').validate();
</script>