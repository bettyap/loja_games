package com.generation.lojagames.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull(message = "O atributo Nome é obrigatório")
	private String nome;
	
	@NotNull(message = "O atributo Descrição é obrigatório")
	private String descricao;
	
	@NotNull(message = "O atributo Console é obrigatório")
	private String console;
	
	@Column(name = "data_lancamento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@UpdateTimestamp
	private LocalDateTime lancamento;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "O atributo preço é Obrigatório!")
	@Positive(message = "O preço deve ser maior do que zero!")
	private BigDecimal preco;
	
	private String foto;
	
	@Column(columnDefinition = "integer default 0")
	private int curtir;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}
	
	public LocalDateTime getLancamento() {
		return lancamento;
	}

	public void setLancamento(LocalDateTime lancamento) {
		this.lancamento = lancamento;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCurtir() {
		return curtir;
	}

	public void setCurtir(int curtir) {
		this.curtir = curtir;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
