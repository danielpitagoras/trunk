package floricultura.www;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.StringBuffer;

import floricultura.pedido.*;
import floricultura.usuario.Usuario;
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
	//private List<ItemPedido> listaItemPedido = new ArrayList<ItemPedido>();
	
	public String getEnderecoAgrupado() {
		
		return enderecoAgrupado;
	}
	
	public String salvar() {
		
		PedidoRN pedidoRN = new PedidoRN();
		this.pedidoEmEdicao.setDataPedido(new Date());
		
		StringBuffer strBuffer = new StringBuffer();
			strBuffer.append("Cep: ");
			strBuffer.append(enderecoSelecionado.getCep());
			strBuffer.append(" - Rua: ");
			strBuffer.append(enderecoSelecionado.getRua());
			strBuffer.append(" - Nœmero: ");
			strBuffer.append(enderecoSelecionado.getNumero());
			strBuffer.append(" - Complemento: ");
			strBuffer.append(enderecoSelecionado.getComplemento());
			strBuffer.append(" - Bairro");
			strBuffer.append(enderecoSelecionado.getBairro());
			strBuffer.append(" - Cidade");
			strBuffer.append(enderecoSelecionado.getCidade());
			strBuffer.append(" - Estado");
			strBuffer.append(enderecoSelecionado.getEstado());
			strBuffer.append(" - Pa’s");
			strBuffer.append(enderecoSelecionado.getPais());
			
		pedidoEmEdicao.setEnderecoEntrega(strBuffer.toString());
		this.listaItemPedido = (ContextoUtil.getContextoBean().getListaItemPedido());
		
		if (listaItemPedido == null) {
			return null;
		} else { 
			for (int i = 0; i < listaItemPedido.size(); i++){
				System.out.println(listaItemPedido.get(i).getNome());
			}
		}
		//this.pedidoEmEdicao.setPesoTotal();
		//this.pedidoEmEdicao.setPrecoTotal();
		//pedidoRN.salvar(pedidoEmEdicao);
		return null;
	}

	public void setEnderecoAgrupado(String enderecoAgrupado) {
		this.enderecoAgrupado = enderecoAgrupado;
	}

	public Usuario getUsuarioLogado() {
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
