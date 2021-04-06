package com.inuvens.SpringFlyway.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="empresa")
public class Empresa implements Serializable{

	private static final long serialVersionUID = 2654602596657336275L;
	

	private Long id;
	private String razaoScial;
	private String cnpj;
	private Date dataCriacao;
	private Date dataAtulizacao;
	
	public Empresa() {		
	}	
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="razao_social", nullable = false)
	public String getRazaoScial() {
		return razaoScial;
	}
	public void setRazaoScial(String razaoScial) {
		this.razaoScial = razaoScial;
	}
	
	@Column(name="cnpj", nullable = false)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_atulizao", nullable = false)
	public Date getDataAtulizacao() {
		return dataAtulizacao;
	}
	public void setDataAtulizacao(Date dataAtulizacao) {
		this.dataAtulizacao = dataAtulizacao;
	}
	
	
	@PreUpdate
	public void preUpdate() {
		dataAtulizacao = new Date();		
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtulizacao = atual;		
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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", RazaoScial=" + razaoScial + ", dataCriacao=" + dataCriacao + ", dataAtulizacao="
				+ dataAtulizacao + "]";
	}
	
	
}
