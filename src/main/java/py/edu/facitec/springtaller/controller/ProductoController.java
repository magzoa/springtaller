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
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.springtaller.dao.ProductoDAO;
import py.edu.facitec.springtaller.model.Producto;

@RestController
@Transactional
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoDAO productoDAO;
	
											//anotacion que permite cargar los datos
											//al objeto producto
	//registra un producto
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> registrar(@RequestBody Producto producto){
		
		productoDAO.guardar(producto, producto.getId());
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	//Obtiene la lista de productos
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> buscarTodos(){
		
		//obtemos la lista de productos
		List<Producto> productos= productoDAO.buscarTodos();
		
		return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
	}
	//Buscar un producto por Id
	@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
											//asigna el valor a la variable id	
	public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id){
		
		Producto productoBuscado=productoDAO.buscar(id);
	
		
		return new ResponseEntity<Producto>(productoBuscado,HttpStatus.OK);
	}
	
	//Metodo para eliminar
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Producto> eliminar(@PathVariable Integer id){
		
		Producto productoAEliminar=productoDAO.buscar(id);
		
		if(productoAEliminar==null){
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		productoDAO.eliminar(productoAEliminar);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping("/form")
	public ModelAndView formulario(){
		
		
		return new ModelAndView("/productos/form");
	}
	
	
	
	
	
}
