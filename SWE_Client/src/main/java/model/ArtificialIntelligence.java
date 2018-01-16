package model;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArtificialIntelligence {
//Creates Map Half
//Makes next Move
	int playerPositionX, playerPositionY, enemyPositionX, enemyPositionY, enemyCPosX, enemyCPosY;
	int wantedPositionX, wantedPositionY, turnsLeft;
	boolean foundTreasure;
	
	
	
	public boolean isFoundTreasure() {
		return foundTreasure;
	}

	public void setFoundTreasure(boolean foundTreasure) {
		this.foundTreasure = foundTreasure;
	}

	public int getPlayerPositionX() {
		return playerPositionX;
	}

	public void setPlayerPositionX(int playerPositionX) {
		this.playerPositionX = playerPositionX;
	}

	public int getPlayerPositionY() {
		return playerPositionY;
	}

	public void setPlayerPositionY(int playerPositionY) {
		this.playerPositionY = playerPositionY;
	}

	public int getEnemyPositionX() {
		return enemyPositionX;
	}

	public void setEnemyPositionX(int enemyPositionX) {
		this.enemyPositionX = enemyPositionX;
	}

	public int getEnemyPositionY() {
		return enemyPositionY;
	}

	public void setEnemyPositionY(int enemyPositionY) {
		this.enemyPositionY = enemyPositionY;
	}

	public int getEnemyCPosX() {
		return enemyCPosX;
	}

	public void setEnemyCPosX(int enemyCPosX) {
		this.enemyCPosX = enemyCPosX;
	}

	public int getEnemyCPosY() {
		return enemyCPosY;
	}

	public void setEnemyCPosY(int enemyCPosY) {
		this.enemyCPosY = enemyCPosY;
	}

	public int getWantedPositionX() {
		return wantedPositionX;
	}

	public void setWantedPositionX(int wantedPositionX) {
		this.wantedPositionX = wantedPositionX;
	}

	public int getWantedPositionY() {
		return wantedPositionY;
	}

	public void setWantedPositionY(int wantedPositionY) {
		this.wantedPositionY = wantedPositionY;
	}

	public int getTurnsLeft() {
		return turnsLeft;
	}

	public void setTurnsLeft(int turnsLeft) {
		this.turnsLeft = turnsLeft;
	}

	
	
	
	
	String[][] map;
	public String[][] getMap() {
		return map;
	}

	public void setMap(String[][] map) {
		this.map = map;
	}
	
	public void setBackUpMap() {
		this.map = new String[][]{
			  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0M", "0W", "0W", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
		};
	}
	
	public String getMapTile(int x, int y){
		return map[x][y];
	}
	
	public String getMapTileCoordinates(int x, int y){
		return map[x][y];
	}
	
	
	public void setPlayerPosition(int posX, int posY, int oldX, int oldY){
		map[oldX][oldY] = "0" + map[oldX][oldY].substring(1);
		map[posX][posY] = "P" + map[posX][posY].substring(1);
	}
	
	

	MapGenerator mg;
	MapCheck mc;
	Logger logger = LoggerFactory.getLogger(ArtificialIntelligence.class);
	
	
	public ArtificialIntelligence(){
		mg = new MapGenerator();
		mc = new MapCheck();
		mg.generateMapHalf(map, mc);
		//printMap(map);
	}
	
	
	public void newMove() {
		
		
		
		
		
		
	}
	
	
	
	public String printMap(String[][] map){
		String mapPrint = "";	
		mapPrint = mapPrint + System.lineSeparator();
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				String b = map[i][j];
				mapPrint = mapPrint + " " + b;
			}
			mapPrint = mapPrint + System.lineSeparator();
						
		}
		return mapPrint;
	}
	
	public int randomIntFields(int min, int max, int water, int grass, int mountain){
		int chance;
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		if(water <= 4) {
			chance = randomInt(0, 100);
		}
		else if(mountain <= 5) {
			chance = randomInt(0, 75);
		}
		/*if(grass <= 7) {
			chance = randomInt(0, 50);
		}*/
		else {
			chance = randomInt(0, 100);
		}
		if(chance > 50 && chance <= 75) {
			random = 3;
		}
		if(chance > 75 && chance <= 100) {
			random = 2;
		}
		else {
			random = 1;
		}
		
		return random;
	}
	
	public int randomInt(int min, int max){
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		return random;
	}
	

	
	public String arrayToString(String[][] mapToConvert){
		String stringMap="";
		for(int i = 0; i<mapToConvert.length; i++){
			for(int j = 0; j<mapToConvert[0].length; j++){
				stringMap = stringMap + mapToConvert[i][j];
			}
		}
		return stringMap;
	}

	public String[][] stringToArray(String mapToConvert){
		String[][] arrayMap = new String[8][8];
		
		for(int i = 0; i<arrayMap.length; i++){
			for(int j = 0; j<arrayMap[0].length; j++){
				if(mapToConvert.isEmpty() != true){
					arrayMap[i][j] = mapToConvert.substring(0, 2);
					mapToConvert = mapToConvert.substring(2);
				}
			}
		}
		
		return arrayMap;
	}
}
