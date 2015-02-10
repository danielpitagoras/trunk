package floricultura.itemPedido;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import floricultura.pedido.Pedido;

@Entity
@Table(name = "itemPedido")

public class ItemPedido implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4084458738771341393L;

	@Id 
	@GeneratedValue
	@Column(name = "item_pedido")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name = "cod_pedido", nullable = false)
	private Pedido pedido;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "quantidade", nullable = false)
	private float quantidade;
	
	@Column(name = "peso")
	private float peso;
	
	@Column(name = "preco", nullable = false)
	private float preco;
	
	@Column(name = "obs")
	private String observacao;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + Float.floatToIntBits(peso);
		result = prime * result + Float.floatToIntBits(preco);
		result = prime * result + Float.floatToIntBits(quantidade);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		if (Float.floatToIntBits(quantidade) != Float
				.floatToIntBits(other.quantidade))
			return false;
		return true;
	}
	
	
}
