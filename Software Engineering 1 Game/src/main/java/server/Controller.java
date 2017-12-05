package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controller{
	
	Server s = new Server();
	BusinessRules bs = new BusinessRules();
	MapConfiguration mc = new MapConfiguration();
	private int playerNumber = 1;
	private String mapHalfP1;
	private String mapHalfP2;
	private int idP1, idP2;
	
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
	
	//TODO Getter and Setter
	boolean waitingP1=true;
	boolean sentMapP1=false;
	@RequestMapping(value="/MapCreation", produces="application/xml", consumes="application/xml")
	public CreateNewMapResponse NewMap(@RequestBody CreateNewMapRequest newMapReq) {
		if(newMapReq.getID()==idP1) {
			sentMapP1=true;
		}
		/*else if(newMapReq.getID()==idP2) {
			sentMapP1=false;
		} //UNLESS IT HAS BEEN SENT TODO*/
		
		CreateNewMapResponse banana = new CreateNewMapResponse();
		
		if(sentMapP1==true) {
			if(newMapReq.getID()==idP1) {
				setMapHalfP1(newMapReq.getMapHalf());
				while(waitingP1!=false) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				banana.setFullMap(mc.arrayToString(mc.getMap()));
				
			}
			if(newMapReq.getID()==idP2) {
				setMapHalfP2(newMapReq.getMapHalf());
				waitingP1=false;
				banana.setFullMap(s.prepareMap(mapHalfP1, mapHalfP2, s));
				
			}
		}
		if(sentMapP1==false) {
			if(newMapReq.getID()==idP2) {
				setMapHalfP1(newMapReq.getMapHalf());
				while(waitingP1!=false) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				banana.setFullMap(mc.arrayToString(mc.getMap()));
				
			}
			if(newMapReq.getID()==idP1) {
				setMapHalfP2(newMapReq.getMapHalf());
				waitingP1=false;
				banana.setFullMap(s.prepareMap(mapHalfP1, mapHalfP2, s));
			}
		}
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<8; j++) {
				if(s.stringToArray(banana.getFullMap())[i][j].contentEquals("0C")) s.setPositionPlayer1(i, j);
			}
		}
		for(int i=4; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(s.stringToArray(banana.getFullMap())[i][j].contentEquals("0C")) s.setPositionPlayer2(i, j);
			}
		}
		return banana;
	}
	//System.out.println("Island: " + bs.checkForIslands(mc.stringToArray(newMapReq.getMapHalf())));
			//(newMapReq.getMapHalf());
	

	@RequestMapping(value="/Update", produces="application/xml", consumes="application/xml") //TODO Update Documentation on name change
	public UpdateResponse NewUpdate(@RequestBody  UpdateRequest updateReq) {
		UpdateResponse banana = new UpdateResponse();
		s.setRoundCounterPlusOne();
		s.setPositionPlayer2(6, 6);
		if(updateReq.getID()==s.getIdPlayer1()) {
			s.printMap();
			System.out.println(s.getMap().length);
			
			s.updatePlayerPosition(updateReq.getPlayerPositionX(), updateReq.getPlayerPositionY(), s.getPositionXPlayer1(), s.getPositionYPlayer1(), s.getMap());
		}
		if(updateReq.getID()==s.getIdPlayer2()) {
			s.updatePlayerPosition(updateReq.getPlayerPositionX(), updateReq.getPlayerPositionY(), s.getPositionXPlayer2(), s.getPositionYPlayer2(), s.getMap());
		}
		
		if(s.checkRules(updateReq.getID(), bs, s, updateReq.getPlayerPositionX(), updateReq.getPlayerPositionY(), updateReq.getWantedPositionX(), updateReq.getWantedPositionY(), updateReq.getTurnsLeft()) == false) {
			banana.setLoss(true);
			if(updateReq.getID()==s.getIdPlayer1()) {
				s.setLossPlayer1(true);
			}
			if(updateReq.getID()==s.getIdPlayer2()) {
				s.setLossPlayer2(true);
			}
		}
			 //if position is good, rounds until movement is good, not on water
		
		/* int playerPositionX, playerPositionY, enemyPositionX, enemyPositionY;
 boolean treasure, loss, win;*/
		if(updateReq.getID()==s.getIdPlayer1()) {
			if(banana.isLoss() != true) {
				banana.setPlayerPosition(s.getPositionXPlayer1(), s.getPositionYPlayer1());
				banana.setEnemyPosition(s.getPositionXPlayer2(), s.getPositionYPlayer2());
				
				if(bs.checkIfOnMountain(updateReq.getPlayerPositionX(), updateReq.getPlayerPositionY(), s.getMap()) == true) {
					banana.setTreasurePosition(s.getTreasurePositionXPlayer1(), s.getTreasurePositionYPlayer1());
				}
				
				if(bs.checkIfTouchedTreasure(updateReq.getPlayerPositionX(), updateReq.getPlayerPositionY(), s.getMap(), s.getTreasurePositionXPlayer1(), s.getTreasurePositionYPlayer1()) == true) {
					s.setTreasureP1(true);
					banana.setTreasure(true);
				}
				
				if(bs.checkWinningCondition(updateReq.getPlayerPositionX(), updateReq.getPlayerPositionY(), s.isTreasureP1(), s.getCastlePositionXPlayer2(), s.getCastlePositionYPlayer2())) {
					s.setWinPlayer1(true);
					banana.setWin(true);
				}
			}
		}
		if(updateReq.getID()==s.getIdPlayer2()) {
			if(banana.isLoss() != true) {
				
				banana.setPlayerPosition(s.getPositionXPlayer2(), s.getPositionYPlayer2());
				banana.setEnemyPosition(s.getPositionXPlayer1(), s.getPositionYPlayer1());
				
				if(bs.checkIfOnMountain(updateReq.getPlayerPositionX(), updateReq.getPlayerPositionY(), s.getMap()) == true) {
					banana.setTreasurePosition(s.getTreasurePositionXPlayer2(), s.getTreasurePositionYPlayer2());
				}
				
				if(bs.checkIfTouchedTreasure(updateReq.getPlayerPositionX(), updateReq.getPlayerPositionY(), s.getMap(), s.getTreasurePositionXPlayer2(), s.getTreasurePositionYPlayer2()) == true) {
					s.setTreasureP2(true);
					banana.setTreasure(true);
				}
				
				if(bs.checkWinningCondition(updateReq.getPlayerPositionX(), updateReq.getPlayerPositionY(), s.isTreasureP2(), s.getCastlePositionXPlayer1(), s.getCastlePositionYPlayer1())) {
					s.setWinPlayer2(true);
					banana.setWin(true);
				}
				
			}
		}
		
		
		
		return banana;
	}
	
	
	
	@RequestMapping(value="/Problem", produces="application/xml", consumes="application/xml") //TODO Create ConnectionProblemRequest in documentation
	public ConnectionProblemResponse ConnectionProblem(@RequestBody ConnectionProblemRequest problemReq) {
		
		ConnectionProblemResponse banana = new ConnectionProblemResponse();
		if((problemReq.getID()==s.getIdPlayer1() && s.isLossPlayer1()==true) || s.isWinPlayer2()) {
			banana.setLoss(true);
		}
		if((problemReq.getID()==s.getIdPlayer2() && s.isLossPlayer2()==true) || s.isWinPlayer1()) {
			banana.setLoss(true);
		}
		
		return banana;
	}
}
