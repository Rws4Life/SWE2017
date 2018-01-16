package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import model.MapGenerator;
import xmlobj.CreateNewMapRequest;
import xmlobj.CreateNewMapResponse;
import xmlobj.NewPlayerRequest;
import xmlobj.NewPlayerResponse;
import xmlobj.UpdateRequest;
import xmlobj.UpdateResponse;

public class Network {
	RestTemplate r = new RestTemplate();
	Logger logger = LoggerFactory.getLogger(MapGenerator.class);
	
	public NewPlayerResponse createNewPlayer(String firstName, String secondName, int matrNr) {
		
		
		NewPlayerRequest Object = new NewPlayerRequest();
		
		Object.setFirstName(firstName);
		Object.setSecondName(secondName);
		Object.setMatrikelnummer(matrNr);
		NewPlayerResponse var = new NewPlayerResponse();
		var = r.postForObject("http://localhost:8080/NewPlayer", Object, var.getClass()); //Object is new player request
		logger.info("ID received successfully.");
		return var;
	}
	
	
	public CreateNewMapResponse createNewMap(int ID, String mapHalf) {
		CreateNewMapRequest Object = new CreateNewMapRequest();
		
		Object.setID(ID);
		Object.setMapHalf(mapHalf);
		CreateNewMapResponse var = new CreateNewMapResponse();
		var = r.postForObject("http://localhost:8080/MapCreation", Object, var.getClass());
		logger.info("Map received successfully.");
		return var;
	}
	
	public UpdateResponse update(int ID, int playerPositionX, int playerPositionY, int wantedPositionX, int wantedPositionY, int turnsLeft) {
		UpdateRequest Object = new UpdateRequest();
		//int ID, playerPositionX, playerPositionY, wantedPositionX, wantedPositionY, turnsLeft;
		Object.setID(ID);
		Object.setPlayerPositionX(playerPositionX);
		Object.setPlayerPositionY(playerPositionY);
		Object.setWantedPositionX(wantedPositionX);
		Object.setWantedPositionY(wantedPositionY);
		Object.setTurnsLeft(turnsLeft);
		
		UpdateResponse var = new UpdateResponse();
		var = r.postForObject("http://localhost:8080/Update", Object, var.getClass());
		logger.info("Update received successfully.");
		return var;
	}
	
}
