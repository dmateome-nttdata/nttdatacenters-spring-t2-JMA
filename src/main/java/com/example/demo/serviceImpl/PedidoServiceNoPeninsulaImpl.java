package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pedido;
import com.example.demo.entity.Producto;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.PedidoService;

@Service("pedidoServiceNoPeninsula")
public class PedidoServiceNoPeninsulaImpl implements PedidoService {

	@Autowired
	@Qualifier("pedidoRepository")
	private PedidoRepository pedidoRepository;

	@Autowired
	@Qualifier("productoRepository")
	private ProductoRepository productRepository;

	@Override
	public List<Pedido> listAllPedido() {
		// TODO Auto-generated method stub
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido findPedidoById(int id) {
		// TODO Auto-generated method stub
		return pedidoRepository.findById(id);
	}

	@Override
	public Pedido createOrder(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido addProductToAnOrder(Producto producto, int idPedido) {
		// TODO Auto-generated method stub

		Pedido p = pedidoRepository.findById(idPedido);
		List<Producto> productos = p.getProductoList();
		
		// Insert precio
		Float precioSinIva = producto.getPrecioSinIm();
		producto.setPrecioPVP((float) (precioSinIva * 1.04));
		Float total = p.getTotalPrecio();
		total += producto.getPrecioPVP();
		p.setTotalPrecio(total);

		// Insert Producto
		productos.add(producto);
		p.setProductoList(productos);
		System.out.println(p);

		return pedidoRepository.save(p);
	}

	@Override
	public boolean breakdownOrder(int id) {
		// TODO Auto-generated method stub
		if (pedidoRepository.findById(id) != null) {
			pedidoRepository.delete(pedidoRepository.findById(id));
			return true;
		} else
			return false;
	}

}
