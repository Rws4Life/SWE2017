package server;

public class BusinessRules {
	
	public void ifStatementsForIslands() {
		
	}
	
	public boolean checkForIslands(String[][] mapHalf) {
		String[][] cloneHalf = mapHalf;
		for(int twice=1;twice<=2;twice++) {
			//Increment
			for(int i=0; i<4; i++) {
				for(int j=0; j<8; j++) {
					/*if(cloneHalf[0][0].contentEquals("0G") || cloneHalf[0][0].contentEquals("0M")) {
						cloneHalf[0][0] = "0C";
					}*/
					
					if(i==0 && j == 0) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M"))) {
							cloneHalf[i][j] = "00";
						}
						//If [0][0] wasn't viable, go through map until viable one found
						else {
							int i2=0,j2=0;
							for(boolean until00 = false; until00!=true;) {
								if(cloneHalf[i2][j2].contentEquals("0G") || cloneHalf[i2][j2].contentEquals("0M")|| cloneHalf[i2][j2].contentEquals("00")) {
									cloneHalf[i2][j2] = "00";
									until00=true;
								}
								else {
									i2++;
								}
								if(i2==3) {
									i2=0;j2++;
								}
							}
						}
					}
					
					
					/*if(i==0 && j>0 && j<8) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i][j-1].contentEquals("0C")||
								cloneHalf[i+1][j].contentEquals("0C"))) {
							cloneHalf[i][j] = "0C";
						}
					}*/
					
					if(i==0 && j>0 && j<7) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j == 0&&i>0) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j<7 && i<3) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j==7 && i<3) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j<7 && i==3) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j==7 && i==3) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j==7 && i==0) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					/*if(j>0&&i>0 && j<7 && i<4) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("0C")||cloneHalf[i][j-1].contentEquals("0C")||
								cloneHalf[i+1][j].contentEquals("0C")||cloneHalf[i][j+1].contentEquals("0C"))) {
							cloneHalf[i][j] = "0C";
						}
					}*/
				}
			}
			
			//Decrement
			for(int i=3; i>=0; i--) {
				for(int j=7; j>=0; j--) {
					
					if(i==0 && j>0 && j<7) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j == 0&&i>0) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j<7 && i<3) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j==7 && i<3) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j<7 && i==3) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j==7 && i==3) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j==7 && i==0) {
						if((cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					
					
					
				}
			}
		}
		
		/*for(int i=3; i>=0; i--) {
			for(int j=7; j>=0; j--) {
				if(cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M") ||
						cloneHalf[i-1][j].contentEquals("0C")||cloneHalf[i][j-1].contentEquals("0C")||
						cloneHalf[i+1][j].contentEquals("0C")||cloneHalf[i][j+1].contentEquals("0C")) {
					cloneHalf[i][j] = "0C";
				}
			}
		}*/
		//Print Map
		String mapToPrint = "";		
		for(int i = 0; i < cloneHalf.length; i++){
			for(int j = 0; j < cloneHalf[0].length; j++){
				String b = cloneHalf[i][j];
				mapToPrint = mapToPrint + " " + b;
			}
			mapToPrint = mapToPrint + System.lineSeparator();				
		}
		System.out.println(mapToPrint);
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<8; j++) {
				if(cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) return true;
			}
		}
		
		return false;
	}
	
	
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
		
		//Check if Islands were generated
		if(checkForIslands(mapHalf) == true) return false;
		
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
	
	//check that he only goes 1 field
	public boolean checkFieldMovement(int posX, int posY, int wantedX, int wantedY) {
		if((posX-1==wantedX||posX+1==wantedX)&&(posY-1==wantedY||posY+1==wantedY)) return true;
		return false;
	}
	//don't go too fast to next field
	public boolean checkRoundsUntilMove(int posX, int posY, int wantedX, int wantedY, int turnsLeft, String[][] map) {
		if(map[posX][posY].contentEquals("0G")) {
			if(map[wantedX][wantedY].contentEquals("0G") || map[wantedX][wantedY].contentEquals("0W")) {
				if(turnsLeft==2) return true;
				else return false;
			}
			if(map[wantedX][wantedY].contentEquals("0M")) {
				if(turnsLeft==3) return true;
				else return false;
			}
		}
		if(map[posX][posY].contentEquals("0M")) {
			if(map[wantedX][wantedY].contentEquals("0G") || map[wantedX][wantedY].contentEquals("0W")) {
				if(turnsLeft==3) return true;
				else return false;
			}
			if(map[wantedX][wantedY].contentEquals("0M")) {
				if(turnsLeft==4) return true;
				else return false;
			}
		}
		
		
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
