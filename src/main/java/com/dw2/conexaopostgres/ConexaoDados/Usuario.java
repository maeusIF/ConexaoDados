package com.dw2.conexaopostgres.ConexaoDados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id_bike;
	private String nomeb;
	private String marca;
	private String tamanho;
	private String mtb_road;
	private String tipo;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id_bike ^ (Id_bike >>> 32));
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((mtb_road == null) ? 0 : mtb_road.hashCode());
		result = prime * result + ((nomeb == null) ? 0 : nomeb.hashCode());
		result = prime * result + ((tamanho == null) ? 0 : tamanho.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Usuario other = (Usuario) obj;
		if (Id_bike != other.Id_bike)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (mtb_road == null) {
			if (other.mtb_road != null)
				return false;
		} else if (!mtb_road.equals(other.mtb_road))
			return false;
		if (nomeb == null) {
			if (other.nomeb != null)
				return false;
		} else if (!nomeb.equals(other.nomeb))
			return false;
		if (tamanho == null) {
			if (other.tamanho != null)
				return false;
		} else if (!tamanho.equals(other.tamanho))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	public long getId_bike() {
		return Id_bike;
	}
	public void setId_bike(long id_bike) {
		Id_bike = id_bike;
	}
	public String getNomeb() {
		return nomeb;
	}
	public void setNomeb(String nomeb) {
		this.nomeb = nomeb;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getMtb_road() {
		return mtb_road;
	}
	public void setMtb_road(String mtb_road) {
		this.mtb_road = mtb_road;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
