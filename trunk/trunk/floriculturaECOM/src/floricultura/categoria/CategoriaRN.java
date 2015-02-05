package floricultura.categoria;

import java.util.List;
import floricultura.util.DAOFactory;

public class CategoriaRN {

	private CategoriaDAO categoriaDAO;
	
	public CategoriaRN() {
		this.categoriaDAO = DAOFactory.criarCategoriaDAO();
	}
	
	public Categoria carregar(Integer codigo) {
		return this.categoriaDAO.carregar(codigo);
	}
	
	public Categoria buscarPorNome(String nome) {
		return this.categoriaDAO.buscarPorNome(nome);
	}
	
	public void salvar(Categoria categoria) {
		Integer codigo = categoria.getCodigo();
		if (codigo == null || codigo == 0) {
			this.categoriaDAO.salvar(categoria);
		} else {
			this.categoriaDAO.atualizar(categoria);
		}
	}
	
	public void excluir(Categoria categoria) {
		this.categoriaDAO.excluir(categoria);
	}
	
	public List<Categoria> listar() {
		return this.categoriaDAO.listar();
	}
}
