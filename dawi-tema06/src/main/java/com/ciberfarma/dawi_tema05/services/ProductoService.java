package com.ciberfarma.dawi_tema05.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciberfarma.dawi_tema05.models.Producto;
import com.ciberfarma.dawi_tema05.repositories.IProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private IProductoRepository repoProd;
	
	// listarTodos, obtenerPorId y agregarProducto
	public List<Producto> listarTodos(){
		return repoProd.findAll();
	}
	
	public Producto obtenerPorId(String id) {
		return repoProd.findById(id).orElse(null);
		// return repoProd.getById(id);
	}
	
	public Producto agregarProducto(Producto producto) {
		return repoProd.save(producto);
	}
	
	// eliminar un Producto (id)
	public void eliminarProducto(String id) {
		repoProd.deleteById(id);
	}
	
	
	// actualizar un Producto
	public Producto actualizarProducto(Producto producto) {
		return repoProd.save(producto);
	}
	
}
