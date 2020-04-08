package custom_card_creator;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class YugiohFactory {
	
	public void buildImage(String templateName,String typeName, BufferedImage mainImage)
				throws IOException
	{
		BufferedImage template = ImageIO.read(new File("/custom_card_creator/src/main/webapp/resources/"
				+ templateName + "Templates/" +typeName + ".png"));
		int w = template.getHeight();
		int h = template.getWidth();
		
		CardImage cImage = new CardImage(mainImage);
		
		CustomCardText cText = new CustomCardText(x,y,typeName, "Arial");
		
		BufferedImage builtImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		Graphics worker = builtImage.getGraphics();
		worker.drawImage(template, 0, 0, null);
		worker.drawString(templateName, 0,0);
		
		if ("Yugioh".equals(templateName)) {
			worker.drawImage(cImage.resizeImage(360, 360, cImage.getImage()), 46, 80, null);
		}
		ImageIO.write(builtImage, "PNG", new File("/custom_card_creator/src/main/java/custom_card_creator/localCards/", "builtYugioh.png"));
	}
}
