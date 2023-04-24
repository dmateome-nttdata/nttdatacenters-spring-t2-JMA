package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Producto;


@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable>{
	
	public abstract Producto findById(int id);
}
