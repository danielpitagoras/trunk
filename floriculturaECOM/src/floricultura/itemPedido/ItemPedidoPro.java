package floricultura.itemPedido;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import floricultura.itemPedido.ItemPedido;

@ManagedBean(name = "itemPedidoLista", eager = true)
@SessionScoped

public class ItemPedidoPro {

	private List<ItemPedido> listaItemPedido = new ArrayList<ItemPedido>();

	public List<ItemPedido> getListaItemPedido() {
		return listaItemPedido;
	}

	public void setListaItemPedido(List<ItemPedido> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}
	
	
}
