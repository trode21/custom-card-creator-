package custom_card_creator;

import java.util.*;
import java.awt.image.BufferedImage;



public class CardObject {
ArrayList<String> cText = new ArrayList<>();
ArrayList<BufferedImage> cImage = new ArrayList<>();
String userName;
String text;
ArrayList<String> usrName = new ArrayList<>();

public CardObject(Optional<String> userName, Optional<CardImage> image, Optional<CustomCardText> text) {
	if(image.isPresent()) {
		BufferedImage img = image.get().resizeImage(720, 480, image.get().image);
		this.setImage(img);
	}
	if(userName.isPresent()) {
		this.userName = userName.get().toString();
		this.setUserName(this.userName);
	}
	if(text.isPresent()) {
		this.text = text.get().customText;
		this.addCardTesxt(this.text);
	}
}


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
public void setUserName(String usn) {
	this.usrName.add(usn);
}
public ArrayList<String> getUserName(){
	return this.usrName;
}
}
