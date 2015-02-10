package floricultura.pedido;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;

public class PedidoDAOHibernate implements PedidoDAO {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	public void salvar(Pedido pedido) {
		this.session.save(pedido);
	}

	public void atualizar(Pedido pedido) {
		this.session.update(pedido);
	}

	public void excluir(Pedido pedido) {
		this.session.delete(pedido);
	}
	
	public Pedido carregar(Integer codigo) {
		return (Pedido) this.session.get(Pedido.class, codigo);
	}

	public Pedido buscarPorNome(String nome) {
		String hql = "select p from Pedido p where p.nome = :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome);
		return (Pedido) consulta.uniqueResult();
	}

	public Pedido buscarPorCodigo(Integer codigo) {
		String hql = "select p from Pedido p where p.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Pedido) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> listar() {
		return this.session.createCriteria(Pedido.class).list();
	}

}
