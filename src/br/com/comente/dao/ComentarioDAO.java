package br.com.comente.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.comente.modelo.Comentario;
import br.com.comente.modelo.Titulo;


@Component
public class ComentarioDAO {
	
	private final Session session;
	
	public ComentarioDAO(Session session){
		this.session = session;
	}

	public void salva(Comentario comentario) {
		Transaction tx = session.beginTransaction();
		session.save(comentario);
		tx.commit();
	}

	public void remove(Comentario comentario) {
		Transaction tx = session.beginTransaction();
		session.delete(comentario);
		tx.commit();
	}

	public void atualiza(Comentario comentario) {
		Transaction tx = session.beginTransaction();
		session.update(comentario);
		tx.commit();
	}
	public Comentario carrega(Long codigo){
		return (Comentario) this.session.load(Comentario.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Comentario> listaTudo(){
		return session.createCriteria(Comentario.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Comentario> busca(String comentario) {
		// TODO Auto-generated method stub
		return session.createCriteria(Comentario.class)
				.add(Restrictions.ilike("comentario", comentario, MatchMode.ANYWHERE))
				.list();
		
	}

	@SuppressWarnings("unchecked")
	public List<Comentario> buscaPorTitulo(Titulo titulo) {
		// TODO Auto-generated method stub
		Query select = session.createQuery("from Comentario as comentario where comentario.titulo=:titulo");
		select.setEntity("titulo", titulo);
		List<Comentario> comentarios = select.list();
		
		return comentarios;
		
	}


	public void recarrega(Comentario comentario) {
		// TODO Auto-generated method stub
		session.refresh(comentario);
	}
}
