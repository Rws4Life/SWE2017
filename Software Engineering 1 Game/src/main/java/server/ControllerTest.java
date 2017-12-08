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
		assertNull(c.getMapHalfP1());
	}

	@Test
	public void testSetMapHalfP1() {
		c.setMapHalfP1("0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");
	}

	@Test
	public void testGetMapHalfP2() {
		c.getMapHalfP2();
	}

	@Test
	public void testSetMapHalfP2() {
		c.setMapHalfP2("0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");
	}

	@Test
	public void testGetIdP1() {
		c.getIdP1();
	}

	@Test
	public void testSetIdP1() {
		c.setIdP1(1);
	}

	@Test
	public void testGetIdP2() {
		c.getIdP2();
	}

	@Test
	public void testSetIdP2() {
		c.setIdP2(2);
	}

}
