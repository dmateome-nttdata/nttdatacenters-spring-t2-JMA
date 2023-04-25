package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	int id;
	String destinatario, direccion, localidad;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
	private List<Producto> productoList;

	public Pedido() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Producto> getProductoList() {
		return productoList;
	}

	public void setProductoList(List<Producto> productoList) {
		this.productoList = productoList;
	}

	public Pedido(int id, String destinatario, String direccion, String localidad,
			List<Producto> productoList) {
		super();
		this.id = id;
		this.destinatario = destinatario;
		this.direccion = direccion;
		this.localidad = localidad;
		this.productoList = productoList;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", destinatario=" + destinatario + ", direccion=" + direccion + ", localidad="
				+ localidad+ ", productoList=" + productoList + "]";
	}

}
