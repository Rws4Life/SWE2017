package client;

public class Map {
	//Field Types: 0G = Grass, 0M = Mountain, 0W = Water, P0 = Player, 0C = Castle, (0T = Treasure)
	//private int[][] map = new int [8][8];
	
	static String[][] map;
		
	public Map(){
		map = new String[8][8];/*{
			  { "0G", "0G", "0W", "0W", "0G", "0G", "0M", "0M" },
			  { "0G", "0G", "0G", "0W", "0W", "0G", "0M", "0W" },
			  { "0G", "0G", "0G", "0M", "0W", "0G", "0M", "0G" },
			  { "0G", "0G", "0G", "0M", "0W", "0W", "0M", "0G" },
			  { "0G", "0M", "0M", "0M", "0C", "0M", "0M", "0G" },
		};*/
	}
	
	public String[][] getMap(){
		return map;
	}
	public void setMap(String[][] newMap){
		map = newMap;
	}
	
	public String getMapTile(int x, int y){
		return map[x][y];
	}
	
	public String getMapTileCoordinates(int x, int y){
		return map[x][y];
	}
	
	
	public void setPlayerPosition(int posX, int posY, int oldX, int oldY){
		map[oldX][oldY] = "0" + map[oldX][oldY].substring(1);
		map[posX][posY] = "P" + map[posX][posY].substring(1);
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
	
	public void printMap(){
		String mapToPrint = "";		
		for(int i = 0; i < map.length; i++){ //X
			for(int j = 0; j < map[0].length; j++){ //Y
				String b = map[i][j];
				mapToPrint = mapToPrint + " " + b;
			}
			mapToPrint = mapToPrint + System.lineSeparator();
						
		}
		System.out.println(mapToPrint);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map test = new Map();
		/*String mapH1= test.arrayToString(test.generateMapHalf());
		String mapH2= test.arrayToString(test.generateMapHalf());
		test.putMapHalvesTogether(mapH1, mapH2);*/
		
		test.printMap();
	}
	
	
}
