package server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controller{
	Server s = new Server();
	private int playerNumber = 1;
	
	@RequestMapping(value="/NewPlayer", produces="application/xml", consumes="application/xml")
	public NewPlayerResponse NewPlayer(@RequestBody NewPlayerRequest newPlayerReq) {
		
		NewPlayerResponse banana = new NewPlayerResponse();
		//newPlayerReq.getFirstName();
		int playerID = s.getHighestID()+1;
		s.setHighestID(playerID);
		if(playerNumber == 1) {
			s.setIdPlayer1(playerID);
			playerNumber++;
		}
		else if(playerNumber == 2) {
			s.setIdPlayer2(playerID);
			playerNumber++;
		}
		
		banana.setID(playerID);
		
		return banana;
	}
	
	@RequestMapping(value="/MapCreation", produces="application/xml", consumes="application/xml")
	public CreateNewMapResponse NewMap(@RequestBody CreateNewMapRequest newMapReq) {
		
		CreateNewMapResponse banana = new CreateNewMapResponse();
		BusinessRules bs = new BusinessRules();
		MapConfiguration mc = new MapConfiguration();
		System.out.println("Island: " + bs.checkForIslands(mc.stringToArray(newMapReq.getMapHalf())));
		//(newMapReq.getMapHalf());
		//banana.setFullMap(fullMap);
		
		return banana;
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
