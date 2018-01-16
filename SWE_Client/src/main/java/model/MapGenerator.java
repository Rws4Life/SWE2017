package model;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapGenerator {

	Logger logger = LoggerFactory.getLogger(MapGenerator.class);
	
	public String[][] generateMapHalf(String[][] map, MapCheck mc){ //send to AI
 
		String[][] mapHalf = new String[4][8];
		int grass=0, water=0, mountain=0;
		
		
		
		for(int i = 0; i<mapHalf[0].length;i++){ //This is 4 on the y axis
			for(int j = 0; j<mapHalf.length;j++){ //This is 8 on the x axis
				
				//mc.checkIf();
				int rand = randomInt(1, 3);
				switch(rand) {
				case 1: mapHalf[j][i]="0G"; grass++; break;
				case 2: mapHalf[j][i]="0W"; water++; break;
				case 3: mapHalf[j][i]="0M"; mountain++; break;
				}
				
		
			}
		}
		
		
		
		mc.checksAfter(mapHalf, water, mountain, grass);
		try {
			if(water<4 || mountain<3 || grass<5) {
				String s = "Not enough field types!";
				Exception e = new Exception();
				e.equals(s);
				throw e;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
			int[] position = mc.getIsland(mapHalf);
			if(position[0]!=1337) {
				if(mc.checkForIslands(mapHalf)){
					//check corners
					if(position[0]==0&&position[1]==0 && (map[position[0]+1][position[1]].contentEquals("0W")
							 || map[position[0]][position[1]+1].contentEquals("0W"))) {
						map[position[0]][position[1]+1] = "0G";
					}
					if(position[0]==0&&position[1]==7 && (map[position[0]+1][position[1]].contentEquals("0W")
							 || map[position[0]][position[1]-1].contentEquals("0W"))) {
						map[position[0]][position[1]-1] = "0G";
					}
					if(position[0]==3&&position[1]==0 && (map[position[0]-1][position[1]].contentEquals("0W")
							 || map[position[0]][position[1]+1].contentEquals("0W"))) {
						map[position[0]][position[1]+1] = "0G";
					}
					if(position[0]==3&&position[1]==7 && (map[position[0]-1][position[1]].contentEquals("0W")
							 || map[position[0]][position[1]-1].contentEquals("0W"))) {
						map[position[0]][position[1]-1] = "0G";
					}
					//check sides
					
					if(position[0]>0&&position[0]<3&&position[1]==0 && (map[position[0]-1][position[1]].contentEquals("0W")
							 || map[position[0]][position[1]+1].contentEquals("0W") || map[position[0]+1][position[1]].contentEquals("0W"))) {
						map[position[0]][position[1]+1] = "0G";
					}
					if(position[0]>0&&position[0]<3&&position[1]==7 && (map[position[0]-1][position[1]].contentEquals("0W")
							 || map[position[0]][position[1]-1].contentEquals("0W") || map[position[0]+1][position[1]].contentEquals("0W"))) {
						map[position[0]][position[1]-1] = "0G";
					}
					
					
					
					//check middle
					
					if(position[0]>0&&position[0]<3&&position[1]>0&&position[1]<7) {
						if(map[position[0]][position[1]-1].contentEquals("0W")) {
							map[position[0]][position[1]-1] = "0G";
						}
						else if(map[position[0]-1][position[1]].contentEquals("0W")) {
							map[position[0]-1][position[1]] = "0G";
						}
						else if(map[position[0]][position[1]+1].contentEquals("0W")) {
							map[position[0]][position[1]+1] = "0G";
						}
						else if(map[position[0]+1][position[1]].contentEquals("0W")) {
							map[position[0]+1][position[1]] = "0G";
						}
					}
					
					water--;
				}
		
			}
		//If still islands -> make water, delete island
		if(mc.checkForIslands(mapHalf)==true) {
			
		}
		
		if(mc.checkWaterOnSides(map)) {
			map = new String[][]{
				  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
				  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
				  { "0G", "0W", "0M", "0W", "0W", "0G", "0G", "0M" },
				  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
			};
			return map;
		}
		
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
			
		map = mapHalf;
		logger.info(printMap(map));
		return mapHalf;
		
		//map[0][0] = "0G";
	}
	
	
	public String printMap(String[][] map){
		String mapPrint = "";	
		mapPrint = mapPrint + System.lineSeparator();
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				String b = map[i][j];
				mapPrint = mapPrint + " " + b;
			}
			mapPrint = mapPrint + System.lineSeparator();
						
		}
		return mapPrint;
	}
	
	public int randomInt(int min, int max){
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		return random;
	}
	
}
