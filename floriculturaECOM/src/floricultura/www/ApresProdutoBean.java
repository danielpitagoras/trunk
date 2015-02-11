package floricultura.www;

import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import floricultura.produto.Produto;
import floricultura.produto.ProdutoRN;
import floricultura.categoria.Categoria;

@ManagedBean(name = "apresProdutoBean")
@RequestScoped

public class ApresProdutoBean {

	private Categoria catSelecionada;
	private List<Produto> lista;

	public List<Produto> getLista() {
		
		if (this.lista == null) {
			
			ProdutoRN produtoRN = new ProdutoRN();			
			
			if (catSelecionada == null) {
				this.lista = produtoRN.listar();
			} else {
				this.lista = produtoRN.listarPorCategoria(catSelecionada);
			}
		}
		return this.lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}

	public Categoria getCatSelecionada() {
		
		return catSelecionada;
		
	}

	public void setCatSelecionada(Categoria catSelecionada) {
		this.catSelecionada = catSelecionada;
	}
	
	
}
