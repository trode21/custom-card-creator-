/*package edu.oakland.c3;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;
import java.util.Optional;
@Path("/create?uName = {user}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CardResource {
	private final CardObject card;
	
	public CardResource(CardObject card) {
		this.card = card;
	}
@GET
public CardObject fetch(@QueryParam("count") Optional<String> userName, Optional<CardImage> incomingImage, Optional<CustomCardText> incomingText) {
	if(incomingImage != null) {
		return new CardObject(userName, incomingImage, incomingText);
	}
	throw new WebApplicationException(Status.NOT_FOUND);

	
}
	@POST
	public Response add(@QueryParam("count") Optional<String> userName, Optional<CardImage> incomingImage, Optional<CustomCardText> incomingText) {
		
		 new CardObject(userName,incomingImage,incomingText);
		 return Response.created(UriBuilder.fromResource(CardResource.class).build(card.userName)).build();
		 
		 
	}
	
}
*/