package com.ciberfarma.dawi_tema05.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciberfarma.dawi_tema05.models.Producto;
import com.ciberfarma.dawi_tema05.services.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

	@Autowired
	private ProductoService servicio;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listarTodos(){
		List<Producto> productos = servicio.listarTodos();
		// validación
		if (productos.isEmpty()) {  // si la lista está vacía
			return ResponseEntity.noContent().build(); // solo envía el estado 204
		} else {
			return ResponseEntity.ok(productos);  // retorna el listado si es Ok
		}
		 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> obtenerPorId(@PathVariable String id){
		Producto producto = servicio.obtenerPorId(id);
		
		if (producto == null) {  // no existe (vacío)
			return ResponseEntity.notFound().build(); // estado 404
		} 
		return ResponseEntity.ok(producto);  // retorna el listado si es Ok
		
	}
	
	@PostMapping
	public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
		try {
			Producto nuevo = servicio.agregarProducto(producto);
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarProducto(@PathVariable String id){
		Producto producto = servicio.obtenerPorId(id);
		if (producto == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Producto No existe");
		}
		try {
			servicio.eliminarProducto(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Producto Eliminado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar");
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarProducto(@PathVariable String id, @RequestBody Producto nuevo){
		Producto anterior = servicio.obtenerPorId(id);		
		if (anterior == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Producto No existe");
		}
		// seteamos los datos a cambiar
		anterior.setDes_prod(nuevo.getDes_prod());
		anterior.setStk_prod(nuevo.getStk_prod());
		// otros campos
		try {
			Producto cambiado = servicio.actualizarProducto(anterior);
			return ResponseEntity.status(HttpStatus.CREATED).body("Producto actualizado:" + cambiado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar");
		}
	}
	
	
	
	
	
}
