package server;

import client.ArtificialIntelligence;

public class Server {
	//Manages Business rules and network between clients
	//Puts map halves together
	//checkPosition();
	
	public String[][] generateMapHalf(){ //send to AI
		//parse through array
		//assign a value
		//if i is 0 or
		String[][] mapHalf = new String[][]{
		  { "0G", "0G", "0W", "0W", "0G", "0G", "0M", "0M" },
		  { "0G", "0G", "0G", "0W", "0W", "0G", "0M", "0W" },
		  { "0G", "0G", "0G", "0M", "0W", "0G", "0M", "0G" },
		  { "0G", "0G", "0G", "0M", "0W", "0W", "0M", "0G" },
	};
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
	
	
	
	
}
