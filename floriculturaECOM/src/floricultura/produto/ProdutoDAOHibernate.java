package floricultura.produto;

import java.util.List;

import floricultura.categoria.Categoria;
import floricultura.usuario.Usuario;

import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProdutoDAOHibernate implements ProdutoDAO {

	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}
	
	public void salvar(Produto produto) {
		this.session.saveOrUpdate(produto);
	}

	public void atualizar(Produto produto) {
		

	}

	public void excluir(Produto produto) {
		this.session.delete(produto);
	}

	public Produto carregar(Integer codigo) {
		return (Produto) this.session.get(Produto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listar(Categoria categoria) {
		return this.session.createCriteria(Produto.class).list();
		
	}
	
	public Produto buscarPorCodigo(Integer codigo) {
		String hql = "Select p from produto p where p.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Produto) consulta.uniqueResult();
	}

	public Produto buscarPorCategoria(Categoria categoria) {
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		return this.session.createCriteria(Produto.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarPorCategoria(Categoria categoria){
		Criteria criteria = this.session.createCriteria(Produto.class);
		criteria.add(Restrictions.eqOrIsNull("categoria", categoria));
		
		//criteria.addOrder(Order.asc("codigo"));
		return criteria.list();
	}
	
}
