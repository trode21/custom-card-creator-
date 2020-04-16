package edu.oakland.c3;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/pokeServlet")
public class PokemonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// Requests the information the user enters into the web site to be used in the
		// creation of the image file.
		BufferedImage mainImage = (BufferedImage) request.getAttribute("image");
		String sessionID = request.getRequestedSessionId();
		String templateName = "Pokemon";
		String typeName = request.getParameter("type");
		String description = request.getParameter("description");
		String weakness = request.getParameter("weakness");
		String resistance = request.getParameter("resist");
		String retreatCost = request.getParameter("retreat");
		String abilityName1 = request.getParameter("abil1");
		String abilityName2 = request.getParameter("abil2");
		String abilityDescription1 = request.getParameter("abilDesc1");
		String abilityDescription2 = request.getParameter("abilDesc2");
		String hitPoints = request.getParameter("HP");
		String pokemonName = request.getParameter("name");

		BufferedImage template = ImageIO
				.read(new File("/c3/webapps/resources/" + templateName + "Templates" + "/" + typeName + ".png"));
		int w = template.getHeight();
		int h = template.getWidth();

		CardImage cImage = new CardImage(mainImage);
		// Draws all the above parameters onto the built image.
		BufferedImage builtImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics worker = builtImage.getGraphics();
		worker.drawImage(cImage.resizeImage(434, 286, cImage.getImage()), 46, 80, null);
		worker.drawString(pokemonName, 120, 38);
		worker.drawString(hitPoints, 404, 37);
		worker.drawString(abilityName1, 49, 395);
		worker.drawString(abilityDescription1, 49, 419);
		worker.drawString(abilityName2, 49, 477);
		worker.drawString(abilityDescription2, 49, 504);
		worker.drawString(retreatCost, 49, 649);
		worker.drawString(resistance, 139, 604);
		worker.drawString(weakness, 49, 604);
		worker.drawString(description, 279, 634);
		worker.drawLine(49, 456, 525, 738);

		// Writes a file to our database which allows for the user to then pull using a
		// download button front end to then keep their image.
		ImageIO.write(builtImage, "png", new File("/c3/localCards/",
				pokemonName+sessionID+".png"));
		OutputStream output = response.getOutputStream();
		ImageIO.write(builtImage, "png", output);
		output.close();
	}

	/*
	 * public void doPost(HttpServletRequest request, HttpServletResponse response)
	 * throws IOException, ServletException { String sessionID =
	 * request.getRequestedSessionId(); String pokemonName =
	 * request.getParameter("name");
	 * 
	 * PrintWriter writer = response.getWriter(); String htmlResponse =
	 * "<html> <img src = /c3/localCards/" + pokemonName + sessionID +
	 * ".png></html>"; writer.println(htmlResponse); }
	 */

}