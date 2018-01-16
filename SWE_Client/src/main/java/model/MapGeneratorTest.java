package model;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class MapGeneratorTest {

	private MapGenerator mg;
	String[][] map;
	MapCheck mc;
	
	@Before
	public void setUp() throws Exception {
		mg = new MapGenerator();
		map = new String[4][8];
		mc = new MapCheck();
	}

	@After
	public void tearDown() throws Exception {
		mg = null;
	}
	
	
	@Test
	public void testCreateMapHalf() {
		mg.generateMapHalf(map, mc);
		mg.printMap(map);
	}
	
}
