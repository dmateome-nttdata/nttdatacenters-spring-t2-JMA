package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pedido;
import com.example.demo.entity.Producto;
import com.example.demo.service.PedidoService;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	@Qualifier("pedidoServiceNoPeninsula")
	private PedidoService pedidoServiceNoPeninsula;

	@Autowired
	@Qualifier("pedidoServicePeninsula")
	private PedidoService pedidoServicePeninsula;
	
	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;
	
	@PostMapping("/producto/{id}")
	public ResponseEntity<?> insertProducto(@RequestBody Producto producto, @PathVariable int id) {
		
		Pedido p = pedidoServicePeninsula.findPedidoById(id);
		producto.setIdPedido(p);
		
		if (p.getLocalidad().equals("Ceuta") || p.getLocalidad().equals("Melilla")
				|| p.getLocalidad().equals("Canarias")) {
			pedidoServiceNoPeninsula.addProductToAnOrder(producto, id);
			return ResponseEntity.status(HttpStatus.CREATED)
					.build();

		} else {
			pedidoServicePeninsula.addProductToAnOrder(producto, id);
			return ResponseEntity.status(HttpStatus.CREATED)
					.build();
		}

	}
}
