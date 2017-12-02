package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import client.ArtificialIntelligence;

@SpringBootApplication
public class Server {
	private int highestID = 0;
	private int roundCounter = 0;
	private int idPlayer1;
	private int positionXPlayer1;
	private int positionYPlayer1;
	private int idPlayer2;
	private int positionXPlayer2;
	private int positionYPlayer2;
	private int treasurePositionXPlayer1;
	private int treasurePositionYPlayer1;
	private int treasurePositionXPlayer2;
	private int treasurePositionYPlayer2;
	//treasurepositionXPlayer1 and treasurepositionYPlayer1
	//treasurepositionXPlayer2 and treasurepositionYPlayer2
	
	
	
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
	public int getIdPlayer1() {
		return idPlayer1;
	}
	public int getPositionXPlayer1(){
		return positionXPlayer1;
	}
	public int getPositionYPlayer1(){
		return positionYPlayer1;
	}
	public void setIdPlayer1(int IdPlayer1) {
		idPlayer1 = IdPlayer1;
	}
	public void setPositionPlayer1(int x, int y) {
		positionXPlayer1 = x;
		positionYPlayer1 = y;
	}
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
		idPlayer1 = IdPlayer2;
	}
	public void setPositionPlayer2(int x, int y) {
		positionXPlayer2 = x;
		positionYPlayer2 = y;
	}
	
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
	
	//Constructor
	public Server() {
		
		
		//setRoundCounter(RoundCounter);
	}
	
	//Manages Business rules and network between clients
	//Puts map halves together
	//checkPosition();
	
	public String[][] generateMapHalf(){ //send to AI
		//parse through array
		//assign a value
		//if i is 0 or
		String[][] mapHalf = new String[][]{
		  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
		  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
		  { "0G", "0W", "0G", "0G", "0W", "0G", "0G", "0M" },
		  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
	};
	/*<?xml version="1.0" encoding="UTF-8"?>
<CreateNewMapRequest>
<ID>1</ID>
 <mapHalf>0G0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M</mapHalf>
</CreateNewMapRequest>*/
		/*for(int i = 0; i<mapHalf[0].length;i++){ //This is 4 on the y axis
			for(int j = 0; j<mapHalf.length;j++){ //This is 8 on the x axis
				
				
				mapHalf[j][i]="0G";
		
			}
		}*/
		
		//Create Castle on row 4 at the first grass tile
		for(boolean check = false; check != true;){
			for(int y = 0; y<8;y++){
				if(mapHalf[3][y].contentEquals("0G")){
						mapHalf[3][y]="0C";
						y=7;
						check=true;
				}
			}
		}
		return mapHalf;
		//map[0][0] = "0G";
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
	//If player on mountain and treasure around it, then show treasure -> send back treasure position
	public String onMountain() {
		/*if(bs.checkIfOnMountain==true) {
			return "Ok.";
		}*/
		return "Ok.";
	}
	public boolean checkRules(int id, BusinessRules bs, MapConfiguration m, int posX, int posY, int wantedX, int wantedY, int turnsLeft) {
		if(bs.roundCount(getRoundCounter()) == false) return false;
		if(bs.checkPlayerNotOnWaterOrOutsideMap(posX, posY, m.getMap()) == false) return false;
		if(bs.checkFieldMovement(posX, posY, wantedX, wantedY) == false) return false;
		
		if(turnsLeft != 0) {
			if(id==getIdPlayer1() && (posX != getPositionXPlayer1() || posY != getPositionYPlayer1() )) {
				if(bs.checkRoundsUntilMove(posX, posY, wantedX, wantedY, turnsLeft, m.getMap()) == false) return false;
			}
			if(id==getIdPlayer2() && (posX != getPositionXPlayer2() || posY != getPositionYPlayer2())) {
				if(bs.checkRoundsUntilMove(posX, posY, wantedX, wantedY, turnsLeft, m.getMap()) == false) return false;
			}
		}
		if(turnsLeft == 0) {
			if(id==getIdPlayer1()) setPositionPlayer1(posX, posY);
			if(id==getIdPlayer2()) setPositionPlayer2(posX, posY);
		}
		
		
		return true;
	}
	
	public String prepareMap(String mapHalfP1, String mapHalfP2) {
		MapConfiguration m = new MapConfiguration(mapHalfP1, mapHalfP2);
		return m.arrayToString(m.getMap());
	}
	
	
public static void main(String[] args){
		
		//Server s = new Server();
		SpringApplication.run(Server.class, args);
		
		
		
		/* //bs.checkMap(mapHalf);
		MapConfiguration m = new MapConfiguration(s.arrayToString(s.generateMapHalf()), s.arrayToString(s.generateMapHalf()));
		
		m.printMap();
		
		System.out.println(bs.checkSpawnOfTreasureAndCastle(m.getMap()));*/
		
		

		
		//Make a method "verifyRules" that verifies rules after each move -> if(bs.roundCounter(rounds)==false){s.bothLose()}
	}
	
	
}
