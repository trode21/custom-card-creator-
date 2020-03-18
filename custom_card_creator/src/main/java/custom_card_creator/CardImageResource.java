/*
package custom_card_creator;


import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.awt.image.BufferedImage;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;

@Path("/create?uName={user}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CardImageResource {
	private CardImage image;
	
public CardImageResource(CardImage image) {
	this.image = image;	
	}

@GET
public CardImage fetch(@QueryParam("count") Optional<String> userName, CardImage incoming) {

	if(incoming != null)
		return new CardImage(userName, incoming);
}
	

}//end class
*/