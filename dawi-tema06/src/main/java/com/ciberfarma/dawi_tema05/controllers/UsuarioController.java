package com.ciberfarma.dawi_tema05.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciberfarma.dawi_tema05.models.Producto;
import com.ciberfarma.dawi_tema05.models.Usuario;
import com.ciberfarma.dawi_tema05.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService servicio;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarTodos(){
		List<Usuario> usuarios = servicio.listarTodos();
		// validación
		if (usuarios.isEmpty()) {  // si la lista está vacía
			return ResponseEntity.noContent().build(); // solo envía el estado 204
		} else {
			return ResponseEntity.ok(usuarios);  // retorna el listado si es Ok
		}
		 
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
		try {
			Usuario nuevo = servicio.registrarUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}	
	
}
