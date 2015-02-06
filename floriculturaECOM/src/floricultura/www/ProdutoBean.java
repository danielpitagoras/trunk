package floricultura.www;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.*;

import javax.faces.bean.*;
import javax.faces.event.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import floricultura.produto.Produto;
import floricultura.produto.ProdutoRN;
import floricultura.usuario.UsuarioRN;
import floricultura.util.ContextoUtil;

@ManagedBean(name = "produtoBean")
@RequestScoped

public class ProdutoBean {
	
	private Produto selecionado = new Produto();
	private List<Produto> lista;
	private Part arqImagem;
	private StreamedContent imgStream;

	public void setImgStream(StreamedContent imgStream) {
		this.imgStream = imgStream;
	}


	public List<Produto> getLista() {
		
		if (this.lista == null) {
			
			ProdutoRN produtoRN = new ProdutoRN();
			//ContextoBean contextoBean = ContextoUtil.getContextoBean();
			this.lista = produtoRN.listar();
			
			//System.out.println(produto.getNome());
			//for (Produto produto: lista) {
			//		contextoBean.setImgb(produto.getImagem());
			//}
		}
		return this.lista;
	}
	
	public String salvar() {
		
		ProdutoRN produtoRN = new ProdutoRN();
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		this.selecionado.setImagem(contextoBean.getProdutoImage());
		produtoRN.salvar(this.selecionado);
		return null;		
		
	}
	
	public String excluir(){
		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.excluir(this.selecionado);
		return null;
	}
	
	public Produto getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Produto selecionado) {
		this.selecionado = selecionado;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	public Part getArqImagem() {
		return arqImagem;
	}

	public void setArqImagem(Part arqImagem) {
		this.arqImagem = arqImagem;
	}
	
}
