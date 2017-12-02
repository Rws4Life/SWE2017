package server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controller{
	Server s = new Server();
	private int playerNumber = 1;
	private String mapHalfP1;
	private String mapHalfP2;
	private int idP1, idP2;
	
	@RequestMapping(value="/NewPlayer", produces="application/xml", consumes="application/xml")
	public NewPlayerResponse NewPlayer(@RequestBody NewPlayerRequest newPlayerReq) {
		
		NewPlayerResponse banana = new NewPlayerResponse();
		//newPlayerReq.getFirstName();
		int playerID = s.getHighestID()+1;
		s.setHighestID(playerID);
		if(playerNumber == 1) {
			s.setIdPlayer1(playerID);
			idP1=playerID;
			playerNumber++;
		}
		else if(playerNumber == 2) {
			s.setIdPlayer2(playerID);
			idP2=playerID;
			playerNumber++;
		}
		
		banana.setID(playerID);
		
		return banana;
	}
	
	@RequestMapping(value="/MapCreation", produces="application/xml", consumes="application/xml")
	public CreateNewMapResponse NewMap(@RequestBody CreateNewMapRequest newMapReq) {
		boolean waitingP1=true;
		CreateNewMapResponse banana = new CreateNewMapResponse();
		if(newMapReq.getID()==idP1) {
			setMapHalfP1(newMapReq.getMapHalf());
			while(waitingP1!=false) {
				try {
					banana.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			banana.setFullMap(s.prepareMap(mapHalfP1, mapHalfP2));
		}
		if(newMapReq.getID()==idP2) {
			setMapHalfP2(newMapReq.getMapHalf());
			waitingP1=false;
			banana.setFullMap(s.prepareMap(mapHalfP1, mapHalfP2));
		}
		
		//System.out.println("Island: " + bs.checkForIslands(mc.stringToArray(newMapReq.getMapHalf())));
		//(newMapReq.getMapHalf());
		
		
		return banana;
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getMapHalfP1() {
		return mapHalfP1;
	}

	public void setMapHalfP1(String mapHalfP1) {
		this.mapHalfP1 = mapHalfP1;
	}

	public String getMapHalfP2() {
		return mapHalfP2;
	}

	public void setMapHalfP2(String mapHalfP2) {
		this.mapHalfP2 = mapHalfP2;
	}

	public int getIdP1() {
		return idP1;
	}

	public void setIdP1(int idP1) {
		this.idP1 = idP1;
	}

	public int getIdP2() {
		return idP2;
	}

	public void setIdP2(int idP2) {
		this.idP2 = idP2;
	}

	@RequestMapping(value="/Update", produces="application/xml", consumes="application/xml") //TODO Update Documentation on name change
	public ConnectionProblemResponse ConnectionProblem(@RequestBody ConnectionProblemRequest problemReq) {
		
		ConnectionProblemResponse banana = new ConnectionProblemResponse();
		BusinessRules bs = new BusinessRules();
		MapConfiguration mc = new MapConfiguration();
		//System.out.println("Island: " + bs.checkForIslands(mc.stringToArray(newMapReq.getMapHalf())));
		//(newMapReq.getMapHalf());
		//banana.setFullMap(fullMap);
		
		return banana;
	}
	
	@RequestMapping(value="/Problem", produces="application/xml", consumes="application/xml") //TODO Create ConnectionProblemRequest in documentation
	public UpdateResponse NewUpdate(@RequestBody UpdateRequest updateReq) {
		
		UpdateResponse banana = new UpdateResponse();
		BusinessRules bs = new BusinessRules();
		MapConfiguration mc = new MapConfiguration();
		//System.out.println("Island: " + bs.checkForIslands(mc.stringToArray(newMapReq.getMapHalf())));
		//(newMapReq.getMapHalf());
		//banana.setFullMap(fullMap);
		
		return banana;
	}
}
