package com.pricebookbr.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(
	    name="produto",
	    indexes = {
	    	@Index(name = "prod_IDX_0", columnList="barcode", unique = true)
	    }
	   )
public class Produto  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=true)
	private String nome;
	@Column(nullable=true, length=5000)
	private String descricao;
	@Column(nullable=true)
	private Double preco;
	@Column(nullable=true)
	private String barcode;
	@Column(nullable=true)
	private String unidadeMedida;
	@Column(nullable=true)
	private String urlInternet;
	
	@Column(name="dt_hr_hist", nullable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy@HH:mm:ss")
	private Date dtHoraHistorico;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id",nullable=false)  
	private Cliente cliente; 
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="PRODUTO_CATEGORIA",
		joinColumns=@JoinColumn(name="produto_id"),
		inverseJoinColumns=@JoinColumn(name="categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="PRODUTO_MARCA",
		joinColumns=@JoinColumn(name="produto_id"),
		inverseJoinColumns=@JoinColumn(name="marca_id")
	)
	private List<Marca> marcas = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="PRODUTO_CLASSIFICACAO",
		joinColumns=@JoinColumn(name="produto_id"),
		inverseJoinColumns=@JoinColumn(name="classificacao_id")
	)
	private List<Classificacao> classificacoes = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private Set<HistoricoProduto> historicoProdutos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private Set<AvaliacaoProduto> avaliacaoProdutos;

	@Column(columnDefinition = "int default 0")
	private Integer situacaoImagem;
	
	@Column(columnDefinition = "int default 0")
	private Integer imagemNaoCorrespondente;
	
	public Produto() {
		
	}

	public Produto(
			Integer id, 
			String nome, 
			String descricao, 
			Double preco, 
			String barcode,
			String unidadeMedida, 
			String urlInternet, 
			Cliente cliente, 
			Date dtHoraHistorico,
			Integer situacaoImagem,
			Integer imagemNaoCorrespondente
			) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.barcode = barcode;
		this.unidadeMedida = unidadeMedida;
		this.urlInternet = urlInternet;
		this.cliente = cliente;
		this.dtHoraHistorico = dtHoraHistorico;
		this.situacaoImagem = situacaoImagem;
		this.imagemNaoCorrespondente = 	imagemNaoCorrespondente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public String getUrlInternet() {
		return urlInternet;
	}

	public void setUrlInternet(String urlInternet) {
		this.urlInternet = urlInternet;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}
	
	public List<Classificacao> getClassificacoes() {
		return classificacoes;
	}

	public void setClassificacoes(List<Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	
	public Set<HistoricoProduto> getHistoricoProdutos() {
		return historicoProdutos;
	}

	public void setHistoricoProdutos(Set<HistoricoProduto> historicoProdutos) {
		this.historicoProdutos = historicoProdutos;
	}

	public Date getDtHoraHistorico() {
		return dtHoraHistorico;
	}

	public void setDtHoraHistorico(Date dtHoraHistorico) {
		this.dtHoraHistorico = dtHoraHistorico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<AvaliacaoProduto> getAvaliacaoProdutos() {
		return avaliacaoProdutos;
	}

	public void setAvaliacaoProdutos(Set<AvaliacaoProduto> avaliacaoProdutos) {
		this.avaliacaoProdutos = avaliacaoProdutos;
	}

	public Integer getSituacaoImagem() {
		return this.situacaoImagem;
	}

	public void setSituacaoImagem(Integer situacaoImagem) {
		this.situacaoImagem = situacaoImagem;
	}

	public Integer getImagemNaoCorrespondente() {
		return imagemNaoCorrespondente;
	}

	public void setImagemNaoCorrespondente(Integer imagemNaoCorrespondente) {
		this.imagemNaoCorrespondente = imagemNaoCorrespondente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}