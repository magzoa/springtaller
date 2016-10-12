package py.edu.facitec.springtaller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.facitec.springtaller.dao.UsuarioDao;
import py.edu.facitec.springtaller.model.Usuario;

public class UsuarioController {
	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){
		usuarioDao.guardar(usuario, usuario.getLogin());
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> buscarTodos(){
		List<Usuario> usuarios = usuarioDao.buscarTodos();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarPorLogin(@PathVariable String login){
		Usuario usuario = usuarioDao.buscar(login);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> eliminar(@PathVariable String login){
		Usuario usuario = usuarioDao.buscar(login);
		if (usuario==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		usuarioDao.eliminar(usuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
