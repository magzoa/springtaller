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

import py.edu.facitec.springtaller.dao.GerenteDao;
import py.edu.facitec.springtaller.model.Gerente;

public class GerenteController {
	@Autowired
	private GerenteDao  gerenteDao;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> registrar(@RequestBody Gerente gerente){
		gerenteDao.guardar(gerente, gerente.getId());
		return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Gerente>> buscarTodos(){
		List<Gerente> gerentes = gerenteDao.buscarTodos();
		return new ResponseEntity<List<Gerente>>(gerentes, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> buscarPorId(@PathVariable Integer id){
		Gerente gerente = gerenteDao.buscar(id);
		return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> eliminar(@PathVariable Integer id){
		Gerente gerente = gerenteDao.buscar(id);
		if (gerente==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		gerenteDao.eliminar(gerente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
