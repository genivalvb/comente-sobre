

<form id="comentarioForm" action="<c:url value="/adicionaComentario"/>" method="post">
	<fieldset>
		<legend>Criar novo comentário</legend>
		
		<label for="email">Email:</label>
		<input id="email" class="required" type="text" name="titulo.email" size=50 value="${titulo.email }"/>
		
		<label for="descricao">Descrição</label><br/>
		<textarea id="descricao" class="required" name="titulo.descricao" cols=40 rows=4></textarea>

		<button type="submit">Enviar</button>
	</fieldset>
</form>
<script type="text/javascript">
	$('#comentarioForm').validate();
</script>