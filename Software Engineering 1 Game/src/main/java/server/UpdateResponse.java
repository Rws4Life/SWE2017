package server;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class UpdateResponse {
 int playerPositionX, playerPositionY, enemyPositionX, enemyPositionY;
 boolean treasure, loss, win;
 
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
public int getEnemyPositionX() {
	return enemyPositionX;
}
@XmlElement
public void setEnemyPositionX(int enemyPositionX) {
	this.enemyPositionX = enemyPositionX;
}
public int getEnemyPositionY() {
	return enemyPositionY;
}
@XmlElement
public void setEnemyPositionY(int enemyPositionY) {
	this.enemyPositionY = enemyPositionY;
}
public boolean isTreasure() {
	return treasure;
}
@XmlElement
public void setTreasure(boolean treasure) {
	this.treasure = treasure;
}
public boolean isLoss() {
	return loss;
}
@XmlElement
public void setLoss(boolean loss) {
	this.loss = loss;
}
public boolean isWin() {
	return win;
}
@XmlElement
public void setWin(boolean win) {
	this.win = win;
}
}
