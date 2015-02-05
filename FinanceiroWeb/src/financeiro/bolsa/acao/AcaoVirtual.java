package financeiro.bolsa.acao;

public class AcaoVirtual {

	private Acao acao = new Acao();
	private float ultimopreco;
	private float total;
	
	public Acao getAcao() {
		return acao;
	}
	public void setAcao(Acao acao) {
		this.acao = acao;
	}
	public float getUltimopreco() {
		return ultimopreco;
	}
	public void setUltimopreco(float ultimopreco) {
		this.ultimopreco = ultimopreco;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
	
}
