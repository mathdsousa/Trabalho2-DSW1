package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(value = { "usuario" })
@Entity
@Table(name = "Compra")
public class Compra extends AbstractEntity<Long> {

	@NotNull
	@Column(nullable = false, length = 19)
	private String data;
    
	@NotNull
	@Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
	private BigDecimal valor;
    
	@NotNull(message = "{NotNull.compra.livro}")
	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Livro livro;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
		setValor(livro.getPreco());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
