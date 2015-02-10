package floricultura.pedido;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import floricultura.usuario.Usuario;

@Entity
@Table(name = "pedido")

public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5117301945023034742L;

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario usuario;
	
	@Column(name = "data_Pedido", nullable = false)
	private Date dataPedido;
	
	@Column(name = "endereco_entrega", nullable = false)
	private String enderecoEntrega;
	
	@Column(name = "peso_total")
	private float pesoTotal;
	
	@Column(name = "preco_total", nullable = false)
	private float precoTotal;
	
	@Column(name = "obs")
	private String observacao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public float getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(float pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
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
		result = prime * result
				+ ((dataPedido == null) ? 0 : dataPedido.hashCode());
		result = prime * result
				+ ((enderecoEntrega == null) ? 0 : enderecoEntrega.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + Float.floatToIntBits(pesoTotal);
		result = prime * result + Float.floatToIntBits(precoTotal);
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Pedido other = (Pedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataPedido == null) {
			if (other.dataPedido != null)
				return false;
		} else if (!dataPedido.equals(other.dataPedido))
			return false;
		if (enderecoEntrega == null) {
			if (other.enderecoEntrega != null)
				return false;
		} else if (!enderecoEntrega.equals(other.enderecoEntrega))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (Float.floatToIntBits(pesoTotal) != Float
				.floatToIntBits(other.pesoTotal))
			return false;
		if (Float.floatToIntBits(precoTotal) != Float
				.floatToIntBits(other.precoTotal))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}
