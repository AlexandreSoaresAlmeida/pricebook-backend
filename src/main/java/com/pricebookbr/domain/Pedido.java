package com.pricebookbr.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pricebookbr.domain.enums.SituacaoEntrega;


@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		
		@JsonFormat(pattern="dd/MM/yyyy HH:mm")
		private Date instante;
		
		@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
		private Pagamento pagamento;
		
		@ManyToOne
		@JoinColumn(name="cliente_id")
		private Cliente cliente;
		
		@ManyToOne
		@JoinColumn(name="endereco_de_entrega_id")
		private Endereco enderecoDeEntrega;
		
		@OneToMany(mappedBy="id.pedido")
		private Set<ItemPedido> itens = new HashSet<>();
				
		private Integer situacaoEntrega;
		
		public Pedido() {
			
		}

		public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega, SituacaoEntrega situacaoEntrega) {
			super();
			this.id = id;
			this.instante = instante;
			this.cliente = cliente;
			this.enderecoDeEntrega = enderecoDeEntrega;
			this.situacaoEntrega = (situacaoEntrega ==  null) ? null : situacaoEntrega.getCod();
		}

		public double getValorTotal() {
			double soma = 0.0;
			for (ItemPedido ip : this.itens) {
				soma = soma + ip.getSubTotal();
			}
			return soma;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Date getInstante() {
			return instante;
		}

		public void setInstante(Date instante) {
			this.instante = instante;
		}

		public Pagamento getPagamento() {
			return pagamento;
		}

		public void setPagamento(Pagamento pagamento) {
			this.pagamento = pagamento;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Endereco getEnderecoDeEntrega() {
			return enderecoDeEntrega;
		}

		public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
			this.enderecoDeEntrega = enderecoDeEntrega;
		}


		public Set<ItemPedido> getItens() {
			return itens;
		}

		public void setItens(Set<ItemPedido> itens) {
			this.itens = itens;
		}
		
		public SituacaoEntrega getSituacaoEntrega() {
			return SituacaoEntrega.toEnum(situacaoEntrega);
		}

		public void setSituacaoEntrega(SituacaoEntrega situacaoEntrega) {
			this.situacaoEntrega = situacaoEntrega.getCod();
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
			Pedido other = (Pedido) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			StringBuilder builder = new StringBuilder();
			builder.append("\n===========================================");
			builder.append("\n SISTEK - Sistema E-Commerce AUTOTEK");
			builder.append("\n Compra realizada via AUTO-ATENDIMENTO");
			builder.append("\n===========================================");
			builder.append("\n:: Código do Pedido: ");
			builder.append(getId());
			builder.append("\n===========================================");
			builder.append("\n                 COMPROVANTE DO PEDIDO ");
			builder.append("\n===========================================");
			builder.append("\nInstante: ");
			builder.append(sdf.format(getInstante()));
			builder.append("\nCliente: ");
			builder.append(getCliente().getNome());
			builder.append("\n-------------------------------------------");
			/*
			builder.append("\n   Endereço de Entrega: ");
			builder.append(getEnderecoDeEntrega().toString());
			builder.append("\n-------------------------------------------");
			*/
			builder.append("\nSituação do pagamento: ");
			builder.append(getPagamento().getEstado().getDescricao());
			builder.append("\n-------------------------------------------");
			builder.append("\n>Detalhes:\n");
			for (ItemPedido ip : getItens()) {
				builder.append("\n . " + ip.toString().trim());
				builder.append("\n...........................................");
			}
			builder.append("\n>> Valor total: ");
			builder.append(nf.format(getValorTotal()));
			builder.append("\n===========================================");
			builder.append("\n * Obrigado por comprar conosco. ");
			builder.append("\n===========================================");
			return builder.toString();
		}
}