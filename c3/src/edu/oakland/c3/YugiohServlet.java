package edu.oakland.c3;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/yugiohServlet")
public class YugiohServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException
	{
		BufferedImage mainImage = (BufferedImage) request.getAttribute("image");
		
		String sessionID = request.getRequestedSessionId();
		String templateName = "Yugioh";
		String typeName = request.getParameter("type");
		String description = request.getParameter("description");
		String attack = request.getParameter("attack");
		String defense = request.getParameter("defense");
		String species = request.getParameter("species");
		String yugiohName = request.getParameter("name");
		
		BufferedImage template = ImageIO.read(new File("/c3/webapps/resources/"
				+ templateName + "Templates/" +typeName + ".png"));
		int w = template.getHeight();
		int h = template.getWidth();
		
		CardImage cImage = new CardImage(mainImage);
		
		BufferedImage builtImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		Graphics worker = builtImage.getGraphics();
		int x = 0;
		int y = 0;
		worker.drawImage(cImage.resizeImage(360, 360, cImage.getImage()), 46, 80, null);
		worker.drawString(species, 701,748);
		worker.drawString(defense, 1061,860);
		worker.drawString(attack, 994,860);
		worker.drawString(description, 694,770);
		worker.drawString(yugiohName, 691,247);
		worker.drawLine(683, 844, 1125, 844);

		ImageIO.write(builtImage, "PNG", new File("/c3/localCards/", yugiohName+sessionID));
		OutputStream output = response.getOutputStream();
		ImageIO.write(builtImage, "png", output);
		output.close();
	}
	
	
	/*public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException
	{
		String sessionID = request.getRequestedSessionId();
		String yugiohName = request.getParameter("name");
		
		PrintWriter writer = response.getWriter();
		String htmlResponse = "<html> <img src = /c3/localCards/" + yugiohName + sessionID + ".png></html>";
		writer.println(htmlResponse);
	}
	*/	
	
}
