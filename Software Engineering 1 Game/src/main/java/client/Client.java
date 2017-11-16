package client;

public class Client {
	//Manages AI
	//Manages Map
	//Manages Win/Loss Scenario
	//Manages how many turns are left until movement
	//Manages enemy position
	
	private ArtificialIntelligence AI;
	private int serverID;
	private Map map;
	private Player player;
	private Player enemy;
	private int roundsUntilMove;
	private boolean treasure;
	private boolean win;
	private boolean loss;
	
	public Client(){
	}
	
	public ArtificialIntelligence getAI(){
		return AI;
	}
	public int getServerID(){
		return serverID;
	}
	public Map getMap(){
		return map;
	}
	public Player getPlayer(){
		return player;
	}
	public Player getEnemy(){
		return enemy;
	}
	public int getRoundsUntilMove(){
		return roundsUntilMove;
	}
	public boolean getTreasure(){
		return treasure;
	}
	public boolean getWin(){
		return win;
	}
	public boolean getLoss(){
		return loss;
	}
	
	public void setAI(ArtificialIntelligence ai){
		AI = ai;
	}
	public void setServerID(int id){
		serverID = id;
	}
	public void setMap(){ //WORK ON THIS TODO
		
	}
	public void setPlayer(){
		
	}
	public void setEnemy(){
		
	}
	public void setRoundsUntilMove(int i){
		roundsUntilMove = i;
	}
	public void setTreasure(boolean found){
		treasure = found;
	}
	public void setWin(boolean Win){
		win = Win;
	}
	public void setLoss(boolean Loss){
		loss = Loss;
	}
	
	public void createAIInstance(){
		AI = new ArtificialIntelligence();
		Map mapHalf = new Map();
		mapHalf.setMap(AI.generateMapHalf()); //If row 4 and grass, put castle there
		mapHalf.printMap();
		sendHalfMapToServer(mapHalf.arrayToString(mapHalf.getMap())); //Loop of requests until able to send
	}
	
	public void sendHalfMapToServer(String MapHalf){
		
	}
	
	public void moveOfAI(){
		//player.setWantedCoordinates(AI.moveToField(player.getPositionX(), player.getPositionY()));
	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		Client c = new Client();
		
		c.createAIInstance();
		
		
		
		

	}

}
