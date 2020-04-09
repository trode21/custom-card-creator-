package custom_card_creator;

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

@WebServlet("magicServlet")
public class MagicFactory extends HttpServlet {
    public void buildImage(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String templateName = "magic", colorName = request.getParameter("color");
        BufferedImage mainImage = (BufferedImage) request.getAttribute("image");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String quote = request.getParameter("quote");
        String cost = request.getParameter("cost");


        BufferedImage template = ImageIO.read(new File("/custom_card_creator/src/main/webapp/resources/"
                    +templateName+"Templates"+"/"+colorName+".png"));
        int w = template.getHeight();
        int h = template.getWidth();

        CardImage cImage = new CardImage(mainImage);
        BufferedImage builtImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics worker = builtImage.getGraphics();
        worker.drawImage(template, 0, 0, null);
        worker.drawImage(cImage.resizeImage(430 , 320, cImage.getImage()), 46, 80, null);

        ImageIO.write(builtImage, "PNG", new File("/custom_card_creator/src/main/java/custom_card_creator/localCards/", "builtMagic.png"));
    }
}