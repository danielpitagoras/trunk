package financeiro.web;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import financeiro.categoria.Categoria;
import financeiro.cheque.Cheque;
import financeiro.cheque.ChequeId;
import financeiro.cheque.ChequeRN;
import financeiro.conta.Conta;
import financeiro.lancamento.*;
import financeiro.util.RNException;
import financeiro.util.ContextoUtil;

@ManagedBean(name = "lancamentoBean")
@ViewScoped

public class LancamentoBean {

	private List<Lancamento> lista;
	private List<Double> saldos= new ArrayList<Double>();
	private List<Lancamento> listaAteHoje;
	private List<Lancamento> listaFuturos;
	private float	saldoGeral;
	private Lancamento	editado = new Lancamento();
	private Integer numeroCheque;
	
	public LancamentoBean() {
		this.novo();
	}
	
	public void novo(){
		this.editado = new Lancamento();
		this.editado.setData(new Date(System.currentTimeMillis()));
		this.numeroCheque = null;
	}
	
	public void editar(){
		Cheque cheque = this.editado.getCheque();
		if (cheque != null) {
			this.numeroCheque = cheque.getChequeId().getCheque();
		}
	}
	
	public void salvar(){
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		this.editado.setUsuario(contextoBean.getUsuarioLogado());
		this.editado.setConta(contextoBean.getContaAtiva());
		
		ChequeRN chequeRN = new ChequeRN();
		ChequeId chequeId = null;
		if (this.numeroCheque != null){
			chequeId = new ChequeId();
			chequeId.setConta(contextoBean.getContaAtiva().getConta());
			chequeId.setCheque(this.numeroCheque);
			Cheque cheque = chequeRN.carregar(chequeId);
			FacesContext context = FacesContext.getCurrentInstance();
			if (cheque == null){
				FacesMessage msg = new FacesMessage("Cheque não cadastrado");
				context.addMessage(null, msg);
				return;
			} else if (cheque.getSituacao() == Cheque.SITUACAO_CHEQUE_CANCELADO) {
				FacesMessage msg = new FacesMessage("Cheque já cancelado");
				context.addMessage(null, msg);
				return;
			} else {
				this.editado.setCheque(cheque);
				chequeRN.baixarCheque(chequeId, this.editado);
			}
		}
		
		LancamentoRN lancamentoRN = new LancamentoRN();
		lancamentoRN.salvar(this.editado);
		
		this.novo();
		this.lista = null;
	}
	
	public void mudouCheque(ValueChangeEvent event) {
		Integer chequeAnterior = (Integer) event.getOldValue();
		if (chequeAnterior != null){
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			ChequeRN chequeRN = new ChequeRN();
			try {
				chequeRN.desvinculaLancamento(contextoBean.getContaAtiva(), chequeAnterior);
			} catch (RNException e) {
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage msg = new FacesMessage(e.getMessage());
				context.addMessage(null, msg);
				return;
			}
		}
	}
	
	public void excluir() {
		LancamentoRN lancamentoRN = new LancamentoRN();
		this.editado = lancamentoRN.carregar(this.editado.getLancamento());
		lancamentoRN.excluir(this.editado);
		this.lista = null;
	}
	
	public List<Lancamento> getLista() {
		if (this.lista == null) {
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			Conta conta = contextoBean.getContaAtiva();
			
			Calendar dataSaldo = new GregorianCalendar();
			dataSaldo.add(Calendar.MONTH, -1);
			dataSaldo.add(Calendar.DAY_OF_MONTH, -1);
			
			Calendar inicio = new GregorianCalendar();
			inicio.add(Calendar.MONTH, -1);
			
			LancamentoRN lancamentoRN = new LancamentoRN();
			this.saldoGeral = lancamentoRN.saldo(conta, dataSaldo.getTime());
			this.lista = lancamentoRN.listar(conta, inicio.getTime(), null);
			
			Categoria categoria = null;
			double saldo = this.saldoGeral;
			for (Lancamento lancamento : this.lista) {
				categoria = lancamento.getCategoria();
				saldo = saldo + (lancamento.getValor().floatValue() * categoria.getFator());
				this.saldos.add(saldo);
			}
		}
		return this.lista;
	}
	
	public List<Lancamento> getListaAteHoje() {
		if(this.listaAteHoje == null) {
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			Conta conta = contextoBean.getContaAtiva();
			
			Calendar hoje = new GregorianCalendar();
			
			LancamentoRN lancamentoRN = new LancamentoRN();
			this.listaAteHoje = lancamentoRN.listar(conta,  null, hoje.getTime());
		}
		return this.listaAteHoje;
		
	}
	public List<Lancamento> getListaFuturos() {
		if(this.listaFuturos == null) {
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			Conta conta = contextoBean.getContaAtiva();
			
			Calendar amanha = new GregorianCalendar();
			amanha.add(Calendar.DAY_OF_MONTH, 1);
			
			LancamentoRN lancamentoRN = new LancamentoRN();
			this.listaFuturos = lancamentoRN.listar(conta, amanha.getTime(), null);
		}
		return this.listaFuturos;
	}
}
