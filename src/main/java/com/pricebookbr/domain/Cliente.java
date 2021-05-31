package com.pricebookbr.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pricebookbr.domain.enums.Perfil;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Column(unique=true)
	private String email;
	
//	private String cpfOuCnpj;
//	private Integer tipo;
	
	@JsonIgnore
	private String senha;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy@HH:mm:ss")
	private Date aceiteTermoUso;
	
//	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
//	private List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<Integer>();
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	@JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<HistoricoProduto> historicoProdutos;
	
	@JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Produto> Produtos; // = new HashSet<>();

	@JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<HistoricoAcesso> HistoricoAcessos; // = new HashSet<>();
	
	@JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Versao> versoesPublicadas; // = new HashSet<>();

	@JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<AvaliacaoProduto> avaliacaoProduto;
	
	@Column(columnDefinition = "int default 0")
	private Integer situacaoImagem;
	
	public Cliente() {
		addPerfil(Perfil.CLIENTE);		
	}

	public Cliente(
			Integer id, 
			String nome, 
			String email, 
			//String cpfOuCnpj, 
			//TipoCliente tipo, 
			String senha,
			Date aceiteTermoUso,
			Integer situacaoImagem
			) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
//		this.cpfOuCnpj = cpfOuCnpj;
//		this.tipo = (tipo ==  null) ? null : tipo.getCod();
		this.senha = senha;
		this.aceiteTermoUso = aceiteTermoUso;
		addPerfil(Perfil.CLIENTE);
		this.situacaoImagem = situacaoImagem;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
/*
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}
*/
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
/*
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
*/
	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	public Date getAceiteTermoUso() {
		return aceiteTermoUso;
	}

	public void setAceiteTermoUso(Date aceiteTermoUso) {
		this.aceiteTermoUso = aceiteTermoUso;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<HistoricoProduto> getHistoricoProdutos() {
		return historicoProdutos;
	}

	public void setHistoricoProdutos(Set<HistoricoProduto> historicoProdutos) {
		this.historicoProdutos = historicoProdutos;
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}

	public Set<Produto> getProdutos() {
		return Produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		Produtos = produtos;
	}

	public Set<HistoricoAcesso> getHistoricoAcessos() {
		return HistoricoAcessos;
	}

	public void setHistoricoAcessos(Set<HistoricoAcesso> historicoAcessos) {
		HistoricoAcessos = historicoAcessos;
	}
	
	public Set<Versao> getVersoesPublicadas() {
		return versoesPublicadas;
	}

	public void setVersoesPublicadas(Set<Versao> versoesPublicadas) {
		this.versoesPublicadas = versoesPublicadas;
	}
	
	public Set<AvaliacaoProduto> getAvaliacaoProduto() {
		return avaliacaoProduto;
	}

	public void setAvaliacaoProduto(Set<AvaliacaoProduto> avaliacaoProduto) {
		this.avaliacaoProduto = avaliacaoProduto;
	}

	public Integer getSituacaoImagem() {
		return situacaoImagem;
	}

	public void setSituacaoImagem(Integer situacaoImagem) {
		this.situacaoImagem = situacaoImagem;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
