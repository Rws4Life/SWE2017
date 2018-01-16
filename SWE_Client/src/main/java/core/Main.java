package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import controller.Network;
import controller.PersonData;
import model.ArtificialIntelligence;
import model.MapCheck;
import xmlobj.CreateNewMapResponse;
import xmlobj.NewPlayerRequest;
import xmlobj.NewPlayerResponse;
import xmlobj.UpdateResponse;

public class Main {

	public static void main(String[] args) {
		Network n = new Network();
		
		Logger logger = LoggerFactory.getLogger(MapCheck.class);
		
		
		System.out.println("Welcome to the game!");
		
		PersonData pd = new PersonData();
		pd.personData();
		
		
		
		
		NewPlayerResponse newP = new NewPlayerResponse();
		int count = 0;
		int maxTries = 3;
		boolean trial = true;
		while(trial) {
		    try {
		    	newP = n.createNewPlayer(pd.getFirstName(), pd.getFamName(), pd.getMatriculation());
		    	logger.info("Message sent to server successfully.");
		        trial=false;
		    } catch (Exception e) {
		        logger.error("Player information could not be sent. Retrying.");
		        if (++count == maxTries) throw e;
		        else {
		        	logger.error("No more tries left!");
		        	trial=false;
		        }
		    }
		}
		
		ArtificialIntelligence ai = new ArtificialIntelligence();
	
		try {
			if(ai.getMap() != null) {
				logger.info("Map ready. Sending to server.");
			}
		}catch(NullPointerException e) {
			logger.error("There was no map half to send!");
			ai.setBackUpMap();
		}
		 
		CreateNewMapResponse newM = new CreateNewMapResponse();
		trial = true;
		while(trial) {
		    try {
		    	newM = n.createNewMap(newP.getID(),ai.arrayToString(ai.getMap())); //using ID from newPlayer class because that way AI can't fool with the ID and impersonate the other person
		        ai.setMap(ai.stringToArray(newM.getFullMap()));
		    	trial=false;
		    } catch (Exception e) {
		        logger.error("Player information could not be sent. Retrying.");
		        
			    
		        if (++count == maxTries) throw e;
		        else trial=false;
		    }
		}
		
		
		UpdateResponse upd = new UpdateResponse();
		boolean gameOngoing = true;
		boolean firstRound = true;
		while(gameOngoing) {
			try {
				//new move by AI
				
				
				
				upd = n.update(newP.getID(), ai.getPlayerPositionX(), ai.getPlayerPositionY(), ai.getWantedPositionX(), ai.getWantedPositionY(), ai.getTurnsLeft());
				if (firstRound) {
					ai.setEnemyCPosX(upd.getEnemyPositionX());
					ai.setEnemyCPosY(upd.getEnemyPositionY());
					firstRound=false;			
				}
								
				if(upd.isWin()) {
					System.out.println("Congratulations! You won the game!");
					gameOngoing = false;
				}
				
				if(upd.isLoss()) {
					System.out.println("Sadly, you lost the game!");
					gameOngoing = false;
				}
				ai.setPlayerPosition(upd.getPlayerPositionX(), upd.getPlayerPositionY(), ai.getPlayerPositionX(), ai.getPlayerPositionY());
				ai.setPlayerPositionX(upd.getPlayerPositionX());
				ai.setPlayerPositionY(upd.getPlayerPositionY());
				ai.setEnemyPositionX(upd.getEnemyPositionX());
				ai.setEnemyPositionY(upd.getEnemyPositionY());
				ai.setFoundTreasure(upd.isTreasure());				
				
				ai.printMap(ai.getMap());
				
			}catch(Exception e){
				
			}
		}
		//find island and remember island position
		//water field next to grass/mountain turn to grass
		//check again -> if still island, change
		
	}
	
	
	
	

}
