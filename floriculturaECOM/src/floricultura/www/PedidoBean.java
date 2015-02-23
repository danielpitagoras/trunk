package floricultura.www;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import floricultura.pedido.Pedido;
import floricultura.usuario.Usuario;
import floricultura.util.ContextoUtil;
import floricultura.endereco.Endereco;

@ManagedBean(name = "pedidoBean")
@SessionScoped

public class PedidoBean {

	private Pedido pedidoEmEdicao;
	private Usuario usuarioLogado;
	private Endereco enderecoSelecionado;
	private String enderecoAgrupado;
	
	public String getEnderecoAgrupado() {
		
		
		return enderecoAgrupado;
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
