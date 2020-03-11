//*Author: Alexander Muszynski

package custom_card_creator;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Graphics;

//This class in intended to recieve and store an image from the user for the card. If the image does not use the correct parameters it also crops the pictures so they may still
//fit the space provided.
public class cardImage {
	BufferedImage image = null;
	URL url = null;
	String input;
	File file = null;
	JFileChooser chooser = new JFileChooser();
	BufferedImageOp op;
	int y;
	int x;
	
	public void readURLImage(String usrInput) //This method reads a URL that is directed to an image. It then pulls and stores it.
	{
		this.input = usrInput;
		try {	
			url = new URL(input);		
			image = ImageIO.read(url);
			
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	public BufferedImage readLocalImage() //This method opens the file system and allows for a user to select a JPG or PNG file. It then stores the file and resizes it.
	{
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images" ,"JPG","PNG");
		chooser.setFileFilter(filter);
		int returnVal = this.chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
		}
		this.file = this.chooser.getSelectedFile();
		try {
			this.image = ImageIO.read(this.file);
		}catch(IOException e){
			e.printStackTrace();
		}
		BufferedImage img1;
		cardImage ic1 = new cardImage();
		img1 = ic1.resizeImage(1024, 1024, this.image);
		return img1;
	}
	public BufferedImage resizeImage(int w, int h, BufferedImage image) // The resizing method used in the local image method to resize the image.
	{
		BufferedImage rs = image;
		BufferedImage cpy = new BufferedImage(rs.getWidth(),rs.getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g = cpy.createGraphics();
		g.drawImage(rs, 0, 0,null);
		image = this.image;
		return cpy;
	}
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getYCoordinates() {
		return this.y;
	}
	public int getXCoordinates() {
		return this.x;
	}
}