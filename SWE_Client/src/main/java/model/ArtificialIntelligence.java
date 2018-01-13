package model;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArtificialIntelligence {
//Creates Map Half
//Makes next Move
	String[][] map;
	MapGenerator mg;
	MapCheck mc;
	Logger logger = LoggerFactory.getLogger(ArtificialIntelligence.class);
	
	
	public ArtificialIntelligence(){
		mg = new MapGenerator();
		mc = new MapCheck();
		mg.generateMapHalf(map, mc);
		//printMap(map);
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
	
	public int randomIntFields(int min, int max, int water, int grass, int mountain){
		int chance;
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		if(water <= 4) {
			chance = randomInt(0, 100);
		}
		else if(mountain <= 5) {
			chance = randomInt(0, 75);
		}
		/*if(grass <= 7) {
			chance = randomInt(0, 50);
		}*/
		else {
			chance = randomInt(0, 100);
		}
		if(chance > 50 && chance <= 75) {
			random = 3;
		}
		if(chance > 75 && chance <= 100) {
			random = 2;
		}
		else {
			random = 1;
		}
		
		return random;
	}
	
	public int randomInt(int min, int max){
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		return random;
	}
	
	
}
