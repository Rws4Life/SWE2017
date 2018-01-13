package xmlobj;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class UpdateRequest {
	int ID, playerPositionX, playerPositionY, wantedPositionX, wantedPositionY, turnsLeft;

	public int getID() {
		return ID;
	}
	@XmlElement
	public void setID(int iD) {
		ID = iD;
	}

	public int getPlayerPositionX() {
		return playerPositionX;
	}
	@XmlElement
	public void setPlayerPositionX(int playerPositionX) {
		this.playerPositionX = playerPositionX;
	}

	public int getPlayerPositionY() {
		return playerPositionY;
	}
	@XmlElement
	public void setPlayerPositionY(int playerPositionY) {
		this.playerPositionY = playerPositionY;
	}

	public int getWantedPositionX() {
		return wantedPositionX;
	}
	@XmlElement
	public void setWantedPositionX(int wantedPositionX) {
		this.wantedPositionX = wantedPositionX;
	}

	public int getWantedPositionY() {
		return wantedPositionY;
	}
	@XmlElement
	public void setWantedPositionY(int wantedPositionY) {
		this.wantedPositionY = wantedPositionY;
	}

	public int getTurnsLeft() {
		return turnsLeft;
	}
	@XmlElement
	public void setTurnsLeft(int turnsLeft) {
		this.turnsLeft = turnsLeft;
	}
	
	
}
