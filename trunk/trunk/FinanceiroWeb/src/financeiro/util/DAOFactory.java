package financeiro.util;

import financeiro.usuario.*;
import financeiro.bolsa.acao.AcaoDAOHibernate;
import financeiro.conta.*;
import financeiro.categoria.*;
import financeiro.lancamento.*;
import financeiro.cheque.*;
import financeiro.bolsa.acao.*;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO(){
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
	
	public static ContaDAO criarContaDAO() {
		ContaDAOHibernate contaDAO = new ContaDAOHibernate();
		contaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return contaDAO;
	}
	
	public static CategoriaDAO criarCategoriaDAO() {
		CategoriaDAOHibernate categoriaDAO = new CategoriaDAOHibernate();
		categoriaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return categoriaDAO;
	}
	
	public static LancamentoDAO criarLancamentoDAO() {
		LancamentoDAOHibernate lancamentoDAO = new LancamentoDAOHibernate();
		lancamentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return lancamentoDAO;
	}
	
	public static ChequeDAO criarChequeDAO() {
		ChequeDAOHibernate chequeDAO = new ChequeDAOHibernate();
		chequeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return chequeDAO;
	}
	
	public static AcaoDAO criarAcaoDAO() {
		AcaoDAOHibernate acaoDAO = new AcaoDAOHibernate();
		acaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return acaoDAO;
	}
}
