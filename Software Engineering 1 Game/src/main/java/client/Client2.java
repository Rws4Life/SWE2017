package client;

public class Client2 {

	//Create an AI - AI creates map Half
	//Tells AI it is time to move - AI makes a move, starting a counter
	//If AI is already moving, the counter will go down and AI will not make another move
	
	
	
	/**Registration onto Server
	 * First contact the server from the client:
	 * Client asks for input data - Name, matr. number
	 * Client requests to send data to server (loop)
	 * If yes -> NewPlayerRequest(Name, Matr. Number)
	 * Get ID as response and save it
	 */
	
	/**Creating AI and Map
	 * (When first creating Client,) create an AI.
	 * AI creates a map immediately
	 * 
	 * (Client puts spawn point of Player on castle)
	 * BETTER IDEA:
	 * Make map send back info with both player's spawning position
	 * 
	 * Client sends request to server to send map half (Convert Map to String)
	 * if server says yes -> map is being sent -> CreateNewMapRequest(ID, MapHalf)
	 * Server sends full map back, and also spawning positions
	 * AI saves enemy spawning position as a castle
	 */
	
	/**Asking server to send request
	 * Requests to send requests to server:
	 * Client sends request in a loop before sending actual message
	 * Server always answers with bool ready=false
	 * If ready=true, then send actual message
	 */
	
	/**Update Request
	 * After server said yes and the first 3 things have been instanced ->
	 * ->start a loop, ask request, send request
	 * IF turns left from previous move, then don't ask AI for new move, just put counter -1
	 * ELSE Ask AI to prepare next move
	 * Look how many turns are left
	 * Pack move into UpdateRequest(ID, CurrentPosition, NewPosition, TurnsLeft)
	 * 
	 */
	
	private int serverID;
	
	private ArtificialIntelligence AI;
	private Map map;
	private Player player;
	private Player enemy;
	
	private int roundsUntilMove;
	private boolean treasure, win, loss;
	
	public Client2(){
		
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
	
	public void setServerID(int id){
		serverID = id;
	}
	
	public void setAI(ArtificialIntelligence ai){
		AI = ai;
	}
	
	public void setMap(String[][] Map){ //WORK ON THIS TODO
		map.setMap(Map);
	}
	public void setPlayer(int x, int y){
		player.setPositionCoordinates(x, y);
	}
	public void setEnemy(int x, int y){
		enemy.setPositionCoordinates(x, y);
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
}
