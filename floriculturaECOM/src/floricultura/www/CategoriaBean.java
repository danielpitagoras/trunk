package floricultura.www;

import javax.faces.bean.*;
import java.util.List;
import floricultura.categoria.Categoria;
import floricultura.categoria.CategoriaRN;

@ManagedBean(name = "categoriaBean")
@RequestScoped

public class CategoriaBean {

	private Categoria categoria = new Categoria();
	private List<Categoria> lista;
	private String destinoSalvar;

	public String novo(){
		this.destinoSalvar = "categoriaSucesso";
		this.categoria = new Categoria();
		return "categoria";
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String salvar() {
		
		CategoriaRN categoriaRN = new CategoriaRN();
		categoriaRN.salvar(this.categoria);
		return this.destinoSalvar;
		
	}
	
	public String excluir(){
		CategoriaRN categoriaRN = new CategoriaRN();
		categoriaRN.excluir(this.categoria);
		this.lista=null;
		return null;
		
	}
	
	public Categoria buscarPorNome(String nome){
		
		CategoriaRN categoriaRN = new CategoriaRN();
		return categoriaRN.buscarPorNome(nome);
		
	}
	
	public List<Categoria> getLista() {
		
		if(this.lista == null) {
			CategoriaRN categoriaRN = new CategoriaRN();
			this.lista = categoriaRN.listar();
		}
		return this.lista;
	}
	
}
