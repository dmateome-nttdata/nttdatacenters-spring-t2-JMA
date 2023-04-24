package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Producto;


public interface ProductoService {

	public abstract Producto addProducto(Producto producto);
    public abstract List<Producto> listAllProducto();
    public abstract Producto findProductoById(int id);
    public abstract boolean removeProducto(int id);
}
