package floricultura.pedido;

import java.util.List;

public interface PedidoDAO {
	
	public void salvar(Pedido pedido);
	public void atualizar(Pedido pedido);
	public void excluir(Pedido pedido);
	public Pedido carregar(Integer codigo);
	public Pedido buscarPorNome(String nome);
	public Pedido buscarPorCodigo(Integer codigo);
	public List<Pedido> listar();
	
}
