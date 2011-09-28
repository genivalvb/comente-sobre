

<form id="tituloForm" action="<c:url value="/adicionaTitulo"/>" method="post">
	<fieldset>
		<legend>Adicionar Novo Tópico</legend>
		
		<label for="titulo">Tópico:</label>
		<input id="titulo" class="required" type="text" name="titulo.titulo" size=30/>

		<button type="submit">Enviar</button>
	</fieldset>
</form>
<script type="text/javascript">
	$('#tituloForm').validate();
</script>