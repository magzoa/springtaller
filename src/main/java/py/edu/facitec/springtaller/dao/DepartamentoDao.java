package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Departamento;

@Repository
public class DepartamentoDao extends DaoGenerico<Departamento> {
	@PersistenceContext
	private EntityManager em;

	public DepartamentoDao() {
		super(Departamento.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
