package com.ciberfarma.dawi_tema05.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ciberfarma.dawi_tema05.models.Producto;
import com.ciberfarma.dawi_tema05.models.Usuario;
import com.ciberfarma.dawi_tema05.repositories.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository repoUsua;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Usuario> listarTodos(){
		return repoUsua.findAll();
	}
	
	public Usuario registrarUsuario(Usuario usuario) {
		 // codifica la contraseña antes de guardarla
		 String claveCodificada = passwordEncoder.encode(usuario.getClave());
		 usuario.setClave(claveCodificada);
		 return repoUsua.save(usuario);
	}
	
}
