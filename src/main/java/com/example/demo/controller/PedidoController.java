package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pedido;
import com.example.demo.entity.Producto;
import com.example.demo.service.PedidoService;

@RestController
@RequestMapping("/api")
public class PedidoController {

	@Autowired
	@Qualifier("pedidoServiceNoPeninsula")
	private PedidoService pedidoServiceNoPeninsula;

	@Autowired
	@Qualifier("pedidoServicePeninsula")
	private PedidoService pedidoServicePeninsula;

	@GetMapping("/pedidos")
	public ResponseEntity<?> getPedidos() {
		boolean exist = pedidoServicePeninsula.listAllPedido() != null;
		if (exist) {
			List<Pedido> product = pedidoServicePeninsula.listAllPedido();
			return ResponseEntity.ok(product);
		} else
			return ResponseEntity.noContent().build();
	}

	@GetMapping("/pedidos/{id}")
	public ResponseEntity<?> getPedidoById(@PathVariable int id) {
		boolean exist = pedidoServicePeninsula.findPedidoById(id) != null;
		if (exist) {
			Pedido pedido = pedidoServicePeninsula.findPedidoById(id);
			return ResponseEntity.ok(pedido);
		} else
			return ResponseEntity.noContent().build();
	}

	@PostMapping("/pedido")
	public ResponseEntity<?> insertPedidoNew(@RequestBody Pedido pedido) {
		pedidoServicePeninsula.createOrder(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
	}

	@DeleteMapping("/pedidos/{id}")
	public ResponseEntity<?> deletePedido(@PathVariable int id) {
		boolean exists = pedidoServicePeninsula.breakdownOrder(id);
		if (exists)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.noContent().build();
	}

	@PostMapping("/producto/{id}")
	public ResponseEntity<?> insertProducto(@RequestBody Producto producto, @PathVariable int id) {

		Pedido p = pedidoServicePeninsula.findPedidoById(id);
		producto.setIdPedido(p);

		if (p.getLocalidad().equals("Ceuta") || p.getLocalidad().equals("Melilla")
				|| p.getLocalidad().equals("Canarias")) {
			Producto proc = pedidoServiceNoPeninsula.addProductToAnOrder(producto, id);
			return ResponseEntity.status(HttpStatus.CREATED).body(proc);

		} else {
			Producto proc = pedidoServicePeninsula.addProductToAnOrder(producto, id);
			return ResponseEntity.status(HttpStatus.CREATED).body(proc);
		}

	}

}
