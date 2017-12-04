package server;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BusinessRulesTest {
	private BusinessRules bs;

	@Before
	public void setUp() throws Exception {
		bs = new BusinessRules();
	}

	@After
	public void tearDown() throws Exception {
		bs = null;
	}

	@Test
	public void testCheckForIslands() {
		String[][] mapHalf = new String[][]{
			  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0G", "0W", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
		};
		bs.checkForIslands(mapHalf);
	}

	@Test
	public void testCheckMapGeneration() {
		String[][] mapHalf = new String[][]{
			  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0G", "0W", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
		};
		bs.checkMapGeneration(mapHalf);
	}

	@Test
	public void testRoundCount() {
		bs.roundCount(15);
	}

	@Test
	public void testCheckSpawnOfTreasureAndCastle() {
		String[][] map = new String[][]{
			  { "PC", "0T", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0W", "0T", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0G", "0W", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
			  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0T", "0G", "0W", "0G", "0G", "0M" },
			  { "PC", "0W", "0G", "0W", "0G", "0G", "0M", "0M" }};
		assertEquals(bs.checkSpawnOfTreasureAndCastle(map), true);
	}

	@Test
	public void testCheckFieldMovement() {
		bs.checkFieldMovement(1, 1, 2, 1);
	}

	@Test
	public void testCheckRoundsUntilMove() {
		String[][] map = new String[][]{
			  { "PC", "0T", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0W", "0T", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0G", "0W", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
			  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0T", "0G", "0W", "0G", "0G", "0M" },
			  { "PC", "0W", "0G", "0W", "0G", "0G", "0M", "0M" }};
		bs.checkRoundsUntilMove(0, 0, 0, 1, 2, map);
	}

	@Test
	public void testCheckPlayerNotOnWaterOrOutsideMap() {
		String[][] map = new String[][]{
			  { "0C", "0T", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "PW", "0W", "0T", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0G", "0W", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
			  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0T", "0G", "0W", "0G", "0G", "0M" },
			  { "0C", "0W", "0G", "0W", "0G", "0G", "0M", "0M" }};
		
		assertEquals(bs.checkPlayerNotOnWaterOrOutsideMap(1, 1, map), false); //It Works!
	}

	@Test
	public void testCheckIfTouchedTreasure() {
		String[][] map = new String[][]{
			  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "PG", "0W", "0T", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0G", "0W", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
			  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0G", "0W", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" }};
		bs.checkIfTouchedTreasure(1, 1, map, 1, 3);
	}

	@Test
	public void testCheckWinningCondition() {
		bs.checkWinningCondition(2, 3, false, 2, 3);
	}

	@Test
	public void testCheckIfOnMountain() {
		String[][] map = new String[][]{
			  { "0M", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "PM", "0W", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" },
			  { "0G", "0G", "0G", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0G", "0W", "0G", "0G", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0G", "0W", "0G", "0G", "0M" },
			  { "0G", "0W", "0G", "0W", "0G", "0G", "0M", "0M" }};
		bs.checkIfOnMountain(2, 3, map);
	}

}
