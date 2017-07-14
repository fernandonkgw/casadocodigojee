package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {

	private final static Logger LOGGER = Logger.getLogger(AdminLivrosBean.class.getName());
	private Livro livro = new Livro();
	private List<Integer> autoresId = new ArrayList<>();
	
	@Inject
	private LivroDao livroDao;
	@Inject
	private AutorDao autorDao;
	
	@PostConstruct
	public void init() {
		LOGGER.setLevel(Level.OFF);
		LOGGER.info("Instanciando Bean");
	}
	
	public void salvar() {
		for (Integer autorId : autoresId) {
			livro.adiciona(new Autor(autorId));
		}
		livroDao.salvar(livro);
		livro = new Livro();
		autoresId = new ArrayList<>();
		LOGGER.info("Livro cadastrado com sucesso " + livro);
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public List<Autor> getAutores() {
		return autorDao.listar();
	}
	
	public List<Integer> getAutoresId() {
		return autoresId;
	}
	
	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}
}
