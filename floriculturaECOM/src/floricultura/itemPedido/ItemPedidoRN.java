package floricultura.itemPedido;

import java.util.List;
import floricultura.util.DAOFactory;

public class ItemPedidoRN {

	private ItemPedidoDAO itemPedidoDAO;
	
	public ItemPedidoRN(){
		this.itemPedidoDAO = DAOFactory.criarItemPedidoDAO();
	}
	
	public ItemPedido carregar(Integer codigo) {
		return this.itemPedidoDAO.carregar(codigo);
	}
	
	public void salvar(ItemPedido itemPedido) {
		Integer codigo = itemPedido.getCodigo();
		if (codigo == null || codigo == 0) {
			this.itemPedidoDAO.salvar(itemPedido);
		} else {
			this.itemPedidoDAO.atualizar(itemPedido);
		}
	}
	
	public void excluir(ItemPedido itemPedido) {
		this.itemPedidoDAO.excluir(itemPedido);
	}
	
	public List<ItemPedido> lista() {
		return this.itemPedidoDAO.listar();
	}
}
