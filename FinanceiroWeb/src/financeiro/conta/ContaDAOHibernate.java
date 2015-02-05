package financeiro.conta;

import java.util.List;
import financeiro.usuario.Usuario;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

public class ContaDAOHibernate implements ContaDAO {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}	
	
	public void salvar(Conta conta) {
		this.session.saveOrUpdate(conta);
	}

	public void excluir(Conta conta) {
		this.session.delete(conta);
	}

	public Conta carregar(Integer conta) {
		return (Conta) this.session.get(Conta.class, conta);
	}

	public List<Conta> listar(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Conta.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return criteria.list();
	}

	public Conta buscarFavorita(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Conta.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("favorita", true));
		return (Conta) criteria.uniqueResult();
	}

}
