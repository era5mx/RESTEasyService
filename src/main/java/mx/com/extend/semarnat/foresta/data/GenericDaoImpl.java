package mx.com.extend.semarnat.foresta.data;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import mx.com.extend.semarnat.foresta.util.HibernateUtil;
import mx.com.extend.semarnat.foresta.util.UnableToSaveException;

public class GenericDaoImpl<Entity, K extends Serializable> implements GenericDao<Entity, K> {

	@SuppressWarnings("unchecked")
	public Class<Entity> domainClass = getDomainClass();
	private Session session;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Class getDomainClass() {
		if (domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	/**
	 * Obtiene la sesion
	 * @return
	 */
	private Session getHibernateTemplate() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		return session;
	}

	@Override
	public Entity Buscar(K id) {
		Entity returnValue = getHibernateTemplate().load(domainClass, id);
		session.getTransaction().commit();
		return returnValue;
	}

	@Override
	public void Actualizar(Entity t) throws UnableToSaveException {
		try {
			getHibernateTemplate().update(t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new UnableToSaveException(e);
		}
	}

	@Override
	public void Guardar(Entity t) throws UnableToSaveException {
		try {
			getHibernateTemplate().save(t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new UnableToSaveException(e);
		}
	}

	@Override
	public void Eliminar(Entity t) {
		getHibernateTemplate().delete(t);
		session.getTransaction().commit();
	}

}
