package floricultura.pedido;

import java.util.List;
import floricultura.util.DAOFactory;

public class PedidoRN {

	private PedidoDAO pedidoDAO;
	
	public PedidoRN() {
		this.pedidoDAO = DAOFactory.criarPedidoDAO();
	}
	
	public Pedido carregar(Integer codigo) {
		return this.pedidoDAO.carregar(codigo);
	}
	
	public Pedido buscarPorNome(String nome) {
		return this.pedidoDAO.buscarPorNome(nome);
	}
	
	public Pedido buscarPorCodigo(Integer codigo) {
		return this.pedidoDAO.buscarPorCodigo(codigo);
	}
	
	public void salvar(Pedido pedido) {

		Integer codigo = pedido.getCodigo();
		if (codigo == null || codigo == 0) {
			this.pedidoDAO.salvar(pedido);
		} else {
			this.pedidoDAO.atualizar(pedido);
		}
		
	}
	
	public void excluir(Pedido pedido) {
		this.pedidoDAO.excluir(pedido);
	}
	
	public List<Pedido> lista() {
		return this.pedidoDAO.listar();
	}
	
}
