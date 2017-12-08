package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessRules {
	Logger logger = LoggerFactory.getLogger(ControllerTestResponses.class);
	public void ifStatementsForIslands() {
		
	}
	
	public boolean checkForIslands(String[][] mapHalf) {
		logger.info("Checking for islands:");
		String[][] cloneHalf = mapHalf;
		for(int twice=1;twice<=2;twice++) {
			//Increment
			for(int i=0; i<4; i++) {
				for(int j=0; j<8; j++) {
					if(i==0 && j == 0) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M"))) {
							cloneHalf[i][j] = "00";
						}
						//If [0][0] wasn't viable, go through map until viable one found
						else {
							logger.info("First tile was not converted to 00");
							int i2=0,j2=0;
							for(boolean until00 = false; until00!=true;) {
								if(cloneHalf[i2][j2].contentEquals("0C") || cloneHalf[i2][j2].contentEquals("PC") || cloneHalf[i2][j2].contentEquals("0G") || cloneHalf[i2][j2].contentEquals("0M")|| cloneHalf[i2][j2].contentEquals("00")) {
									cloneHalf[i2][j2] = "00";
									logger.info("Position " + i2 + "/" + j2 + " has been converted to 00 successfully.");
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
					
					if(i==0 && j>0 && j<7) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j == 0&&i>0) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j<7 && i<3) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j==7 && i<3) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j<7 && i==3) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j==7 && i==3) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j==7 && i==0) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
				}
			}
			
			//Decrement
			for(int i=3; i>=0; i--) {
				for(int j=7; j>=0; j--) {
					
					if(i==0 && j>0 && j<7) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j == 0&&i>0) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j<7 && i<3) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j==7 && i<3) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i+1][j].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j<7 && i==3) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||
								cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j==7 && i==3) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j==7 && i==0) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					
					
					
				}
			}
		}
		//Print Map into log file
		String mapToPrint = "";		
		for(int i = 0; i < cloneHalf.length; i++){
			for(int j = 0; j < cloneHalf[0].length; j++){
				String b = cloneHalf[i][j];
				mapToPrint = mapToPrint + " " + b;
			}
			mapToPrint = mapToPrint + System.lineSeparator();				
		}
		logger.info(mapToPrint);
		//System.out.println(mapToPrint);
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<8; j++) {
				if(cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) return true;
			}
		}
		logger.info("Island check done.");
		return false;
	}
	
	
	//Set up 3 counters GCount, MCount and WCount - go through String[][] and if position is grass, then GCOunt++, and check that GCount>5
	public boolean checkMapGeneration(String[][] mapHalf){
		int GCount=0; int MCount=0; int WCount=0;
		//Check if map half has correct size
		if(mapHalf.length != 4 || mapHalf[0].length != 8) return false;
		logger.info("Length was correct!");
		
		//Count all Grass, Mountain and Water Fields
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<8; j++) {
				if(mapHalf[i][j].contentEquals("0G")) { GCount++;}
				else if(mapHalf[i][j].contentEquals("0M")) { MCount++;}
				else if(mapHalf[i][j].contentEquals("0W")) { WCount++;}
			}
		}
		logger.info("Grass Fields: " + GCount + " Mountain Fields: " + MCount + " Water Fields: " + WCount);
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
		logger.info(" Water Fields Upper: " + WCountSide);
		WCountSide=0;
		//Lowest Row 8
		for(int i = 0; i<8; i++) {
			if(mapHalf[3][i].contentEquals("0W")) WCountSide++;
			if(WCountSide>3) return false; 
		}
		logger.info(" Water Fields Down: " + WCountSide);
		WCountSide=0;
		//Left Row 4
		for(int i = 0; i<4; i++) {
			if(mapHalf[i][0].contentEquals("0W")) WCountSide++;
			if(WCountSide>1) return false;
		}
		logger.info(" Water Fields Left: " + WCountSide);
		WCountSide=0;
		//Right Row 4
		for(int i = 0; i<4; i++) {
			if(mapHalf[i][7].contentEquals("0W")) WCountSide++;
			if(WCountSide>3) return false;
		}
		logger.info(" Water Fields Right: " + WCountSide);
		WCountSide=0;
		
		//Check if Islands were generated
		if(checkForIslands(mapHalf) == true) return false;
		
		//if all tests passed, true is returned
		return true;
	}

	public boolean roundCount(int rounds) {
		if(rounds>=200) return false;
		logger.info("Currently at round number " + rounds + ". The limit was not reached yet.");
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
				if(map[i][j].contentEquals("0T")) TreasureExists=true;
			}
		}
		if(CastleExists==false||TreasureExists==false) return false;
		logger.info("Treasure and Castle spawned correctly.");
		return true;
	}
	
	//check that he only goes 1 field
	public boolean checkFieldMovement(int posX, int posY, int wantedX, int wantedY) {
		if((posX-1==wantedX||posX+1==wantedX||posX==wantedX)&&(posY-1==wantedY||posY+1==wantedY||posY==wantedY)) return true;
		return false;
	}
	//don't go too fast to next field
	public boolean checkRoundsUntilMove(int posX, int posY, int wantedX, int wantedY, int turnsLeft, String[][] map) {
		if(map[posX][posY].contentEquals("PG")) {
			if(map[wantedX][wantedY].contentEquals("0G") || map[wantedX][wantedY].contentEquals("0W")) {
				if(turnsLeft==2) return true;
				else return false;
			}
			if(map[wantedX][wantedY].contentEquals("0M")) {
				if(turnsLeft==3) return true;
				else return false;
			}
		}
		if(map[posX][posY].contentEquals("PM")) {
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
		if(positionX < 0 || positionX > map.length || positionY < 0 || positionY > map[0].length) return false;
		if(map[positionX][positionY].contentEquals("PW") || map[positionX][positionY].contentEquals("0W")) return false;
		return true;
	}//
	
	public boolean checkIfTouchedTreasure(int posX, int posY, String[][] map, int treasureX, int treasureY) {
		if(posX==treasureX && posY==treasureY) {
			map[posX][posY].replace("T", "G");
			return true;
		}
		return false;
	}
	
	public boolean checkWinningCondition(int posX, int posY, boolean treasureStatus, int enemyCX, int enemyCY) {
		if(treasureStatus==true && posX==enemyCX && posY==enemyCY) {
			return true;
		}
		
		return false;
	}

	public boolean checkIfOnMountain(int positionX, int positionY, String[][] map) { //TODO Fix if on edge of map, exception
		//posx-1 and posY-1; posx-1 and posy; posx-1 and posy+1; posx and posy-1; posx and posy+1; posx+1 and posy-1; posx+1 and posy; posx+1 and posy+1;
		if(map[positionX][positionY].contentEquals("PM") && (map[positionX-1][positionY-1].contentEquals("0T") || map[positionX-1][positionY].contentEquals("0T") ||
			map[positionX-1][positionY+1].contentEquals("0T") || map[positionX][positionY-1].contentEquals("0T") || map[positionX][positionY+1].contentEquals("0T") ||
			map[positionX+1][positionY-1].contentEquals("0T") || map[positionX+1][positionY].contentEquals("0T") || map[positionX+1][positionY+1].contentEquals("0T"))) return true;	
		return false;
	}
}
