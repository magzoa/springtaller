package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Cliente;


@Repository //Gestion de datos
public class ClienteDAO extends DaoGenerico<Cliente> {
	
	
	public ClienteDAO() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager  manager;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
	
	/*public void save(Cliente cliente){
		
		manager.persist(cliente);
		
	}*/
	
	
	
	

}
