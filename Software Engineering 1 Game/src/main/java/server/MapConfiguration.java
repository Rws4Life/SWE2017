package server;

import java.util.concurrent.ThreadLocalRandom;

public class MapConfiguration { //Create whole map //Random Treasure
	
	String[][] map = new String[8][8];
	
	
	public MapConfiguration() {
		
	}
	
	//Constructor
	public MapConfiguration(String mapHalfOfPlayer1, String mapHalfOfPlayer2, Server s){
		BusinessRules bs = new BusinessRules();
		boolean player1Check = bs.checkMapGeneration(stringToArrayHalf(mapHalfOfPlayer1));
		boolean player2Check = bs.checkMapGeneration(stringToArrayHalf(mapHalfOfPlayer2));
		System.out.println("Map genration Player1: " + player1Check);
		System.out.println("Map genration Player2: " + player2Check);
		if(player1Check == true && player2Check == true) {
			setCastlePositions(stringToArrayHalf(mapHalfOfPlayer1), stringToArrayHalf(mapHalfOfPlayer2), s);
			setMap(stringToArray(putMapHalvesTogether(mapHalfOfPlayer1, mapHalfOfPlayer2)));
			printMap();
			randomTreasure(map, s);
			System.out.println("Map config done.");
		}
		else if(player1Check == false && player2Check == true) {
			//Send loss to player 1
		}
		else if(player1Check == true && player2Check == false) {
			//Send loss to player 2
		}
		else if(player1Check == false && player2Check == false) {
			//Send loss to player 1 and 2
		}
	}
	
	public void setCastlePositions(String[][] mapHalfOfPlayer1, String[][] mapHalfOfPlayer2, Server s) {
		for(int i=0; i<mapHalfOfPlayer1.length;i++) {
			for(int j=0; j<mapHalfOfPlayer1[0].length;j++) {
				if(mapHalfOfPlayer1[i][j].contentEquals("0C")) {
					s.setCastlePositionPlayer1(i, j);
				}
			}
		}
		
		for(int i=0; i<mapHalfOfPlayer2.length;i++) {
			for(int j=0; j<mapHalfOfPlayer2[0].length;j++) {
				if(mapHalfOfPlayer2[i][j].contentEquals("0C")) {
					s.setCastlePositionPlayer2(i, j);
				}
			}
		}
		
	}
	
	//FINISHED Getter and Setter for Map
	public void setMap(String[][] newMap){
		map = newMap;
		System.out.println("Map set.");
	}
	public String[][] getMap(){
		return map;
	}
	
	//Generating Random Treasure for both players
	public void randomTreasure(String[][] map, Server s){
		System.out.println("Starting treasure spawn.");
		for(boolean loop=false;loop!=true;){
			int i = randomInt(0,3);
			int j = randomInt(0,7);	
			if(map[i][j].contentEquals("0G")){
				map[i][j] = map[i][j].substring(0, 1);
				map[i][j] = map[i][j] + "T";
				s.setTreasurePositionPlayer1(i, j);
				System.out.println("Treasure spawn done.");
				loop=true;
			}

		}
		
		for(boolean loop=false; loop!=true;){
			int i = randomInt(4,7);
			int j = randomInt(0,7);
			if(map[i][j].contentEquals("0G")){
				map[i][j] = map[i][j].substring(0, 1);
				map[i][j] = map[i][j] + "T";
				s.setTreasurePositionPlayer2(i, j);
				loop=true;
			}
		}
	}
	
	//FINISHED Create Random Integer
	public int randomInt(int min, int max){
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		return random;
	}
	
	public String putMapHalvesTogether(String mapHalfOfPlayer1, String mapHalfOfPlayer2){ //Send to Server
		String fullMap[][] = new String[8][8];
		//checkMapGeneration(stringToArray(mapHalfOfPlayer1));
		//checkMapGeneration(stringToArray(mapHalfOfPlayer2));
		for(int i = 0; i < fullMap.length; i++){
			for(int j = 0; j < fullMap[0].length; j++){
				if(mapHalfOfPlayer1.length() > 0){
					String putIntoMap = mapHalfOfPlayer1.substring(0, 2);
					fullMap[i][j] = putIntoMap;
					mapHalfOfPlayer1 = mapHalfOfPlayer1.substring(2);
					
				}
			}
		}
		setSpawnPosition(true, fullMap);
		for(int i = 4; i < fullMap.length; i++){
			for(int j = 0; j < fullMap[0].length; j++){
				if(mapHalfOfPlayer2.length() > 0){
					String putIntoMap = mapHalfOfPlayer2.substring(0, 2);
					fullMap[i][j] = putIntoMap;
					mapHalfOfPlayer2 = mapHalfOfPlayer2.substring(2);
					
				}
			}
		}
		setSpawnPosition(false, fullMap);
		return arrayToString(fullMap);
	}
	
	public void setSpawnPosition(boolean person, String[][] map){
		if(person == true){ //first player
			for(int i = 0; i<8; i++){
				for(int j = 0; j<4; j++){
					if(map[j][i].contentEquals("0C")){
						map[j][i] = "P" + map[j][i].substring(1);
						j=4;i=8;
					}			
				}
			}
		}
		
		else if(person == false){ //second player
			for(int i = 0; i<8; i++){
				for(int j = 4; j<8; j++){
					if(map[j][i].contentEquals("0C")){
						map[j][i] = "P" + map[j][i].substring(1);
						j=8;i=8;
					}
				}
			}
		}
		
		else{
			System.out.println("Error! Could not set player spawn.");
		}
		
		System.out.println("Spawn done.");
		
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
	public String[][] stringToArrayHalf(String mapHalfToConvert){
		String[][] arrayMap = new String[4][8];
		
		for(int i = 0; i<arrayMap.length; i++){
			for(int j = 0; j<arrayMap[0].length; j++){
				if(mapHalfToConvert.isEmpty() != true){
					arrayMap[i][j] = mapHalfToConvert.substring(0, 2);
					mapHalfToConvert = mapHalfToConvert.substring(2);
				}
			}
		}
		
		return arrayMap;
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
