package br.com.comente.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.comente.dao.TituloDAO;
import br.com.comente.modelo.Titulo;

@Resource
public class TituloController {
	private final TituloDAO dao;
	private final Result result;
	private final Validator validator;


	
	
	public TituloController(TituloDAO dao, Result result, Validator validator){		
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	@Path("/adicionaTitulo")
	public void adiciona(final Titulo titulo){
		validator.validate(titulo);
		validator.onErrorUsePageOf(TituloController.class).formulario();
		
		dao.salva(titulo);
		result.redirectTo(this).lista();
	}
	

	@Path("/alteraTitulo")
	public void altera(Titulo titulo){
		dao.atualiza(titulo);
		result.redirectTo(this).lista();
	}
	
	@Path("/editaTitulo")
	public Titulo edita(long codigo){
		return dao.carrega(codigo);
	}
	

	@Path("/removeTitulo")
	public void remove(long codigo){
		Titulo titulo = dao.carrega(codigo);
		dao.remove(titulo);
		result.redirectTo(this).lista();
	}
	
	@Path("/titulos")
	public List<Titulo> lista(){
		return dao.listaTudo();
	}
	
	@Path("/buscaTitulo")
	public List<Titulo> busca(String titulo){
		result.include("titulo", titulo);
		
		if(!(dao.busca(titulo).isEmpty())){
			//System.out.println("Esse achou entao retornou certo" + dao.busca(titulo));
			return dao.busca(titulo);
		}else{
			result.redirectTo(this).formulario();
			return null;
		}
		
	}

	@Path("/formularioTitulo")
	public void formulario()
	{
		
	}
	@Path("/menuTitulo")
	public void menu(){
		
	}

}
