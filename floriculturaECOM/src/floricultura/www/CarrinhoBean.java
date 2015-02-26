package floricultura.www;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.model.DefaultStreamedContent;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import floricultura.itemPedido.*;
import floricultura.usuario.*;
import floricultura.util.ContextoUtil;


@ManagedBean(name = "carrinhoBean")
@SessionScoped

public class CarrinhoBean {

	private Usuario usuarioLogado = null;
	private String prodNome;
	private float quantidade;
	private float prodPeso;
	private float prodPreco;
	private String prodObs;
	private ItemPedido itemPRemover;
	private ItemPedido itemSelecionado = new ItemPedido();
	private List<ItemPedido> listaItemPedido = new ArrayList<ItemPedido>();
	private ListDataModel<ItemPedido> listaItemPedidoModel = new ListDataModel<ItemPedido>();
	private ContextoBean contextoBean = ContextoUtil.getContextoBean();
	//private ContextoBean contextoBean = new ContextoBean();
	
	public String salvar() {
		contextoBean.setListaItemPedido(this.listaItemPedido);
		return null;
	}
    
	public void preencheListaItemPedido() {
		
		// Checa se n‹o Ž postback para n‹o preencher a lista com itens ap—s o resultado de um postback
		if (FacesContext.getCurrentInstance().isPostback()) {
		
		} else {
			//Segredo criar sempre nova instancia antes de acrescentar ao ArrayList
			itemSelecionado = new ItemPedido();
			
			itemSelecionado.setNome(prodNome);
			itemSelecionado.setPeso(prodPeso);
			itemSelecionado.setPreco(prodPreco);
			itemSelecionado.setObservacao(prodObs);
			itemSelecionado.setQuantidade(1);
			itemSelecionado.setPesoTotal(prodPeso);
			itemSelecionado.setPrecoTotal(prodPreco);
			
			if (listaItemPedido.isEmpty() == true){
				listaItemPedido.add(this.itemSelecionado);
			} else {
				listaItemPedido.add(listaItemPedido.lastIndexOf(itemSelecionado) + 1, itemSelecionado);
			}
		}
	}
	
	public String excluir(){
		
		 for (int i = 0; i < listaItemPedido.size(); i++) {
	    	   if (itemPRemover.getNome() == listaItemPedido.get(i).getNome()) {
	    		   listaItemPedido.remove(i);
	    		   
	    		   //Colocar mensagens de FacesMessage d‡ mensagem de erro no Datatable. (Verificar)
	    	   }	   
	       }
		return null;
	}
	
	public String adicionarQuant() {
		
		for (int i = 0; i < listaItemPedido.size(); i++) {
	    	   if (itemPRemover.getNome() == listaItemPedido.get(i).getNome()) {
	    		   listaItemPedido.get(i).setQuantidade(listaItemPedido.get(i).getQuantidade() + 1);
	    		   listaItemPedido.get(i).setPesoTotal(listaItemPedido.get(i).getQuantidade() * listaItemPedido.get(i).getPeso());
	    		   listaItemPedido.get(i).setPrecoTotal(listaItemPedido.get(i).getQuantidade() * listaItemPedido.get(i).getPreco());
	    		   
	    		   
	    	   }	   
	       }
		return null;
	}
	
	public String removerQuant() {
		
		for (int i = 0; i < listaItemPedido.size(); i++) {
	    	   if (itemPRemover.getNome() == listaItemPedido.get(i).getNome()) {
	    		   
	    		   	if (listaItemPedido.get(i).getQuantidade() == 1){
	    		   		
	    		   	} else {
	    		   		listaItemPedido.get(i).setQuantidade(listaItemPedido.get(i).getQuantidade() - 1);
	    		   		listaItemPedido.get(i).setPesoTotal(listaItemPedido.get(i).getQuantidade() * listaItemPedido.get(i).getPeso());
	 	    		    listaItemPedido.get(i).setPrecoTotal(listaItemPedido.get(i).getQuantidade() * listaItemPedido.get(i).getPreco());
	 	    		    
	 	    		   
	    		   	}
	    	   }	   
	       }
		return null;
		
	}
	
	public Usuario getUsuarioLogado(){
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
	
	
	public String getProdNome() {
		return prodNome;
	}

	public void setProdNome(String prodNome) {
		this.prodNome = prodNome;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public float getProdPeso() {
		return prodPeso;
	}

	public void setProdPeso(float prodPeso) {
		this.prodPeso = prodPeso;
	}

	public float getProdPreco() {
		return prodPreco;
	}

	public void setProdPreco(float prodPreco) {
		this.prodPreco = prodPreco;
	}

	public String getProdObs() {
		return prodObs;
	}

	public void setProdObs(String prodObs) {
		this.prodObs = prodObs;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public ItemPedido getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(ItemPedido itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public List<ItemPedido> getListaItemPedido() {
		//contextoBean.setListaItemPedido(listaItemPedido);
		return listaItemPedido;
	}

	public void setListaItemPedido(List<ItemPedido> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}

	public ListDataModel<ItemPedido> getListaItemPedidoModel() {
		return listaItemPedidoModel;
	}

	public void setListaItemPedidoModel(
			ListDataModel<ItemPedido> listaItemPedidoModel) {
		this.listaItemPedidoModel = listaItemPedidoModel;
	}

	public ItemPedido getItemPRemover() {
		return itemPRemover;
	}

	public void setItemPRemover(ItemPedido itemPRemover) {
		this.itemPRemover = itemPRemover;
	}
	
}
