package mx.com.extend.semarnat.foresta.util;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * Allow the system to serve xhr level 2 from all cross domain site
 *
 * @author Joel Pearson / based in: Deisss (LGPLv3)' code
 * @version 0.1
 */
@Provider
public class CrossDomainFilter implements ContainerResponseFilter {
    /**
     * Add the cross domain data to the output if needed
     *
     * @param creq The container request (input)
     * @param cres The container request (output)
     * @return The output request with cross domain if needed
     */
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		responseContext.getHeaders().add("Access-Control-Max-Age", "1209600");
	}
}
