package mx.com.extend.semarnat.foresta.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/message")
public class MessageRestService {

	//http://104.44.129.37/RESTEasyService-0.0.1/rs/message/helloworld
	@GET
	@Path("/helloworld")
	public Response hello() {

		String result = "Hola Mundo!";

		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();

//		return Response.status(200).header("Access-Control-Allow-Origin", "*")
//	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//	            .header("Access-Control-Allow-Credentials", "true")
//	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//	            .header("Access-Control-Max-Age", "1209600")
//	            .entity(result).build();

	}

	//http://104.44.129.37/RESTEasyService-0.0.1/rs/message/hello%20world
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();

//		return Response.status(200).header("Access-Control-Allow-Origin", "*")
//	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//	            .header("Access-Control-Allow-Credentials", "true")
//	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//	            .header("Access-Control-Max-Age", "1209600")
//	            .entity(result).build();

	}

}