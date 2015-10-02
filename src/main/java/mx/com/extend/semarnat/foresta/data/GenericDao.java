package mx.com.extend.semarnat.foresta.data;

import java.io.Serializable;

import mx.com.extend.semarnat.foresta.util.UnableToSaveException;

public interface GenericDao<Entity, PK extends Serializable> {

	void Guardar(Entity t) throws UnableToSaveException;

	void Actualizar(Entity t) throws UnableToSaveException;

	Entity Buscar(PK id);

	void Eliminar(Entity t);

}
