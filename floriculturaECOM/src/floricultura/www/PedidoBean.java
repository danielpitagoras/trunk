package floricultura.www;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.StringBuffer;

import floricultura.pedido.*;
import floricultura.usuario.Usuario;
import floricultura.usuario.UsuarioRN;
import floricultura.util.ContextoUtil;
import floricultura.endereco.Endereco;
import floricultura.itemPedido.ItemPedido;
import floricultura.itemPedido.ItemPedidoRN;

@ManagedBean(name = "pedidoBean")
@SessionScoped

public class PedidoBean {

	private Pedido pedidoEmEdicao = new Pedido();
	private Usuario usuarioLogado;
	private Endereco enderecoSelecionado;
	private String enderecoAgrupado;
	private ItemPedido itemPedido;
	private List<ItemPedido> listaItemPedido;
	
	public String getEnderecoAgrupado() {
		
		return enderecoAgrupado;
	}
	
	public String salvar() {
		
		// --- Parte de gravação do Pedido no banco.
		float pesoTotPedido = 0;
		float precoTotPedido = 0;
		//int codPedido = 0;
		
		PedidoRN pedidoRN = new PedidoRN();
		this.pedidoEmEdicao.setUsuario(getUsuarioLogado());
		this.pedidoEmEdicao.setDataPedido(new Date());
		
		StringBuffer strBuffer = new StringBuffer();
			strBuffer.append("Cep: ");
			strBuffer.append(enderecoSelecionado.getCep());
			strBuffer.append(" - Rua: ");
			strBuffer.append(enderecoSelecionado.getRua());
			strBuffer.append(" - Número: ");
			strBuffer.append(enderecoSelecionado.getNumero());
			strBuffer.append(" - Complemento: ");
			strBuffer.append(enderecoSelecionado.getComplemento());
			strBuffer.append(" - Bairro");
			strBuffer.append(enderecoSelecionado.getBairro());
			strBuffer.append(" - Cidade");
			strBuffer.append(enderecoSelecionado.getCidade());
			strBuffer.append(" - Estado");
			strBuffer.append(enderecoSelecionado.getEstado());
			strBuffer.append(" - País");
			strBuffer.append(enderecoSelecionado.getPais());
			
		pedidoEmEdicao.setEnderecoEntrega(strBuffer.toString());
		this.listaItemPedido = (ContextoUtil.getContextoBean().getListaItemPedido());
		
		if (listaItemPedido == null) {
				System.out.println("* * * Erro obtendo lista de itens pedidos. * * *");
				return "PedidoNSalvo";
		} else { 
			for (int i = 0; i < listaItemPedido.size(); i++){
				pesoTotPedido = pesoTotPedido + listaItemPedido.get(i).getPesoTotal();
				precoTotPedido = precoTotPedido + listaItemPedido.get(i).getPrecoTotal();
			}
		}
		
		this.pedidoEmEdicao.setPesoTotal(pesoTotPedido);
		this.pedidoEmEdicao.setPrecoTotal(precoTotPedido);
		pedidoRN.salvar(pedidoEmEdicao);
		// Jogar para variável pq o valor é perdido após prox iteração do Hibernate.
		//codPedido = pedidoEmEdicao.getCodigo();
		
		// --- Parte de gravação dos itens do Pedido vinculados ao Banco.
		
		ItemPedidoRN itemPedidoRN = new ItemPedidoRN();
		
		if (listaItemPedido == null) {
			System.out.println(" * * * Erro gravando os itens do pedido. * * *");
			return "PedidoNSalvo";
		} else {
			for (int i = 0; i < listaItemPedido.size(); i++) {
				itemPedido = listaItemPedido.get(i);
				itemPedido.setPedido(pedidoEmEdicao);
				itemPedidoRN.salvar(itemPedido);
			}
		}
		
		return "PedidoSalvo";
	}
	
	

	public void setEnderecoAgrupado(String enderecoAgrupado) {
		this.enderecoAgrupado = enderecoAgrupado;
	}

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		if (this.usuarioLogado == null || !login.equals(this.usuarioLogado.getLogin())) {
			if (login != null) {
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuarioLogado = usuarioRN.buscarPorLogin(login);
			}
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Endereco getEnderecoSelecionado() {
		return enderecoSelecionado;
	}

	public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
		this.enderecoSelecionado = enderecoSelecionado;
	}

	public Pedido getPedidoEmEdicao() {
		return pedidoEmEdicao;
	}

	public void setPedidoEmEdicao(Pedido pedidoEmEdicao) {
		this.pedidoEmEdicao = pedidoEmEdicao;
	}
	
}
