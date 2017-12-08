package server;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerTestMap {
	Logger logger = LoggerFactory.getLogger(ControllerTestResponses.class);
	private Controller c;
	private Server s;
	@Before
	public void setUp() throws Exception {
		s = new Server();
		
		c = new Controller();
		c.setServer(s);
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		s = null;
		}

	@Test
	public void testNewPlayer() {
		NewPlayerRequest newPlayerReq = new NewPlayerRequest();
		newPlayerReq.setFirstName("Razvan");
		newPlayerReq.setSecondName("Nancu");
		newPlayerReq.setMatrikelnummer(1502339);
		assertNotNull("Player", newPlayerReq);
		assertNotNull("Response" , c.NewPlayer(newPlayerReq));
	}
	@Test
	public void testNewPlayer2() {
		NewPlayerRequest newPlayerReq = new NewPlayerRequest();
		newPlayerReq.setFirstName("Razvan");
		newPlayerReq.setSecondName("Nancu");
		newPlayerReq.setMatrikelnummer(1502339);
		assertNotNull("Player", newPlayerReq);
		assertNotNull("Response" , c.NewPlayer(newPlayerReq));
	}
	@Test
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

}
