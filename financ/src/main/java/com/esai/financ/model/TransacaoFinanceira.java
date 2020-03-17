package com.esai.financ.model;

import java.math.BigDecimal;

public class TransacaoFinanceira {
	String data; // data do mes
	String descricao; //descricao 
	String docto; // numero da transacao
	String situação ; 
	BigDecimal credito; //transcao a credito
	BigDecimal debito; //transcao a debito
	BigDecimal saldo; // saldo
	public TransacaoFinanceira(String data, String descricao, String docto, String situação, BigDecimal credito,
			BigDecimal debito, BigDecimal saldo) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.docto = docto;
		this.situação = situação;
		this.credito = credito;
		this.debito = debito;
		this.saldo = saldo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDocto() {
		return docto;
	}
	public void setDocto(String docto) {
		this.docto = docto;
	}
	public String getSituação() {
		return situação;
	}
	public void setSituação(String situação) {
		this.situação = situação;
	}
	public BigDecimal getCredito() {
		return credito;
	}
	public void setCredito(BigDecimal credito) {
		this.credito = credito;
	}
	public BigDecimal getDebito() {
		return debito;
	}
	public void setDebito(BigDecimal debito) {
		this.debito = debito;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "TF [data=" + data + ", descricao=" + descricao + ", docto=" + docto + ", situação="
				+ situação + ", credito=" + credito + ", debito=" + debito + ", saldo=" + saldo + "]";
	}

}
