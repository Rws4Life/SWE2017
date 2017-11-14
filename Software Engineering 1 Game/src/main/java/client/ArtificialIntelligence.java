package client;

import java.util.concurrent.ThreadLocalRandom;

public class ArtificialIntelligence {
//Creates Map Half
//Makes next Move
	
	private String[] placesBefore = new String[100]; //make int i put in placesBefore[] and use to see where I was before
	private int movedCount=0;
	
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
	
	public int randomInt(int min, int max){
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		return random;
	}
	
	public String moveToField(int currentPositionX, int currentPositionY){
		//If there is a green field around, it will go for it, unless it has been there before
		
		/*int posAboveX = currentPositionX-1;
		int posAboveY = currentPositionY-1;
		String[][] posAbove = new String[currentPositionX-1][currentPositionY-1];
		String[][] posBelow = new String[currentPositionX+1][currentPositionY+1];
		String[][] posLeft = new String[currentPositionX][currentPositionY+1];
		String[][] posRight = new String[currentPositionX][currentPositionY-1];*/
		
		String posAboveXY = String.valueOf(currentPositionX-1) + String.valueOf(currentPositionY-1);
		String posBelowXY = String.valueOf(currentPositionX+1) + String.valueOf(currentPositionY+1);
		String posLeftXY = String.valueOf(currentPositionX) + String.valueOf(currentPositionY+1);
		String posRightXY = String.valueOf(currentPositionX) + String.valueOf(currentPositionY-1);
		
		String goTo = new String();
		
		int choseDirection = randomInt(0, 3);
		if(choseDirection == 0){
			goTo = posAboveXY;
			placesBefore[movedCount] = goTo;
			movedCount++;
		}
		else if(choseDirection == 1){
			goTo = posBelowXY;
			placesBefore[movedCount] = goTo;
			movedCount++;
		}
		else if(choseDirection == 2){
			goTo = posLeftXY;
			placesBefore[movedCount] = goTo;
			movedCount++;
		}
		else if(choseDirection == 3){
			goTo = posRightXY;
			placesBefore[movedCount] = goTo;
			movedCount++;
		}
		
		
		return goTo;
	}
	
	
}
