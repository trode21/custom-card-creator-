package edu.oakland.c3;

//Creator :   Cody Asher


public class CustomCardText {
	
		//variables for the cords of the text in relation to the card. (i believe its specifically upper left corner?)
		int xCord;
		int yCord;
	
		//variable to hold string
		String customText;
	
		//variable to hold font
	    String font;
		
	//CustomCardText constructor
	public CustomCardText(int x, int y, String userText, String fName) {
		xCord = x;
		yCord = y;
		customText = userText;
		font = fName;
	}
	
	//set method for user text
	public void setCustomCardText(String userText) {
		customText = userText;
	}
	
	//set method for xCord
	public void setTextXCord(int x) {
		xCord = x;
	}
	
	//set method for yCord
	public void setTextYCord(int y) {
		yCord = y;
	}
	
	//set method for font
	public void setTextFont(String fname) {
		font = fname;
	}
	
	//get method for card text 
	public String getCustomCardText() {
		return customText;
	}
	
	//get method for xCord value 
	public int getTextXCord() {
		return xCord;
	}
	
	//get method for yCord value
	public int getTextYCord() {
		return yCord;
		
	}
	
	//get method for font
	public String getFontText(){
		return font;
	}
}
