package server;

import java.util.concurrent.ThreadLocalRandom;

public class MapConfiguration { //Create whole map //Random Treasure
	
	String[][] map = new String[8][8];
	
	
	//Constructor
	public MapConfiguration(String mapHalfOfPlayer1, String mapHalfOfPlayer2){
		setMap(stringToArray(putMapHalvesTogether(mapHalfOfPlayer1, mapHalfOfPlayer2)));
		printMap();
		randomTreasure(map);
		System.out.println("Map config done.");
	}
	
	//FINISHED Getter and Setter for Map
	public void setMap(String[][] newMap){
		map = newMap;
		System.out.println("Map set.");
	}
	public String[][] getMap(){
		return map;
	}
	
	//FINISHED Generating Random Treasure for both players
	public void randomTreasure(String[][] map){
		System.out.println("Starting treasure spawn.");
		for(boolean loop=false;loop!=true;){
			int i = randomInt(0,3);
			int j = randomInt(0,7);	
			if(map[i][j].contentEquals("0G")){
				map[i][j] = map[i][j].substring(0, 1);
				map[i][j] = map[i][j] + "T";
				System.out.println("Treasure spawn done.");
				loop=true;
			}

		}
		
		for(boolean loop=false; loop!=true;){
			int i = randomInt(4,7);
			int j = randomInt(0,7);
			if(map[i][j].contentEquals("0G")){
				map[i][j] = map[i][j].substring(0, 1);
				map[i][j] = map[i][j] + "X";
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
		checkMapGeneration(stringToArray(mapHalfOfPlayer1));
		checkMapGeneration(stringToArray(mapHalfOfPlayer2));
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
	
	
	
	//Set up 3 counters GCount, MCount and WCount - go through String[][] and if position is grass, then GCOunt++, and check that GCount>5
	//Will be put in business rules
	private boolean checkMapGeneration(String[][] mapHalf){
		int GCount=0; int MCount=0; int WCount=0;
		
		//Count all Grass, Mountain and Water Fields
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<8; j++) {
				if(mapHalf[i][j].contentEquals("0G")) { GCount++;}
				else if(mapHalf[i][j].contentEquals("0M")) { MCount++;}
				else if(mapHalf[i][j].contentEquals("0W")) { WCount++;}
			}
		}
		System.out.println("Grass Fields: " + GCount + " Mountain Fields: " + MCount + " Water Fields: " + WCount);
		//Check if there are enough of each type of Field
		if(GCount<=5) return false;
		if(MCount<=3) return false;
		if(WCount<=4) return false;
		
		//Check that not more than half of the sides are filled with water fields and less than 3 on long sides
		//Upper Row 8
		int WCountSide=0;
		for(int i = 0; i<8; i++) {
			if(mapHalf[0][i].contentEquals("0W")) WCountSide++;
			if(WCountSide>3) return false;
			
		}
		System.out.println(" Water Fields Upper: " + WCountSide);
		WCountSide=0;
		//Lowest Row 8
		for(int i = 0; i<8; i++) {
			if(mapHalf[3][i].contentEquals("0W")) WCountSide++;
			if(WCountSide>3) return false; 
		}
		System.out.println(" Water Fields Down: " + WCountSide);
		WCountSide=0;
		//Left Row 4
		for(int i = 0; i<4; i++) {
			if(mapHalf[i][0].contentEquals("0W")) WCountSide++;
			if(WCountSide>1) return false;
		}
		System.out.println(" Water Fields Left: " + WCountSide);
		WCountSide=0;
		//Right Row 4
		for(int i = 0; i<4; i++) {
			if(mapHalf[i][7].contentEquals("0W")) WCountSide++;
			if(WCountSide>3) return false;
		}
		System.out.println(" Water Fields Right: " + WCountSide);
		WCountSide=0;
		
		//Check if Islands were generated
		//The only way an island is generated on the 2nd or 3rd row is by having less than 3 water fields on the sides, so the island can only be one field big
		//
		
		
		//if all tests passed, true is returned
		return true;
	}
	
	
}
