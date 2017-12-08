package server;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerTestResponses {
	Logger logger = LoggerFactory.getLogger(ControllerTestResponses.class);
	private Controller c;
	Server s;
	@Before
	public void setUp() throws Exception {
		s = new Server();
		
		c = new Controller();
		c.setServer(s);
		testNewPlayer("Razvan", "Nancu", 1502339);
		testNewPlayer("Niko", "Abcdef", 2502339);
		testNewMapForTests();
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}
	//@Test
	public void testNewMapForTests() {
		CreateNewMapRequest newMapReq2 = new CreateNewMapRequest();
				//c.getServer().set
		logger.info("Second Thread for new map active.");
		newMapReq2.setID(2);
		newMapReq2.setMapHalf("0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");
		
		CreateNewMapResponse nmp = c.NewMapForTests(newMapReq2);
		logger.info("Setting up whole map");
		assertNotNull("Map ", nmp.getFullMap());
		logger.info("Done setting up map");
	}
	//@Test
	public void testNewPlayer(String fn, String sn, int matn) {
		NewPlayerRequest newPlayerReq = new NewPlayerRequest();
		newPlayerReq.setFirstName(fn);
		newPlayerReq.setSecondName(sn);
		newPlayerReq.setMatrikelnummer(matn);
		assertNotNull("Player", newPlayerReq);
		assertNotNull("Response" , c.NewPlayer(newPlayerReq));
	}

	
	//@Test
	public void testNewMap() {
		
		CreateNewMapRequest newMapReq1 = new CreateNewMapRequest();
		CreateNewMapRequest newMapReq2 = new CreateNewMapRequest();
		new Thread(() -> {
			logger.info("First Thread for new map active.");
			newMapReq1.setID(1);
			newMapReq1.setMapHalf("0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");
			c.NewMap(newMapReq1);
		}).start();
		//c.getServer().set
		logger.info("Second Thread for new map active.");
		newMapReq2.setID(2);
		newMapReq2.setMapHalf("0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");
		
		CreateNewMapResponse nmp = c.NewMap(newMapReq2);
		logger.info("Setting up whole map");
		assertNotNull("Map ", nmp.getFullMap());
		logger.info("Done setting up map");
		//assertEquals(nmp.getFullMap(), "PC0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0MPC0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");
		//Statement above doesn't work because random treasure is generated which can't be predicted
	}

	//@Test
	public void testNewUpdate() {

		UpdateRequest upR = new UpdateRequest();
		upR.setID(1);
		upR.setPlayerPositionX(0);
		upR.setPlayerPositionY(0);
		upR.setWantedPositionX(0);
		upR.setWantedPositionY(1);
		upR.setTurnsLeft(2);
		
		UpdateResponse u = c.NewUpdate(upR);
		System.out.println("Loss? " +u.isLoss()+" Enemy Pos X: " + u.getEnemyPositionX() + " Enemy Pos Y: " + u.getEnemyPositionY());
		
		
	}
	
	//@Test
	public void testNewUpdate2() {
		testNewUpdate();
		UpdateRequest upR = new UpdateRequest();
		upR.setID(2);
		upR.setPlayerPositionX(4);
		upR.setPlayerPositionY(0);
		upR.setWantedPositionX(4);
		upR.setWantedPositionY(1);
		upR.setTurnsLeft(2);
		
		UpdateResponse u = c.NewUpdate(upR);
		System.out.println("Loss? " +u.isLoss()+" Enemy Pos X: " + u.getEnemyPositionX() + " Enemy Pos Y: " + u.getEnemyPositionY());
		
		
	}
	//@Test
	public void testNewUpdate3() {
		testNewUpdate2();
		UpdateRequest upR = new UpdateRequest();
		upR.setID(1);
		upR.setPlayerPositionX(0);
		upR.setPlayerPositionY(0);
		upR.setWantedPositionX(0);
		upR.setWantedPositionY(1);
		upR.setTurnsLeft(1);
		
		UpdateResponse u = c.NewUpdate(upR);
		System.out.println("Loss? " +u.isLoss()+"Enemy Pos X: " + u.getEnemyPositionX() + "Enemy Pos Y: " + u.getEnemyPositionY());
		
		
	}
	//@Test
		public void testNewUpdate4() {
			testNewUpdate3();
			UpdateRequest upR = new UpdateRequest();
			upR.setID(2);
			upR.setPlayerPositionX(4);
			upR.setPlayerPositionY(0);
			upR.setWantedPositionX(4);
			upR.setWantedPositionY(1);
			upR.setTurnsLeft(1);
			
			UpdateResponse u = c.NewUpdate(upR);
			System.out.println("Loss? " +u.isLoss()+" Enemy Pos X: " + u.getEnemyPositionX() + " Enemy Pos Y: " + u.getEnemyPositionY());	
		}
	//	@Test
		public void testNewUpdate5() {
			testNewUpdate4();
			UpdateRequest upR = new UpdateRequest();
			upR.setID(1);
			upR.setPlayerPositionX(0);
			upR.setPlayerPositionY(0);
			upR.setWantedPositionX(0);
			upR.setWantedPositionY(1);
			upR.setTurnsLeft(0);
			
			UpdateResponse u = c.NewUpdate(upR);
			System.out.println("Loss? " +u.isLoss()+" Enemy Pos X: " + u.getEnemyPositionX() + " Enemy Pos Y: " + u.getEnemyPositionY());
			
			
		}
		//@Test
		public void testNewUpdate6() {
			testNewUpdate5();
			UpdateRequest upR = new UpdateRequest();
			upR.setID(2);
			upR.setPlayerPositionX(4);
			upR.setPlayerPositionY(0);
			upR.setWantedPositionX(4);
			upR.setWantedPositionY(1);
			upR.setTurnsLeft(0);
			
			UpdateResponse u = c.NewUpdate(upR);
			System.out.println("Loss? " +u.isLoss()+" Enemy Pos X: " + u.getEnemyPositionX() + " Enemy Pos Y: " + u.getEnemyPositionY());	
		}
		@Test
		public void testNewUpdate7() {
			testNewUpdate4();
			UpdateRequest upR = new UpdateRequest();
			upR.setID(1);
			upR.setPlayerPositionX(0);
			upR.setPlayerPositionY(1);
			upR.setWantedPositionX(0);
			upR.setWantedPositionY(2);
			upR.setTurnsLeft(2);
			
			UpdateResponse u = c.NewUpdate(upR);
			System.out.println("Last: Loss? " +u.isLoss()+" Enemy Pos X: " + u.getEnemyPositionX() + " Enemy Pos Y: " + u.getEnemyPositionY());
			
			
		}
}
