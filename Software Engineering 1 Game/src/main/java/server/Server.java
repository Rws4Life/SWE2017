package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class Server {
	Logger loggerServer = LoggerFactory.getLogger(Server.class);
	private String[][] map;
	public void setMap(String[][] map) {
		this.map = map;
	}
	public String[][] getMap(){
		return map;
	}
	
	private int highestID = 0;
	private int roundCounter = 0;
	
	private int idPlayer1;
	private int positionXPlayer1;
	private int positionYPlayer1;
	private boolean winPlayer1;
	private boolean lossPlayer1;
	
	private int idPlayer2;
	private int positionXPlayer2;
	private int positionYPlayer2;
	private boolean winPlayer2;
	private boolean lossPlayer2;
	
	private int treasurePositionXPlayer1;
	private int treasurePositionYPlayer1;
	private int treasurePositionXPlayer2;
	private int treasurePositionYPlayer2;
	private boolean treasureP1;
	private boolean treasureP2;
	
	private int castlePositionXPlayer1;
	private int castlePositionYPlayer1;
	private int castlePositionXPlayer2;
	private int castlePositionYPlayer2;
	private boolean castleP1;
	private boolean castleP2;
	
	
	
	

	public int getHighestID() {
		return highestID;
	}
	
	public void setHighestID(int highestID) {
		this.highestID = highestID;
	}
	
	public int getRoundCounter() {
		return roundCounter;
	}
	public void setRoundCounter(int roundNumber) {
		roundCounter = roundNumber;
	}
	public void setRoundCounterPlusOne() {
		roundCounter++;
	}
	
	//Player 1
	public int getIdPlayer1() {
		return idPlayer1;
	}
	public void setIdPlayer1(int IdPlayer1) {
		idPlayer1 = IdPlayer1;
	}
	public int getPositionXPlayer1(){
		return positionXPlayer1;
	}
	public int getPositionYPlayer1(){
		return positionYPlayer1;
	}
	public void setPositionPlayer1(int x, int y) {
		positionXPlayer1 = x;
		positionYPlayer1 = y;
	}
	public boolean isWinPlayer1() {
		return winPlayer1;
	}
	public void setWinPlayer1(boolean winPlayer1) {
		this.winPlayer1 = winPlayer1;
	}
	public boolean isLossPlayer1() {
		return lossPlayer1;
	}
	public void setLossPlayer1(boolean lossPlayer1) {
		this.lossPlayer1 = lossPlayer1;
	}
	public boolean isCastleP1() { //IF THE ENEMY CASTLE FOUND SET TRUE
		return castleP1;
	}

	public void setCastleP1(boolean castleP1) {
		this.castleP1 = castleP1;
	}
	public int getCastlePositionXPlayer1() {
		return castlePositionXPlayer1;
	}
	public int getCastlePositionYPlayer1() {
		return castlePositionYPlayer1;
	}
	public void setCastlePositionPlayer1(int castlePositionXPlayer1, int castlePositionYPlayer1) {
		this.castlePositionXPlayer1 = castlePositionXPlayer1;
		this.castlePositionYPlayer1 = castlePositionYPlayer1;
	}

	
	//Player 2 Get and set
	public int getIdPlayer2() {
		return idPlayer2;
	}
	public int getPositionXPlayer2(){
		return positionXPlayer2;
	}
	public int getPositionYPlayer2(){
		return positionYPlayer2;
	}
	public void setIdPlayer2(int IdPlayer2) {
		idPlayer2 = IdPlayer2;
	}
	public void setPositionPlayer2(int x, int y) {
		positionXPlayer2 = x;
		positionYPlayer2 = y;
	}
	public boolean isWinPlayer2() {
		return winPlayer2;
	}
	public void setWinPlayer2(boolean winPlayer2) {
		this.winPlayer2 = winPlayer2;
	}
	public boolean isLossPlayer2() {
		return lossPlayer2;
	}
	public void setLossPlayer2(boolean lossPlayer2) {
		this.lossPlayer2 = lossPlayer2;
	}
	public boolean isCastleP2() {
		return castleP2;
	}
	public void setCastleP2(boolean castleP2) {
		this.castleP2 = castleP2;
	}
	public int getCastlePositionXPlayer2() {
		return castlePositionXPlayer2;
	}
	public int getCastlePositionYPlayer2() {
		return castlePositionYPlayer2;
	}
	public void setCastlePositionPlayer2(int castlePositionXPlayer2, int castlePositionYPlayer2) {
		this.castlePositionXPlayer2 = castlePositionXPlayer2;
		this.castlePositionYPlayer2 = castlePositionYPlayer2;
	}
	
	//Treasure
	public void setTreasurePositionPlayer1(int posX, int posY) {
		this.treasurePositionXPlayer1 = posX;
		this.treasurePositionYPlayer1 = posY;
	}
	public void setTreasurePositionPlayer2(int posX, int posY) {
		this.treasurePositionXPlayer2 = posX;
		this.treasurePositionYPlayer2 = posY;
	}
	
	public int getTreasurePositionXPlayer1() {
		return treasurePositionXPlayer1;
	}
	public void setTreasurePositionXPlayer1(int treasurePositionXPlayer1) {
		this.treasurePositionXPlayer1 = treasurePositionXPlayer1;
	}
	public int getTreasurePositionYPlayer1() {
		return treasurePositionYPlayer1;
	}
	public void setTreasurePositionYPlayer1(int treasurePositionYPlayer1) {
		this.treasurePositionYPlayer1 = treasurePositionYPlayer1;
	}
	public int getTreasurePositionXPlayer2() {
		return treasurePositionXPlayer2;
	}
	public void setTreasurePositionXPlayer2(int treasurePositionXPlayer2) {
		this.treasurePositionXPlayer2 = treasurePositionXPlayer2;
	}
	public int getTreasurePositionYPlayer2() {
		return treasurePositionYPlayer2;
	}
	public void setTreasurePositionYPlayer2(int treasurePositionYPlayer2) {
		this.treasurePositionYPlayer2 = treasurePositionYPlayer2;
	}
	public boolean isTreasureP1() {
		return treasureP1;
	}
	public void setTreasureP1(boolean treasureP1) {
		this.treasureP1 = treasureP1;
	}
	public boolean isTreasureP2() {
		return treasureP2;
	}
	public void setTreasureP2(boolean treasureP2) {
		this.treasureP2 = treasureP2;
	}
	
	//Constructor
	public Server() {

	}	
	
	public String arrayToString(String[][] mapToConvert){
		String stringMap="";
		for(int i = 0; i<mapToConvert.length; i++){
			for(int j = 0; j<mapToConvert[0].length; j++){
				stringMap += mapToConvert[i][j];
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
	
	public boolean checkRules(int id, BusinessRules bs, Server s, int posX, int posY, int wantedX, int wantedY, int turnsLeft) {
		loggerServer.info("Starting to check rules!");
		if(bs.roundCount(getRoundCounter()) == false) return false;
		if(bs.checkPlayerNotOnWaterOrOutsideMap(posX, posY, s.getMap()) == false) return false;
		if(bs.checkFieldMovement(posX, posY, wantedX, wantedY) == false) return false;
		
		if(turnsLeft != 0) {
			if(id==getIdPlayer1() && (posX != getPositionXPlayer1() || posY != getPositionYPlayer1() )) {
				if(bs.checkRoundsUntilMove(posX, posY, wantedX, wantedY, turnsLeft, s.getMap()) == false) return false;
			}
			if(id==getIdPlayer2() && (posX != getPositionXPlayer2() || posY != getPositionYPlayer2())) {
				if(bs.checkRoundsUntilMove(posX, posY, wantedX, wantedY, turnsLeft, s.getMap()) == false) return false;
			}
		}
		if(turnsLeft == 0) {
			loggerServer.info("Setting up player position.");
			if(id==getIdPlayer1()) setPositionPlayer1(posX, posY);
			if(id==getIdPlayer2()) setPositionPlayer2(posX, posY);
		}
	
		loggerServer.info("Rules checked successfully.");
		return true;
	}
	
	public void updatePlayerPosition(int posX, int posY, int oldX, int oldY){
		map[oldX][oldY] = "0" + map[oldX][oldY].substring(1);
		map[posX][posY] = "P" + map[posX][posY].substring(1);
		loggerServer.info("Updated Player position successfully.");
	}
	
	
	public String prepareMap(String mapHalfP1, String mapHalfP2, Server s) {
		loggerServer.info("Starting to prepare map!");
		MapConfiguration m = new MapConfiguration(mapHalfP1, mapHalfP2, s);
		return m.arrayToString(m.getMap());
	}
	
	public void printMap(){
		String mapToPrint = "";		
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				String b = map[i][j];
				mapToPrint = mapToPrint + " " + b;
			}
			mapToPrint = mapToPrint + System.lineSeparator();
						
		}
		System.out.println(mapToPrint);
	}
	
	
}
