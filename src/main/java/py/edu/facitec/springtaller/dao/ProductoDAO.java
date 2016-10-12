package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Producto;

@Repository
public class ProductoDAO extends DaoGenerico<Producto> {

	@PersistenceContext
	private EntityManager manager;
	
	
	public ProductoDAO() {
		super(Producto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
	
	

}
