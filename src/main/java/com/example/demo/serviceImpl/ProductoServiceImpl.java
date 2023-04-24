package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	@Qualifier("productoRepository")
	private ProductoRepository productRepository;

	@Override
	public Producto addProducto(Producto producto) {
		return productRepository.save(producto);
	}

	@Override
	public List<Producto> listAllProducto() {
		return productRepository.findAll();
	}

	@Override
	public Producto findProductoById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public boolean removeProducto(int id) {
		 if(productRepository.findById(id)!=null) {
			 productRepository.deleteById(id);
	            return true;
	        }
	        else
	            return false;
	}

}
