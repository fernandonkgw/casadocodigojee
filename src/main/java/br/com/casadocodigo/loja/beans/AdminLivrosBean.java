package br.com.casadocodigo.loja.beans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {

	private final static Logger LOGGER = Logger.getLogger(AdminLivrosBean.class.getName());
	private Livro livro = new Livro();
	
	@Inject
	private LivroDao livroDao;
	@Inject
	private AutorDao autorDao;
	@Inject
	private FacesContext context;
	
	@PostConstruct
	public void init() {
		LOGGER.setLevel(Level.OFF);
		LOGGER.info("Instanciando Bean");
	}
	
	@Transactional
	public String salvar() {

		livroDao.salvar(livro);
		livro = new Livro();
		LOGGER.info("Livro cadastrado com sucesso " + livro);
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Livro cadastrado com sucesso"));
		
		return "/livros/lista?faces-redirect=true";
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public List<Autor> getAutores() {
		return autorDao.listar();
	}
	
}
