package br.com.comente.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.comente.modelo.Titulo;

@Component
public class TituloDAO {
	
	private final Session session;
	
	public TituloDAO(Session session){
		this.session = session;
	}

	public void salva(Titulo titulo) {
		Transaction tx = session.beginTransaction();
		session.save(titulo);
		tx.commit();
	}

	public void remove(Titulo titulo) {
		Transaction tx = session.beginTransaction();
		session.delete(titulo);
		tx.commit();
	}

	public void atualiza(Titulo titulo) {
		Transaction tx = session.beginTransaction();
		session.update(titulo);
		tx.commit();
	}
	public Titulo carrega(Long codigo){
		return (Titulo) this.session.load(Titulo.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Titulo> listaTudo(){
		return session.createCriteria(Titulo.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Titulo> busca(String titulo) {
		// TODO Auto-generated method stub
		//System.out.println(titulo);
		return session.createCriteria(Titulo.class)
				.add(Restrictions.ilike("titulo", titulo, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Titulo titulo) {
		// TODO Auto-generated method stub
		session.refresh(titulo);
	}
}
