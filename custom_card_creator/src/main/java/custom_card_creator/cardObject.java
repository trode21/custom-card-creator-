package custom_card_creator;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class cardObject {
ArrayList<String> cText = new ArrayList<>();
ArrayList<Integer> textXcord = new ArrayList<>();
ArrayList<Integer> textYcord = new ArrayList<>();
ArrayList<BufferedImage> cImage = new ArrayList<>();

public void addCardTesxt(String text) {
	 this.cText.add(text);
}
public ArrayList<String> getCardText() {
	return this.cText;
}
public void getXcord (int x) {
	this.textXcord.add(x);
}
public ArrayList<Integer> getXcord(){
	return this.textXcord;
}
public void setYcord (int y) {
	this.textYcord.add(y);
}
public ArrayList<Integer> getYcord(){
	return this.textYcord;
}

public void setImage(BufferedImage i) {
	this.cImage.add(i);
}
public ArrayList<BufferedImage> getImage(BufferedImage i) {
	return this.cImage;
}
}
