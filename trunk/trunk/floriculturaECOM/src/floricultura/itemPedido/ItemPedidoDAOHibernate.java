package floricultura.itemPedido;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;
import floricultura.itemPedido.ItemPedido;

public class ItemPedidoDAOHibernate implements ItemPedidoDAO {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	public void salvar(ItemPedido itemPedido) {
		this.session.save(itemPedido);
	}
	
	public void atualizar(ItemPedido itemPedido) {
		this.session.update(itemPedido);
	}
	
	public void excluir(ItemPedido itemPedido) {
		this.session.delete(itemPedido);
	}

	public ItemPedido carregar(Integer codigo) {
		return(ItemPedido) this.session.get(ItemPedido.class, codigo);
	}

	public ItemPedido buscarPorCodigo(Integer codigo) {
		String hql = "select i from ItemPedido i where i.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (ItemPedido) consulta.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemPedido> listar() {
		return this.session.createCriteria(ItemPedido.class).list();
	}

}
