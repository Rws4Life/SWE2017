package model;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapCheck {

	Logger logger = LoggerFactory.getLogger(MapCheck.class);
	
	int posXOfIsland;
	int posYOfIsland;
	
	
	
	
	public int[] getIsland(String[][] map) {
		int[] position = new int[2];
		boolean islandfound = false;
		while(!islandfound) {
			
			if(checkForIslands(map)) { //if true
				for(int i=0; i<3;i++) {
					for(int j=0; j<7;j++) {
						if(!cloneHalf[i][j].contentEquals("00")&&!cloneHalf[i][j].contentEquals("0W")) {
							position[0] = posXOfIsland;
							position[1] = posYOfIsland;
							return position;
						}
					}
				}
			}
			else islandfound=true;
		}
		
		
		position[0] = 1337;
		
		return position;
	}
	
	
	public void checkIf() {
		
	}
	String[][] cloneHalf;
	
	public boolean checkForIslands(String[][] mapHalf) {
		logger.info("Checking for islands:");
		cloneHalf = mapHalf;
		for(int twice=1;twice<=2;twice++) {
			//Increment
			for(int i=0; i<4; i++) {
				for(int j=0; j<8; j++) {
					if(i==0 && j == 0) {
						if((!cloneHalf[i][j].contentEquals("0W"))) {
							cloneHalf[i][j] = "00";
						}
						//If [0][0] wasn't viable, go through map until viable one found
						else {
							logger.info("First tile was not converted to 00");
							int i2=i,j2=j;
							for(boolean until00 = false; until00!=true;) {
								if(!cloneHalf[i][j].contentEquals("0W")) {
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
						if((!cloneHalf[i][j].contentEquals("0W") && !cloneHalf[i][j].contentEquals("00")) &&
								(cloneHalf[i][j-1].contentEquals("00")|| cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j == 0&&i>0 && i<3) {
						if((!cloneHalf[i][j].contentEquals("0W") && !cloneHalf[i][j].contentEquals("00")) &&
						(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j<7 && i<3) {
						if((!cloneHalf[i][j].contentEquals("0W") && !cloneHalf[i][j].contentEquals("00")) &&
						(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||cloneHalf[i+1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j==7 && i<3) {
						if((!cloneHalf[i][j].contentEquals("0W") && !cloneHalf[i][j].contentEquals("00")) &&
						(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||cloneHalf[i+1][j].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j<7 && i==3) {
						if((!cloneHalf[i][j].contentEquals("0W") && !cloneHalf[i][j].contentEquals("00")) &&
						(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j>0&&i>0 && j==7 && i==3) {
						if((!cloneHalf[i][j].contentEquals("0W") && !cloneHalf[i][j].contentEquals("00")) &&
						(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j-1].contentEquals("00"))) {
							cloneHalf[i][j] = "00";
						}
					}
					
					if(j==7 && i==0) {
						if((!cloneHalf[i][j].contentEquals("0W") && !cloneHalf[i][j].contentEquals("00")) &&
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
					
					if(j==0&&i>0 && i<3) {
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
					
					if(j==0 && i==3) {
						if((cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) &&
								(cloneHalf[i-1][j].contentEquals("00")||cloneHalf[i][j+1].contentEquals("00"))) {
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
		String mapToPrint = "";		
		mapToPrint = mapToPrint + System.lineSeparator();
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
				if(cloneHalf[i][j].contentEquals("0C") || cloneHalf[i][j].contentEquals("PC") || cloneHalf[i][j].contentEquals("0G") || cloneHalf[i][j].contentEquals("0M")) {
					posXOfIsland = i;
					posYOfIsland = j;
					return true;
				}
			}
		}
		logger.info("No island found.");
		return false;
	}
	
	
	public void checksAfter(String[][] mapHalf, int water, int mountain, int grass) {
		logger.info("Checking Water.");
		checkWater(mapHalf, water);
		if(water<4) checkWater(mapHalf, water);
		logger.info("Checking Mountains.");
		checkMountain(mapHalf, mountain);
		if(mountain<5) checkMountain(mapHalf, mountain);
		logger.info("Checking Grass.");
		checkGrass(mapHalf, grass);
		if(grass<1) checkGrass(mapHalf, grass);
		logger.info("Checks done.");

	}
	public void checkWater(String[][] mapHalf, int water) {
		if(water < 4) {
			int i = randomInt(0, 3);
			int j = randomInt(0, 7);
			if(!mapHalf[i][j].contentEquals("0W") && !mapHalf[i][j].contentEquals("0M")) {
				mapHalf[i][j] = "0W";
				water++;
			}else checkWater(mapHalf, water);
		}
		if(water > 6) {
			int i = randomInt(0, 3);
			int j = randomInt(0, 7);
			if(mapHalf[i][j].contentEquals("0W")) {
				mapHalf[i][j] = "0G";
				water--;
			}else checkWater(mapHalf, water);
		}
	}
	public void checkMountain(String[][] mapHalf, int mountain) {
		if(mountain < 5) {
			int i = randomInt(0, 3);
			int j = randomInt(0, 7);
			if(!mapHalf[i][j].contentEquals("0M")) {
				mapHalf[i][j] = "0M";
				mountain++;
			}else checkMountain(mapHalf, mountain);
		}
	}
	public void checkGrass(String[][] mapHalf, int grass) {
		if(grass < 1) {
			int i = randomInt(0, 3);
			int j = randomInt(0, 7);
			if(!mapHalf[i][j].contentEquals("0G")) {
				mapHalf[i][j] = "0G";
				grass++;
			}else checkGrass(mapHalf, grass);
		}
	}
	
	public int randomInt(int min, int max){
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		return random;
	}
}
