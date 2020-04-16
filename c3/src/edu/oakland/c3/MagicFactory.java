package edu.oakland.c3;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/magicServlet")
public class MagicFactory extends HttpServlet {
    public void buildImage(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    	//parameters from httprequest
    	String sessionID = request.getRequestedSessionId();
        String templateName = "magic", colorName = request.getParameter("color");
        BufferedImage mainImage = (BufferedImage) request.getAttribute("image");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String quote = request.getParameter("quote");
        String cost = request.getParameter("cost");
        //gathering template from parameters
        BufferedImage template = ImageIO.read(new File("/c3/webapps/resources/"
                    +templateName+"Templates"+"/"+colorName+".png"));
        int w = template.getHeight();
        int h = template.getWidth();
        //setting cardimage from mainImage
        CardImage cImage = new CardImage(mainImage);
        //creating bufferedimage to edit
        BufferedImage builtImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        //drawing images and text over
        Graphics worker = builtImage.getGraphics();
        worker.drawImage(template, 0, 0, null);
        worker.drawImage(cImage.resizeImage(430 , 320, cImage.getImage()), 46, 80, null);
        //writing to specific location on the server
        ImageIO.write(builtImage, "PNG", new File("/c3/localCards/", name+sessionID+".png"));
        
        PrintWriter writer = response.getWriter();
		String htmlResponse = "<html> <img src = /c3/localCards/" + name + sessionID + " .png></html>";
		writer.println(htmlResponse);
    }
}