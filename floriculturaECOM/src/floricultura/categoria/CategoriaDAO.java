package floricultura.categoria;

import java.util.List;

public interface CategoriaDAO {

	public void salvar(Categoria categoria);
	public void atualizar(Categoria categoria);
	public void excluir(Categoria categoria);
	public Categoria carregar(Integer codigo);
	public Categoria buscarPorNome(String nome);
	public Categoria buscarPorCodigo(Integer codigo);
	public List<Categoria> listar();
	
}
