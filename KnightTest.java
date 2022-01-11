import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KnightTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testKnight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentSquare() {
		Square start = new Square(4,0);
		Knight mildred = new Knight(start,5,5);
		assertEquals(new Square(4,0),mildred.getCurrentSquare());
	}

	@Test
	public void testGetStartingSquare() {
		Square start = new Square(4,0);
		Knight mildred = new Knight(start,5,5);
		assertEquals(new Square(4,0),mildred.getStartingSquare());
	}

	@Test
	public void testGetBoard() {
		Square start = new Square(4,0);
		Knight mildred = new Knight(start,5,5);
		boolean[][] result = mildred.getBoard();
		assertEquals(5,result.length);
		assertEquals(5,result[0].length);
		assertEquals(5,result[1].length);
		assertEquals(5,result[2].length);
		assertEquals(5,result[3].length);
		assertEquals(5,result[4].length);
	}

	@Test
	public void testSolve() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCurrentSquare() {
		Square start = new Square(4,0);
		Knight mildred = new Knight(start,5,5);
		mildred.setCurrentSquare(new Square(3,2));
		boolean[][] b = mildred.getBoard();
		assertTrue(b[4][0]);
		assertTrue(b[3][2]);
		assertEquals(new Square(3,2),mildred.getCurrentSquare());
	}

	@Test
	public void testSetStartingSquare() {
		Square start = new Square(4,0);
		Knight mildred = new Knight(start,5,5);
		mildred.setStartingSquare(new Square(0,0));
		boolean[][] b = mildred.getBoard();
		assertFalse(b[4][0]);
		assertTrue(b[0][0]);
		assertEquals(new Square(0,0),mildred.getCurrentSquare());
		assertEquals(new Square(0,0),mildred.getStartingSquare());
	}

	@Test
	public void testGetBestSquares() {
		Square start = new Square(3,1);
		Knight zuzu = new Knight(start,5,5);
		Square[] poieszible = {new Square(1,0),new Square(1,2),new Square(2,3),new Square(4,3)};
		Square[] drBest = zuzu.getBestSquares(poieszible);
		boolean b1 = false;
		boolean b2 = false;
		for (int k = 0; k < drBest.length; k++) {
			Square current = drBest[k];
			if (current.equals(new Square(1,0))) {
				b1 = true;
			}
			if (current.equals(new Square(4,3))) {
				b2 = true;
			}
		}
		assertTrue(b1 && b2);
		boolean b3 = false;
		boolean b4 = false;
		for (int k = 0; k < drBest.length; k++) {
			Square current = drBest[k];
			if (current.equals(new Square(1,2))) {
				b3 = true;
			}
			if (current.equals(new Square(2,3))) {
				b4 = true;
			}
		}
		assertFalse(b3 || b4);
	}

	@Test
	public void testGetBestSquare() {
		Square start = new Square(3,1);
		Knight zuzu = new Knight(start,5,5);
		Square[] poieszible = {new Square(1,0),new Square(1,2),new Square(2,3),new Square(4,3)};
		Square[] drBest = {new Square(1,0),new Square(4,3)};
		Square best = zuzu.getBestSquare(drBest);
		assertTrue(best.equals(new Square(1,0)) || best.equals(new Square(4,3)));
	}

	@Test
	public void testClearBoard() {
		Square start = new Square(4,0);
		Knight mildred = new Knight(start,5,5);
		mildred.clearBoard();
		boolean[][] b = mildred.getBoard();
		for (int r = 0; r < b.length; r++) {
			for (int c = 0; c < b[r].length; c++) {
				if (b[r][c]) {
					fail();
				}
			}
		}
	}

	@Test
	public void testGetPossibleSquares() {
		Square start = new Square(4,0);
		Knight mildred = new Knight(start,5,5);
		Square[] p1 = mildred.getPossibleSquares();
		boolean b1 = false;
		for (int k = 0; k < p1.length; k++) {
			if (p1[k].equals(new Square(2,1))) {
				b1 = true;
			}
		}
		assertTrue(b1);
		boolean b2 = false;
		for (int k = 0; k < p1.length; k++) {
			if (p1[k].equals(new Square(3,2))) {
				b2 = true;
			}
		}
		assertTrue(b2);
		
		Square start2 = new Square(2,2);
		Knight eloise = new Knight(start2,5,5);
		
		Square[] p2 = eloise.getPossibleSquares();
		
		boolean b3 = false;
		for (int k = 0; k < p2.length; k++) {
			if (p2[k].equals(new Square(0,1))) {
				b3 = true;
			}
		}
		assertTrue(b3);
		boolean b4 = false;
		for (int k = 0; k < p2.length; k++) {
			if (p2[k].equals(new Square(0,3))) {
				b4 = true;
			}
		}
		assertTrue(b4);
		boolean b5 = false;
		for (int k = 0; k < p2.length; k++) {
			if (p2[k].equals(new Square(1,0))) {
				b5 = true;
			}
		}
		assertTrue(b5);
		boolean b6 = false;
		for (int k = 0; k < p2.length; k++) {
			if (p2[k].equals(new Square(1,4))) {
				b6 = true;
			}
		}
		assertTrue(b6);
		
		boolean b7 = false;
		for (int k = 0; k < p2.length; k++) {
			if (p2[k].equals(new Square(4,1))) {
				b7 = true;
			}
		}
		assertTrue(b7);
		boolean b8 = false;
		for (int k = 0; k < p2.length; k++) {
			if (p2[k].equals(new Square(4,3))) {
				b8 = true;
			}
		}
		assertTrue(b8);
		boolean b9 = false;
		for (int k = 0; k < p2.length; k++) {
			if (p2[k].equals(new Square(3,0))) {
				b9 = true;
			}
		}
		assertTrue(b9);
		boolean b10 = false;
		for (int k = 0; k < p2.length; k++) {
			if (p2[k].equals(new Square(3,4))) {
				b10 = true;
			}
		}
		assertTrue(b10);		
	}

	@Test
	public void testGetScoreOfSquare() {
		Knight eloise = new Knight(new Square(0,0),8,8);
		assertEquals(5,eloise.getScoreOfSquare(1,2));
		assertEquals(5,eloise.getScoreOfSquare(2,1));
		assertEquals(3,eloise.getScoreOfSquare(0,1));
		assertEquals(4,eloise.getScoreOfSquare(0,2));
		assertEquals(4,eloise.getScoreOfSquare(0,3));
		assertEquals(4,eloise.getScoreOfSquare(0,4));
		assertEquals(4,eloise.getScoreOfSquare(0,5));
		assertEquals(3,eloise.getScoreOfSquare(0,6));
		assertEquals(2,eloise.getScoreOfSquare(0,7));
		assertEquals(8,eloise.getScoreOfSquare(3,4));
	}

	@Test
	public void testIsValid() {
		Square start = new Square(4,0);
		Knight mildred = new Knight(start,5,5);
		assertFalse(mildred.isValid(-1,0));
		assertFalse(mildred.isValid(0,-1));
		assertFalse(mildred.isValid(-1,-1));
		assertFalse(mildred.isValid(5,0));
		assertFalse(mildred.isValid(0,5));
		assertFalse(mildred.isValid(5,5));
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				assertTrue(mildred.isValid(r, c));
			}
		}		
	}
}
