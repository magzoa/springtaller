package py.edu.facitec.springtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.springtaller.dao.ClienteDAO;
import py.edu.facitec.springtaller.model.Cliente;

//gestiona transasiones
@Transactional
@Controller
@RestController 
@RequestMapping("/cliente")
public class ClienteController {
	
	//injecta una dependencia
	@Autowired
	private ClienteDAO clienteDao;
					//responder a peticiones POST
	@RequestMapping (method=RequestMethod.POST)
	              //save: vienen los datos del formulario y se pasan a objeto
	public String save (@RequestBody Cliente cliente){
		clienteDao.guardar(cliente,cliente.getId());
		System.out.println("Registrando el cliente"+cliente);
		
		        //crea la pagina ok.jsp
		return "/clientes/ok";
	}
	
	@RequestMapping(value="/formulario",method=RequestMethod.GET) 
	public String formulario(){
		return "/clientes/formulario";
	}
	
	
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista(){
											//crear el archivo lista
											//para visualizar los datos en jsp
		ModelAndView model=new ModelAndView("/clientes/lista");
		
		//Agregamos la lista de clientes al objeto que contendra la vista
		model.addObject("clientes", clienteDao.buscarTodos());
		
		return model;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
