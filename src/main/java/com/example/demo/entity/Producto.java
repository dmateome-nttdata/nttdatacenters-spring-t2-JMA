package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Producto {

	@Id
	@GeneratedValue
	int id;
	String nombre;
	float precioPVP,precioSinIm;
	
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido idPedido;

	
	
	public Producto() {
		super();
	}

	public Producto(int id, String nombre, float precioPVP, float precioSinIm, Pedido idPedido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioPVP = precioPVP;
		this.precioSinIm = precioSinIm;
		this.idPedido = idPedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioPVP() {
		return precioPVP;
	}

	public void setPrecioPVP(float precioPVP) {
		this.precioPVP = precioPVP;
	}

	public float getPrecioSinIm() {
		return precioSinIm;
	}

	public void setPrecioSinIm(float precioSinIm) {
		this.precioSinIm = precioSinIm;
	}

	public Pedido getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Pedido idPedido) {
		this.idPedido = idPedido;
	}
	
	
}