package custom_card_creator;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CardObject {
ArrayList<String> cText = new ArrayList<>();
ArrayList<BufferedImage> cImage = new ArrayList<>();

public void addCardTesxt(String text) {
	 this.cText.add(text);
}
public ArrayList<String> getCardText() {
	return this.cText;
}
public void setImage(BufferedImage i) {
	this.cImage.add(i);
}
public ArrayList<BufferedImage> getImage(BufferedImage i) {
	return this.cImage;
}
}
