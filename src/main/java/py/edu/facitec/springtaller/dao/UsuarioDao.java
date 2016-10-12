package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import py.edu.facitec.springtaller.model.Usuario;

@Repository                     //pasando la clase usuario que se convierte en objeto
public class UsuarioDao extends DaoGenerico<Usuario> {
	@PersistenceContext
	private EntityManager em;

	public UsuarioDao() {
		//paso la clase usuario al Dao Generico
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
