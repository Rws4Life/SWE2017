package client;

public class Map {
	//Field Types: 0G = Grass, 0M = Mountain, 0W = Water, P0 = Player, 0C = Castle, (0T = Treasure)
	//private int[][] map = new int [8][8];
	
	static String[][] map;
		
	public Map(){
		map = new String[8][8];/*{
			  { "0G", "0G", "0W", "0W", "0G", "0G", "0M", "0M" },
			  { "0G", "0G", "0G", "0W", "0W", "0G", "0M", "0W" },
			  { "0G", "0G", "0G", "0M", "0W", "0G", "0M", "0G" },
			  { "0G", "0G", "0G", "0M", "0W", "0W", "0M", "0G" },
			  { "0G", "0M", "0M", "0M", "0C", "0M", "0M", "0G" },
		};*/
	}
	
	public void putMapHalvesTogether(String mapHalfOfPlayer1, String mapHalfOfPlayer2){ //Send to Server
		String FullMap[][] = new String[8][8];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				if(mapHalfOfPlayer1.length() > 0){
					String putIntoMap = mapHalfOfPlayer1.substring(0, 2);
					FullMap[i][j] = putIntoMap;
					mapHalfOfPlayer1 = mapHalfOfPlayer1.substring(2);
				}
			}
		}
		for(int i = 4; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				if(mapHalfOfPlayer2.length() > 0){
					String putIntoMap = mapHalfOfPlayer2.substring(0, 2);
					FullMap[i][j] = putIntoMap;
					mapHalfOfPlayer2 = mapHalfOfPlayer2.substring(2);
				}
			}
		}
		map = FullMap;
	}
	
	public String[][] generateMapHalf(){ //send to AI
		//parse through array
		//assign a value
		//if i is 0 or
		String[][] mapHalf = new String[8][4];
		for(int i = 0; i<mapHalf.length;i++){
			for(int j = 0; j<mapHalf[0].length;j++){ //length/2
				
				
				mapHalf[i][j]="0G";
				
				
				
			}
		}
		return mapHalf;
		//map[0][0] = "0G";
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map test = new Map();
		String mapH1= test.arrayToString(test.generateMapHalf());
		String mapH2= test.arrayToString(test.generateMapHalf());
		test.putMapHalvesTogether(mapH1, mapH2);
		
		test.printMap();
	}
	
	
}
