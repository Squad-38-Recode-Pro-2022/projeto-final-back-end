package br.org.com.recode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.com.recode.model.Usuario;
import br.org.com.recode.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// lista todos os usuários
	@GetMapping("/cadastro-usuario")
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}
	
	// create usuário rest api
	@PostMapping("/cadastro-usuario")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	// get usuário by id rest api
	@GetMapping("/cadastro-usuario/{id}")
	public Usuario getUsuarioById(@PathVariable Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	// update usuário rest api
	
	@PutMapping("/cadastro-usuario/{id}")
	public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
		Usuario usuario = usuarioRepository.findById(id).get();
		
		usuario.setNome(usuarioDetails.getNome());
		usuario.setTelefone(usuarioDetails.getTelefone());
		usuario.setEmail(usuarioDetails.getEmail());
		usuario.setSenha(usuarioDetails.getSenha());
		usuario.setCategoria(usuarioDetails.getCategoria());
		usuario.setEscola(usuarioDetails.getEscola());
		
		return usuarioRepository.save(usuario);
	}
	
	// delete usuário rest api
	@DeleteMapping("/cadastro-usuario/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
	
}
