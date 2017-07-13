package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.models.Livro;

public class LivroDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void salvar(Livro livro) {
		manager.persist(livro);
	}
}
