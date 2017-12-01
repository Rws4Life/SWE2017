package server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controller{
	
	@RequestMapping(value="/NewPlayer", produces="application/xml", consumes="application/xml")
	public NewPlayerResponse NewPlayer(@RequestBody NewPlayerRequest newPlayerReq) {
		
		NewPlayerResponse banana = new NewPlayerResponse();
		//newPlayerReq.getFirstName();
		banana.setID(10);
		
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
	
}
