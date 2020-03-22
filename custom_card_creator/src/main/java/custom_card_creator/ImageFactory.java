package custom_card_creator;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFactory {
	/*
	 * @param templatePath passed in the format of "[template]" i.e. "pokemon", "yugioh"
	 * @param typeName passed in the format of "[type]" i.e. "dark", "dragon"
	 */
	public void buildImage(String templateName, String typeName, BufferedImage mainImage) throws IOException {
		//Loads template from src/main/webapp/resources/[Pokemon/Yugioh/Whatever]Templates/[type].png
		BufferedImage template = ImageIO.read(new File("/custom_card_creator/src/main/webapp/resources/"+templateName+"Templates"+"/"+typeName+".png"));
		CardImage cImage = new CardImage (mainImage);
		int w = template.getWidth();
		int h = template.getHeight();
		//Creates a blank image equal in size to the template loaded
		BufferedImage builtImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		Graphics worker = builtImage.getGraphics();
		worker.drawImage(template, 0, 0, null);
		//Overlays the main image onto the template
		if("Pokemon".equals(templateName)) {
			//Explanation: cImage.resizeImage(434, 286, cImage.getImage()) resizes the current image 
			//to whatever we need it to be to fit in the space, which I determined to be 434x286 for Pokemon
			worker.drawImage(cImage.resizeImage(434, 286, cImage.getImage()), 46, 80, null);
		}
		
		/*
		 * MASSIVE NOTE
		 * I DID NOT INCLUDE WRITING THE INCOMING TEXT ONTO THE IMAGE
		 * MAKE SURE TO DO THAT
		 */
		
		//Writes image to that path you see there
		ImageIO.write(builtImage, "PNG", new File("/custom_card_creator/src/main/java/custom_card_creator/localCards/", "builtImage.png"));
	}
}
