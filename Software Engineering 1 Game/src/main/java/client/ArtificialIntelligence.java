package client;

public class ArtificialIntelligence {
//Creates Map Half
//Makes next Move
	
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
	
	
	public String[][] moveToField(int currentPositionX, int currentPositionY, Map map){
		//If there is a green field around, it will go for it, unless it has been there before
		
		String posAbove = map.getMapTile(currentPositionX-1, currentPositionY-1);
		String posBelow = map.getMapTile(currentPositionX+1, currentPositionY+1);
		String posLeft = map.getMapTile(currentPositionX, currentPositionY+1);
		String posRight = map.getMapTile(currentPositionX, currentPositionY-1);
		
		String[] placesBefore = new String[100];
		placesBefore[0] = map.getMapTile(currentPositionX, currentPositionY); //make int i put in placesBefore[] and use to see where I was before
		
		
		
		
		
		
		
		
		String[][] pos = new String[1][1];
		return pos;
	}
	
	
}
