package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.ItemPedido;

@Repository
public class ItemPedidoDao extends DaoGenerico<ItemPedido> {
	
	@PersistenceContext
	private EntityManager em;
	
	public ItemPedidoDao() {
		super(ItemPedido.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	

	
	
	

}
