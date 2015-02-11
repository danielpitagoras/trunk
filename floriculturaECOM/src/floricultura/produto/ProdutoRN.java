package floricultura.produto;

import java.util.*;

import floricultura.categoria.Categoria;
import floricultura.usuario.Usuario;
import floricultura.util.DAOFactory;

public class ProdutoRN {
	
	private ProdutoDAO produtoDAO;
	
	public ProdutoRN(){
		this.produtoDAO = DAOFactory.criarProdutoDAO();
	}
	
	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}
	
	public List<Produto> listarPorCategoria(Categoria categoria) {
		return this.produtoDAO.listarPorCategoria(categoria);
	}
	
	public Produto carregar(Integer codigo) {
		return this.produtoDAO.carregar(codigo);
	}
	
	public Produto buscarPorCodigo(Integer codigo) {
		return this.produtoDAO.buscarPorCodigo(codigo);
	}
	
	public void salvar(Produto produto) {
		
		produto.setDataCriacao(new Date());
		this.produtoDAO.salvar(produto);
		
	}
	
	public void excluir(Produto produto) {
		
		this.produtoDAO.excluir(produto);
		
	}
	

}
