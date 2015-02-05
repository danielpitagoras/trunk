package floricultura.produto;

import java.util.List;

import floricultura.categoria.Categoria;
import floricultura.usuario.Usuario;


public interface ProdutoDAO {

	public void salvar(Produto produto);
	public void atualizar(Produto produto);
	public void excluir(Produto produto);
	public Produto carregar(Integer codigo);
	public Produto buscarPorCodigo(Integer codigo);
	public Produto buscarPorCategoria(Categoria categoria);
	public List<Produto> listar();
	
}
