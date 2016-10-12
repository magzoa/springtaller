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

import py.edu.facitec.springtaller.dao.ItemPedidoDao;
import py.edu.facitec.springtaller.model.ItemPedido;

public class ItemPedidoController {
	@Autowired
	private ItemPedidoDao itemPedidoDao;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> registrar(@RequestBody ItemPedido itemPedido){
		itemPedidoDao.guardar(itemPedido, itemPedido.getId());
		return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemPedido>> buscarTodos(){
		List<ItemPedido> itemPedidos = itemPedidoDao.buscarTodos();
		return new ResponseEntity<List<ItemPedido>>(itemPedidos, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Integer id){
		ItemPedido itemPedido = itemPedidoDao.buscar(id);
		return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> eliminar(@PathVariable Integer id){
		ItemPedido itemPedido = itemPedidoDao.buscar(id);
		if (itemPedido==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		itemPedidoDao.eliminar(itemPedido);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
