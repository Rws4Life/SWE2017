package server;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTestResponses {
	
	private Controller c;
	@Before
	public void setUp() throws Exception {
		c = new Controller();
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	//@Test
	public void testNewPlayer() {
		NewPlayerRequest newPlayerReq = new NewPlayerRequest();
		newPlayerReq.setFirstName("Razvan");
		newPlayerReq.setSecondName("Nancu");
		newPlayerReq.setMatrikelnummer(1502339);
		assertNotNull("Player", newPlayerReq);
		assertNotNull("Response" , c.NewPlayer(newPlayerReq));
	}

	

	public void testNewMap() {
		testNewPlayer();
		testNewPlayer();
		CreateNewMapRequest newMapReq1 = new CreateNewMapRequest();
		CreateNewMapRequest newMapReq2 = new CreateNewMapRequest();
		new Thread(() -> {
			
			newMapReq1.setID(1);
			newMapReq1.setMapHalf("0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");
			c.NewMap(newMapReq1);
		}).start();	
		
		newMapReq2.setID(2);
		newMapReq2.setMapHalf("0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");
		
		System.out.println("Didit");
		
		CreateNewMapResponse nmp = c.NewMap(newMapReq2);
		assertNotNull("Map ", nmp.getFullMap());
		System.out.println("Diditagain");
		//assertEquals(nmp.getFullMap(), "PC0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0MPC0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");
		//Statement above doesn't work because random treasure is generated which can't be predicted
	}

	//@Test
	public void testNewUpdate() {
		testNewMap();
		UpdateRequest upR = new UpdateRequest();
		upR.setID(1);
		upR.setPlayerPositionX(0);
		upR.setPlayerPositionY(0);
		upR.setWantedPositionX(0);
		upR.setWantedPositionY(1);
		upR.setTurnsLeft(2);
		
		UpdateResponse u = c.NewUpdate(upR);
		System.out.println(u.getEnemyPositionX() + " " + u.getEnemyPositionY());
		
		
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
		System.out.println(u.getEnemyPositionX() + " " + u.getEnemyPositionY());
		
		
	}
	@Test
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
		System.out.println(u.getEnemyPositionX() + " " + u.getEnemyPositionY());
		
		
	}

}
