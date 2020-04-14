package edu.oakland.c3;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/yugiohServlet")
public class YugiohFactory extends HttpServlet{
	
	public void buildImage(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException
	{
		BufferedImage mainImage = (BufferedImage) request.getAttribute("image");
		
		String templateName = "Yugioh";
		String typeName = request.getParameter("type");
		String description = request.getParameter("description");
		String attack = request.getParameter("attack");
		String defense = request.getParameter("defense");
		String species = request.getParameter("species");
		String yugiohName = request.getParameter("name");
		
		BufferedImage template = ImageIO.read(new File("/custom_card_creator/src/main/webapp/resources/"
				+ templateName + "Templates/" +typeName + ".png"));
		int w = template.getHeight();
		int h = template.getWidth();
		
		CardImage cImage = new CardImage(mainImage);
		
		BufferedImage builtImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		Graphics worker = builtImage.getGraphics();
		int x = 0;
		int y = 0;
		worker.drawImage(cImage.resizeImage(360, 360, cImage.getImage()), 46, 80, null);
		worker.drawString(species, x,y);
		worker.drawString(defense, x,y);
		worker.drawString(attack, x,y);
		worker.drawString(description, x,y);
		worker.drawString(yugiohName, x,y);
		worker.drawLine(x, y, x, y);
		
		
		
		ImageIO.write(builtImage, "PNG", new File("/custom_card_creator/src/main/java/custom_card_creator/localCards/", "builtYugioh.png"));
	}
}
