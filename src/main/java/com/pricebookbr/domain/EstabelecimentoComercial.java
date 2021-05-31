package com.pricebookbr.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EstabelecimentoComercial implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String sinteseEndereco;
	
	private Double latitudeInicial;
	private Double longitudeInicial;

	private Double latitudeFinal;
	private Double longitudeFinal;
	
	@JsonIgnore
    @OneToMany(mappedBy = "estabelecimentoComercial", cascade = CascadeType.ALL)
    private Set<LocalCompra> localCompra;
	
	public EstabelecimentoComercial() {
		
	}

	public EstabelecimentoComercial(
			Integer id, 
			String nome, 
			String sinteseEndereco,
			Double Final,
			Double latitudeInicial,
			Double longitudeInicial,
			Double longitudeFinal,
			Double latitudeFinal
			) {
		super();
		this.id = id;
		this.nome = nome;
		this.sinteseEndereco = sinteseEndereco;
		this.longitudeInicial = longitudeInicial;
		this.latitudeInicial  = latitudeInicial;
		this.longitudeFinal = longitudeFinal;
		this.latitudeFinal  = latitudeInicial;
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
	
	public String getSinteseEndereco() {
		return sinteseEndereco;
	}

	public void setSinteseEndereco(String sinteseEndereco) {
		this.sinteseEndereco = sinteseEndereco;
	}

	public Double getLatitudeInicial() {
		return latitudeInicial;
	}

	public void setLatitudeInicial(Double latitudeInicial) {
		this.latitudeInicial = latitudeInicial;
	}

	public Double getLongitudeInicial() {
		return longitudeInicial;
	}

	public void setLongitudeInicial(Double longitudeInicial) {
		this.longitudeInicial = longitudeInicial;
	}

	public Double getLatitudeFinal() {
		return latitudeFinal;
	}

	public void setLatitudeFinal(Double latitudeFinal) {
		this.latitudeFinal = latitudeFinal;
	}

	public Double getLongitudeFinal() {
		return longitudeFinal;
	}

	public void setLongitudeFinal(Double longitudeFinal) {
		this.longitudeFinal = longitudeFinal;
	}
	
	public Set<LocalCompra> getLocalCompra() {
		return localCompra;
	}

	public void setLocalCompra(Set<LocalCompra> localCompra) {
		this.localCompra = localCompra;
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
		EstabelecimentoComercial other = (EstabelecimentoComercial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}