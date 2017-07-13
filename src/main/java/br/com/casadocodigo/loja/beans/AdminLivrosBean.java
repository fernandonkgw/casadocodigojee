package br.com.casadocodigo.loja.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {

	private Livro livro = new Livro();
	
	@Inject
	private LivroDao dao;
	
	public void salvar() {
		dao.salvar(livro);
	}
	
	public Livro getLivro() {
		return livro;
	}
}
