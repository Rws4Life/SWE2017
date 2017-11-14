package server;

import client.ArtificialIntelligence;

public class Server {
	//Manages Business rules and network between clients
	//Puts map halves together
	//checkPosition();
	
	public String[][] generateMapHalf(){ //DELETE FROM HERE
		//parse through array
		//assign a value
		//if i is 0 or
		String[][] mapHalf = new String[8][4];
		for(int i = 0; i<mapHalf.length;i++){
			for(int j = 0; j<mapHalf[0].length;j++){ //length/2
				
				
				mapHalf[i][j]="0G";
		
			}
		}
		mapHalf[0][1] = "0G";
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
	
	public static void main(String[] args) {
		
		Server s = new Server();
		MapConfiguration m = new MapConfiguration(s.arrayToString(s.generateMapHalf()), s.arrayToString(s.generateMapHalf()));
		
		m.printMap();

	}
	
	
}
