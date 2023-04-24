package com.example.demo.repository;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Pedido;

@Repository("pedidoRepository")
public interface PedidoRepository extends JpaRepository<Pedido, Serializable> {
	public abstract Pedido findById(int id);
}
