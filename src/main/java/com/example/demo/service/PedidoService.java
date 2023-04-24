package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Pedido;
import com.example.demo.entity.Producto;

public interface PedidoService {

    public abstract List<Pedido> listAllPedido();
    public abstract Pedido findPedidoById(int id);
    public abstract Pedido createOrder(Pedido pedido);
    public abstract Pedido addProductToAnOrder(Producto producto,int idPedido);
    public abstract boolean breakdownOrder(int id);
    
    
}
