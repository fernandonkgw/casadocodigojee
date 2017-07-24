package br.com.casadocodigo.loja.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class LivroDetalheBean {

	private Livro livro;

	private Integer id;

	@Inject
	private LivroDao livroDao;

	public void carregarDetalhe() {
		this.livro = livroDao.buscaPorId(id);
	}

	public Livro getLivro() {
		return livro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
