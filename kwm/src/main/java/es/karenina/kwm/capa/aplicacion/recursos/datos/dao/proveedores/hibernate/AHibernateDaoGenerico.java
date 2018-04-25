package es.karenina.kwm.capa.aplicacion.recursos.datos.dao.proveedores.hibernate;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IDao;
import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IEntidad;
import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IEntidadPk;


/**
 * Se elimina la implemenación original, porque Hibernate es una implementación
 * de JPA y debería compartir interfaz con todas las implementaciones JPA.
 *
 * @param <J>
 * @param <K>
 * @param <T>
 */
public abstract class AHibernateDaoGenerico<J extends IEntidadPk, L extends IEntidad<J>>
		implements IDao<J, L> {

	@Autowired
	SessionFactory sessionFactory;

  @Override
	public final L findByPk(final J pk, Class<L> value) {
		return (L) getCurrentSession().get(value, pk);
	}

  @Override
	public final List<L> list(Class<L> value) {
		return (List<L>) getCurrentSession().createQuery("from " + value.getName()).list();
	}

  @Override
	public final void create(final L newEntity) {
		getCurrentSession().persist(newEntity);
	}

  @Override
	public final void update(final L persistent) {
		getCurrentSession().merge(persistent);
	}

  @Override
	public void deleteByPk(final J pk, Class<L> value) {
		L entity = findByPk(pk, value);
		getCurrentSession().delete(entity);
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}