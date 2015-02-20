package floricultura.endereco;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import floricultura.usuario.Usuario;

public class EnderecoDAOHibernate implements EnderecoDAO {

	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Endereco endereco) {
		this.session.saveOrUpdate(endereco);
	}
	
	public void atualizar(Endereco endereco) {
	
	}

	public void excluir(Endereco endereco) {
		this.session.delete(endereco);
	}

	public Endereco carregar(Integer codigo) {
		return (Endereco) this.session.get(Endereco.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Endereco> listar() {
		return this.session.createCriteria(Endereco.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Endereco> listarPorUsuario(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Endereco.class);
		criteria.add(Restrictions.eqOrIsNull("usuario", usuario));
		return criteria.list();
	}

}
