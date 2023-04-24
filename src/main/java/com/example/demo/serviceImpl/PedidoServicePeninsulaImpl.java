package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.entity.Pedido;
import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.PedidoService;

public class PedidoServicePeninsulaImpl implements PedidoService{

	@Autowired
	@Qualifier("productoRepository")
	private ProductoRepository productRepository;
	
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
