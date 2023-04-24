package com.example.demo.serviceImpl;

import java.util.List;

import com.example.demo.entity.Pedido;
import com.example.demo.entity.Producto;
import com.example.demo.service.PedidoService;

public class PedidoServiceNoPeninsulaImpl  implements PedidoService{

	@Override
	public List<Pedido> listAllPedido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido findPedidoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido createOrder(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido addProductToAnOrder(Producto producto, int idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean breakdownOrder(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
