package floricultura.util;

import floricultura.categoria.*;
import floricultura.pedido.PedidoDAOHibernate;
import floricultura.produto.*;
import floricultura.usuario.*;
import floricultura.pedido.*;
import floricultura.itemPedido.*;

public class DAOFactory {

	public static CategoriaDAO criarCategoriaDAO() {
		
		CategoriaDAOHibernate categoriaDAO = new CategoriaDAOHibernate();
		categoriaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return categoriaDAO;
	}
	
	public static UsuarioDAO criarUsuarioDAO() {
		
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
		
	}
	
	public static ProdutoDAO criarProdutoDAO() {
		
		ProdutoDAOHibernate produtoDAO = new ProdutoDAOHibernate();
		produtoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return produtoDAO;
		
	}
	
	public static PedidoDAO criarPedidoDAO() {
		
		PedidoDAOHibernate pedidoDAO = new PedidoDAOHibernate();
		pedidoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return pedidoDAO;
	}
	
	public static ItemPedidoDAO criarItemPedidoDAO() {
		
		ItemPedidoDAOHibernate itemPedidoDAO = new ItemPedidoDAOHibernate();
		itemPedidoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return itemPedidoDAO;
		
	}
	
	
}
