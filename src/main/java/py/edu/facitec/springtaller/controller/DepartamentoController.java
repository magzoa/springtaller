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

import py.edu.facitec.springtaller.dao.DepartamentoDao;
import py.edu.facitec.springtaller.model.Departamento;

public class DepartamentoController {
	@Autowired
	private DepartamentoDao departamentoDao;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> registrar(@RequestBody Departamento departamento){
		departamentoDao.guardar(departamento, departamento.getId());
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Departamento>> buscarTodos(){
		List<Departamento> departamentos = departamentoDao.buscarTodos();
		return new ResponseEntity<List<Departamento>>(departamentos, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> buscarPorId(@PathVariable Integer id){
		Departamento departamento = departamentoDao.buscar(id);
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> eliminar(@PathVariable Integer id){
		Departamento departamento = departamentoDao.buscar(id);
		if(departamento==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		departamentoDao.eliminar(departamento);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
