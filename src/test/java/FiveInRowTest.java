import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FiveInRowTest {
	FiveInRow fiveInRow;

	@Before
	public void initTest(){
		fiveInRow = new FiveInRow();
	}

	@After
	public void afterTest(){
		fiveInRow = null;
	}

	@Test
	public void checkFiveInRowTest() {
		assertEquals("YES", fiveInRow.checkFiveInRow(new String[] {"XX.XX.....",
																		   ".....OOOO.",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "..........",
																		   ".........."}));

		assertEquals("YES", fiveInRow.checkFiveInRow(new String[] {"..........",
																		   ".....OOOO.",
																		   "..........",
																		   "..........",
																		   ".X.XXX....",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "..........",
																		   ".........."}));

		assertEquals("NO", fiveInRow.checkFiveInRow(new String[] { "XXOXX.....",
																		   "OO.O......",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "..........",
																		   ".........."}));

		assertEquals("YES", fiveInRow.checkFiveInRow(new String[] {"..........",
																		   "OO.O......",
																		   "....X.....",
																		   "....X.....",
																		   "....X.....",
																		   "..........",
																		   "....X.....",
																		   "..........",
																		   "..........",
																		   ".........."}));

		assertEquals("YES", fiveInRow.checkFiveInRow(new String[] {"..........",
																		   "OO.XOO....",
																		   "....X.....",
																		   ".....X....",
																		   "......X...",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "..........",
																		   ".........."}));

		assertEquals("YES", fiveInRow.checkFiveInRow(new String[] {"..........",
																		   "OO..OO....",
																		   "..........",
																		   "..........",
																		   "..........",
																		   "......X...",
																		   ".....X....",
																		   "..........",
																		   "...X......",
																		   "..X......."}));
	}
}