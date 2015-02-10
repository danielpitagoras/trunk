package floricultura.itemPedido;

import java.util.List;

public interface ItemPedidoDAO {
	
	public void salvar(ItemPedido itemPedido);
	public void atualizar(ItemPedido itemPedido);
	public void excluir(ItemPedido itemPedido);
	public ItemPedido carregar(Integer codigo);
	public ItemPedido buscarPorCodigo(Integer codigo);
	public List<ItemPedido> listar();
	
}
