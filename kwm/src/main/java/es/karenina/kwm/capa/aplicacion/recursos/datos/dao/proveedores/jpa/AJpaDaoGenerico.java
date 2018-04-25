package es.karenina.kwm.capa.aplicacion.recursos.datos.dao.proveedores.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IDao;
import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IEntidad;
import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IEntidadPk;
import es.karenina.kwm.capa.aplicacion.resources.excepciones.datos.ExcepcionDatos;

/**
 * 
 * Clase genérica para la implementaciónn del acceso a datos mediante JPA.
 * 
 * @param <J>
 * @param <K>
 * @param <L>
 */
public abstract class AJpaDaoGenerico <J extends IEntidadPk, L extends IEntidad<J>>  implements IDao<J,L> {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public L findByPk(final J pk, Class<L> value) throws ExcepcionDatos {
		return entityManager.find(value, pk);
	}

	@Override
	public List<L> list(Class<L> value)  throws ExcepcionDatos{
		return entityManager.createQuery("from " + value.getName()).getResultList();
	}

	@Override
	public void create(final L entity) throws ExcepcionDatos {
		entityManager.persist(entity);
	}

  @Override	
	public void update(final L entity) throws ExcepcionDatos {
		entityManager.merge(entity);
	}

  @Override
	public void deleteByPk(final J pk, Class<L> value)  throws ExcepcionDatos{
		L entity = findByPk(pk, value);
		entityManager.remove(entity);
	}
}