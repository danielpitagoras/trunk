package floricultura.categoria;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class CategoriaDAOHibernate implements CategoriaDAO {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	public void salvar(Categoria categoria) {
		this.session.save(categoria);
	}

	public void atualizar(Categoria categoria) {
		this.session.update(categoria);

	}

	public void excluir(Categoria categoria) {
		this.session.delete(categoria);
	}

	public Categoria carregar(Integer codigo) {
		return (Categoria) this.session.get(Categoria.class, codigo);
	}
	
	public Categoria buscarPorNome(String nome) {
		String hql = "select c from Categoria c where c.nome = :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome);
		return (Categoria) consulta.uniqueResult();
		
	}
	
	public Categoria buscarPorCodigo(Integer codigo) {
		String hql = "select c from Categoria c where c.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Categoria) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> listar() {
		return this.session.createCriteria(Categoria.class).list();
	}

}
