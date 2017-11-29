package server;

public class BusinessRules {
	
	//Set up 3 counters GCount, MCount and WCount - go through String[][] and if position is grass, then GCOunt++, and check that GCount>5
	public boolean checkMapGeneration(String[][] mapHalf){
		int GCount=0; int MCount=0; int WCount=0;
		//Check if map half has correct size
		if(mapHalf.length != 4 || mapHalf[0].length != 8) return false;
		System.out.println("Length was correct!");
		
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
		
		//Check if Islands were generated TODO
		//The only way an island is generated on the 2nd or 3rd row is by having less than 3 water fields on the sides, so the island can only be one field big
		//
		
		
		
		
		//if all tests passed, true is returned
		return true;
	}

	public boolean roundCount(int rounds) {
		if(rounds>=200) return false;
		return true;
	}
	
	public boolean checkSpawnOfTreasureAndCastle(String[][] map) {
		boolean TreasureExists = false, CastleExists = false;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j<8; j++) {
				if(map[i][j].contentEquals("0C")||map[i][j].contentEquals("PC")) CastleExists=true;
				if(map[i][j].contentEquals("0T")) TreasureExists=true;
			}
		}
		if(CastleExists==false||TreasureExists==false) return false;
		TreasureExists=false; CastleExists=false;
		for(int i = 4; i < 8; i++) {
			for(int j = 0; j<8; j++) {
				if(map[i][j].contentEquals("0C")||map[i][j].contentEquals("PC")) CastleExists=true;
				if(map[i][j].contentEquals("0X")) TreasureExists=true; //TODO, change to 0T after treasure implemented correctly
			}
		}
		if(CastleExists==false||TreasureExists==false) return false;
		
		return true;
	}
	
	public boolean checkPlayerNotOnWaterOrOutsideMap(int positionX, int positionY, String[][] map) {
		if(positionX < 0 || positionX > map[0].length || positionY < 0 || positionY > map.length) return false; //TODO: Check later if length values checked correctly
		if(map[positionX][positionY].contentEquals("PW")) return false;
		return true;
	}

	public boolean checkIfOnMountain(int positionX, int positionY, String[][] map) {
		if(map[positionX][positionY].contentEquals("PM")) return true;	
		return false;
	}
}
