package br.com.banco.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private OffsetDateTime dataTransferencia;
	private BigDecimal valor;
	private String tipo;
	private String nomeOperadorTransacao;
	private int contaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(OffsetDateTime dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNomeOperadorTransacao() {
		return nomeOperadorTransacao;
	}

	public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}

	public int getContaId() {
		return contaId;
	}

	public void setContaId(int contaId) {
		this.contaId = contaId;
	}

}
