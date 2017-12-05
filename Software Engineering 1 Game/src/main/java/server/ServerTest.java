package server;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServerTest {
	private Server s;
	String[][] map = new String[][]{
		  { "PC", "0T", "0G", "0G", "0G", "0G", "0G", "0M" },
		  { "0G", "0G", "0W", "0T", "0G", "0G", "0G", "0M" },
		  { "0G", "0W", "0G", "0G", "0W", "0G", "0G", "0M" },
		  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
		  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
		  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
		  { "0G", "0W", "0T", "0G", "0W", "0G", "0G", "0M" },
		  { "PC", "0W", "0G", "0W", "0G", "0G", "0M", "0M" }};
	@Before
	public void setUp() throws Exception {
		s = new Server();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void testArrayToString() {
		s.arrayToString(map);
	}

	@Test
	public void testStringToArray() {
		s.stringToArray("0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");
	}

	@Test
	public void testCheckRules() {
		BusinessRules bs = new BusinessRules();
		MapConfiguration m = new MapConfiguration();
		m.setMap(m.stringToArray("0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M"));
		s.checkRules(2, bs, s, 4, 0, 4, 1, 1);
	}

	@Test
	public void testUpdatePlayerPosition() {
		s.updatePlayerPosition(1, 1, 1, 0, map);
	}

	@Test
	public void testPrepareMap() {
		MapConfiguration m = new MapConfiguration();
		s.prepareMap("0G0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M", "0G0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M", s);
	}

}
