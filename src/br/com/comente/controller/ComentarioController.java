package br.com.comente.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.comente.dao.ComentarioDAO;
import br.com.comente.dao.TituloDAO;
import br.com.comente.modelo.Comentario;
import br.com.comente.modelo.Titulo;

@Resource
public class ComentarioController {
	private final ComentarioDAO dao;
	private final Result result;
	private final Validator validator;
	private final TituloDAO daoTi;


	
	
	public ComentarioController(ComentarioDAO dao, Result result, Validator validator, TituloDAO daoTi){		
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.daoTi = daoTi;
	}
	
	@Path("/adicionaComentario")
	public void adiciona(final Comentario comentario, Titulo titulo){
		validator.validate(comentario);
		validator.onErrorUsePageOf(ComentarioController.class).formulario();
		System.out.println("ID = " + titulo.getId());
		comentario.setTitulo(titulo);		
		dao.salva(comentario);
		result.redirectTo(this).buscaPorTitulo(titulo);
	}
	

	@Path("/alteraComentario")
	public void altera(Comentario comentario){
		dao.atualiza(comentario);
		result.redirectTo(this).lista();
	}
	
	@Path("/editaComentario")
	public Comentario edita(long codigo){
		return dao.carrega(codigo);
	}
	

	@Path("/removeComentario")
	public void remove(long codigo){
		Comentario comentario = dao.carrega(codigo);
		dao.remove(comentario);
		result.redirectTo(this).lista();
	}
	
	@Path("/comentarios")
	public List<Comentario> lista(){
		return dao.listaTudo();
	}
	
	@Path("/buscaComentario")
	public List<Comentario> busca(String comentario){
		result.include("comentario", comentario);
		return dao.busca(comentario);
		
	}
		
	@Path("/buscaPorTitulo")
	public List<Comentario> buscaPorTitulo(Titulo titulo){
		
		return dao.buscaPorTitulo(titulo);
		
	}
	@Path("/buscaPorTitulo2")
	public List<Comentario> buscaPorTitulo(Long id){
		Titulo t = new Titulo();
		//t.setTitulo(titulo);
		t = daoTi.carrega(id);
		return dao.buscaPorTitulo(t);
		
	}

	@Path("/formularioComentario")
	public void formulario()
	{
		
	}
	@Path("/menuComentario")
	public void menu(){
		
	}

}
