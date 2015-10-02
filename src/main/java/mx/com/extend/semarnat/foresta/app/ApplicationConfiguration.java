package mx.com.extend.semarnat.foresta.app;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import mx.com.extend.semarnat.foresta.service.MessageRestService;
import mx.com.extend.semarnat.foresta.service.StudentResource;

/**
 * Clase para registrar manualmente servicios REST.
 * Se debera agregar al Set una instancia de cada servicio a registrar
 */
public class ApplicationConfiguration extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	public ApplicationConfiguration(){

	     singletons.add(new StudentResource());
	     singletons.add(new MessageRestService());

	}

	@Override
	public Set<Class<?>> getClasses() {
	     return empty;
	}
	@Override
	public Set<Object> getSingletons() {
	     return singletons;
	}
}
