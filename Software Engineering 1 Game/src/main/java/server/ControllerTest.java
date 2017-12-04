package server;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
	private Controller c;
	@Before
	public void setUp() throws Exception {
		c = new Controller();
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test
	public void testGetPlayerNumber() {
		c.getPlayerNumber();
	}

	@Test
	public void testSetPlayerNumber() {
		c.setPlayerNumber(1);
	}

	@Test
	public void testGetMapHalfP1() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMapHalfP1() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMapHalfP2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMapHalfP2() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdP1() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIdP1() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdP2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIdP2() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testConnectionProblem() {
		fail("Not yet implemented");
	}

}
