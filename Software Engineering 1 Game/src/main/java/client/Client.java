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
		//map.
	}
	
	public void createAIIntance(){
		ArtificialIntelligence ai = new ArtificialIntelligence();
		Map mapHalf = new Map();
		mapHalf.setMap(ai.generateMapHalf());
		sendHalfMapToServer(mapHalf.arrayToString(mapHalf.getMap()));
	}
	
	public void sendHalfMapToServer(String MapHalf){
		
	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		ArtificialIntelligence ai = new ArtificialIntelligence();
		//TODO make sendMapHalf(ai.generateMapHalf()); directly
		String[][] mapHalf = ai.generateMapHalf();
		
		

	}

}
