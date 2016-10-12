package py.edu.facitec.springtaller.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.springtaller.dao.PedidoDAO;
import py.edu.facitec.springtaller.model.Pedido;

@RestController
@Transactional
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoDAO pedidoDao;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> registrar(@RequestBody Pedido pedido){
		pedidoDao.guardar(pedido, pedido.getId());
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pedido>> buscarTodos(){
		List<Pedido> pedidos = pedidoDao.buscarTodos();
		return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id){
		Pedido pedidoBuscado = pedidoDao.buscar(id);
		return new ResponseEntity<Pedido>(pedidoBuscado, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> eliminar(@PathVariable Integer id){
		Pedido pedidoAEliminar = pedidoDao.buscar(id);
		if (pedidoAEliminar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		pedidoDao.eliminar(pedidoAEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
