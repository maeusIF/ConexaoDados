package com.dw2.conexaopostgres.ConexaoDados;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")

public class UsuarioController {
	@Autowired
	private UsuarioRepositorio repositorio;

	@PostMapping(path = "/add")
	public @ResponseBody String novoUsuario(@RequestParam(name = "nomeb", required = true) String nomeb,
			@RequestParam(name = "marca", required = false) String marca,
			@RequestParam(name = "tamanho", required = false) String tamanho,
			@RequestParam(name = "mtb_road", required = false) String mtb_road,
			@RequestParam(name = "tipo", required = false) String tipo) {

		Usuario user = new Usuario();
		user.setNomeb(nomeb);
		user.setMarca(marca);
		user.setTamanho(tamanho);
		user.setMtb_road(mtb_road);
		user.setTipo(tipo);

		repositorio.save(user);
		return "Saved";
	}

	@PostMapping(path = "/adduser")
	public @ResponseBody String novoUsuario2(@RequestBody Usuario newUser) {
		repositorio.save(newUser);
		return "usuario salvo com sucesso";

	}

	@GetMapping(path = "/locate_user/{id}")
	public @ResponseBody Optional<Usuario> retornaUser2(@PathVariable(required = true, name = "id") long id) {
		return repositorio.findById(id);
	}


	@DeleteMapping(path = "/delete_user/{id}")
	public @ResponseBody String deleteUser(@PathVariable(required = true, name = "id") long id) {
		Optional<Usuario> user = repositorio.findById(id);
		if (user.isPresent()) {
			repositorio.delete(user.get());
			return "usuario deleteado";

		}
		return "usuario n encontrado";

	}

	@PutMapping(path = "/user/{id}")
	public @ResponseBody ResponseEntity<Usuario> alteraUser(@PathVariable(required = true, name = "id") long id,
			@RequestBody Usuario user) {
		Optional<Usuario> u = repositorio.findById(id);
		if (u.isPresent()){
			u.get().setNomeb(user.getNomeb());
			u.get().setMarca(user.getMarca());
			u.get().setTamanho(user.getTamanho());
			u.get().setMtb_road(user.getMtb_road());
			u.get().setTipo(user.getTipo());
			return ResponseEntity.ok(repositorio.save(u.get()));
		}
		return ResponseEntity.status(404).build();
		

	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Usuario> retornaTodos() {
		// This returns a JSON or XML with the users
		return repositorio.findAll();
	}

	@GetMapping(path = "/user")
	public @ResponseBody Optional<Usuario> retornaTodos(@RequestParam String id) {
		// This returns a JSON or XML with the users
		return repositorio.findById(Long.parseLong(id));

	}
}
