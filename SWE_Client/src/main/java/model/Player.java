package model;

public class Player {
	private int positionX, positionY; //current position
	private int wantedX, wantedY; //position the AI wants to move to
	
	public int getPositionX(){
		return positionX;
	}
	public int getPositionY(){
		return positionY;
	}
	
	public int getWantedX(){
		return wantedX;
	}
	public int getWantedY(){
		return wantedY;
	}
	
	public void setPositionCoordinates(int x, int y){
		positionX = x;
		positionY = y;
	}
	public void setWantedCoordinates(int x, int y){
		wantedX = x;
		wantedY = y;
	}
	
	public void setPositionX(int posX){
		positionX = posX;
	}
	public void setPositionY(int posY){
		positionY = posY;
	}
	public void setWantedX(int posX){
		wantedX = posX;
	}
	public void setWantedY(int posY){
		wantedY = posY;
	}
	
}
