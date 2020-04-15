package edu.oakland.c3;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.imageio.ImageIO;

import org.glassfish.hk2.utilities.reflection.Logger;
 

public class ImageFactory {
	/*
	 * @param templatePath passed in the format of "[template]" i.e. "pokemon", "yugioh"
	 * @param typeName passed in the format of "[type]" i.e. "dark", "dragon"
	 */
	public void buildImage(String templateName, String typeName, BufferedImage mainImage) throws IOException {
		//Loads template from src/main/webapp/resources/[Pokemon/Yugioh/Whatever]Templates/[type].png
		BufferedImage template = ImageIO.read(new File("/c3/webapps/resources/"+templateName+"Templates"+"/"+typeName+".png"));
		CardImage cImage = new CardImage (mainImage);
		int w = template.getWidth();
		int h = template.getHeight();
		//Creates a blank image equal in size to the template loaded
		BufferedImage builtImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		Graphics worker = builtImage.getGraphics();
		worker.drawImage(template, 0, 0, null);
		//Draws text onto the image
		worker.drawString(templateName, 0, 0);
		//Overlays the main image onto the template
		if("Pokemon".equals(templateName)) {
			//Explanation: cImage.resizeImage(434, 286, cImage.getImage()) resizes the current image 
			//to whatever we need it to be to fit in the space, which I determined to be 434x286 for Pokemon
			worker.drawImage(cImage.resizeImage(434, 286, cImage.getImage()), 46 , 80 , null);
		}
		if("Yugioh".equals(templateName)) {
			worker.drawImage(cImage.resizeImage(360, 360, cImage.getImage()), 46 , 80 , null);
		}
		if("Magic".equals(templateName)) {
			worker.drawImage(cImage.resizeImage(430, 320, cImage.getImage()), 46 , 80 , null);
		}
		
		/*
		 * MASSIVE NOTE
		 * I DID NOT INCLUDE WRITING THE INCOMING TEXT ONTO THE IMAGE
		 * MAKE SURE TO DO THAT
		 */
		
		//Writes image to that path you see there
		ImageIO.write(builtImage, "PNG", new File("/c3/localCards/", "builtImage.png"));
	}
	public void downloadImage(String source, String target) throws MalformedURLException, IOException, FileNotFoundException {
		InputStream iS = null;
		OutputStream oS = null;
		URL url = new URL(source);
		try {
			
			URLConnection con = url.openConnection();
			
			iS = con.getInputStream();
			oS = new FileOutputStream(target);
			
			int length;
			byte[] buffer = new byte[2048];
			while((length = iS.read(buffer))!= -1) {
				oS.write(buffer, 0, length);
			}
		}catch (Exception e) {
			e.getCause();
		}
		oS.close();
		iS.close();
		
	}
	public void downloadImage2(String source, String target) throws MalformedURLException, IOException, FileNotFoundException {
		URL url = new URL(source);
		try { 
			InputStream iS = new BufferedInputStream(url.openStream());
			OutputStream oS = new BufferedOutputStream(new FileOutputStream(target + File.separator));
		int readByte;
		while ((readByte = iS.read())!=-1) {
			oS.write(readByte);
		}
		oS.close();
		}catch(Exception e) {
			e.getCause();
		}
		
	}
	public void downloadImage3(String source, String target) throws MalformedURLException, IOException, FileNotFoundException {
		URL url = new URL(source);
		ReadableByteChannel channel = Channels.newChannel(url.openStream());
		FileOutputStream output = new FileOutputStream(target);
		output.getChannel().transferFrom(channel, 0	, Long.MAX_VALUE);
		output.close();
	}
}
