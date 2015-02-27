package floricultura.www;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import java.util.List;
import java.util.ArrayList;

import floricultura.endereco.*;
import floricultura.usuario.*;
import floricultura.util.ContextoUtil;
import floricultura.www.ContextoBean;

@ManagedBean(name = "enderecoBean")
@RequestScoped

public class EnderecoBean {

	private Endereco endereco = new Endereco();
	private Usuario usuarioLogado = null;
	private List<Endereco> listadeEnderecos;
	
	public String salvar() {	
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		this.usuarioLogado = contextoBean.getUsuarioLogado();
		
		EnderecoRN enderecoRN = new EnderecoRN();
		this.endereco.setUsuario(usuarioLogado);
		enderecoRN.salvar(endereco);
		return null;
	}
	
	public String excluir() {
		EnderecoRN enderecoRN = new EnderecoRN();
		enderecoRN.excluir(endereco);
		this.listadeEnderecos = null;
		return null;
	}
	
	public List<Endereco> getListadeEnderecos() {
		
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		this.usuarioLogado = contextoBean.getUsuarioLogado();	
		
		if (this.listadeEnderecos == null) {
			
			EnderecoRN enderecoRN = new EnderecoRN();
			
			if (this.usuarioLogado == null) {
				//this.listadeEnderecos = enderecoRN.listar();
			} else {
				this.listadeEnderecos = enderecoRN.listarPorUsuario(usuarioLogado);
			}
			
		}
		return listadeEnderecos;
		//return this.listadeEnderecos;
	}
	
	public Endereco buscarPorDesc(String desc){
		
		EnderecoRN enderecoRN = new EnderecoRN();
		usuarioLogado = getUsuarioLogado();
		return enderecoRN.buscarPorDescEUsuario(desc, usuarioLogado.getCodigo());
		//return enderecoRN.buscarPorDesc(desc);
		
	}
	
	public Endereco buscarPorCodigo(int codigo){
		
		EnderecoRN enderecoRN = new EnderecoRN();
		return enderecoRN.buscarPorCodigo(codigo);
		
	}
	
	public void setListadeEnderecos(List<Endereco> listadeEnderecos) {
		this.listadeEnderecos = listadeEnderecos;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	
}
