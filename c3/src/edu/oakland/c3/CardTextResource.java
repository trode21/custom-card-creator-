/*package edu.oakland.c3;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import java.util.Optional;

@Path("/create")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CardTextResource {
	private CustomCardText cct;
	public CardTextResource(CustomCardText cct) {
		this.cct = cct;
	}
	@GET
	public CustomCardText fetch(@QueryParam("username") Optional<String> username, CustomCardText in) {
		if(in != null) {
			cct = in;
			return cct;
		}
		throw new WebApplicationException(Status.NOT_FOUND);
	}
}
*/