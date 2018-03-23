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
		// Тест на горизонтальную линию
		assertEquals("YES", fiveInRow.checkFiveInRow(new String[] {"XX.XX.....", ".....OOOO.", "..........", "..........", "..........", "..........", "..........", "..........", "..........", ".........."}));
		// Тест на горизонтальную линию в произвольном ряду
		assertEquals("YES", fiveInRow.checkFiveInRow(new String[] {"..........", ".....OOOO.", "..........", "..........", ".X.XXX....", "..........", "..........", "..........", "..........", ".........."}));
		// Тест на отсутствие совпадений
		assertEquals("NO", fiveInRow.checkFiveInRow(new String[] {"XXOXX.....", "OO.O......", "..........", "..........", "..........", "..........", "..........", "..........", "..........", ".........."}));
		// Тест на горизонтальную линию
		assertEquals("YES", fiveInRow.checkFiveInRow(new String[] {"..........", "OO.O......", "....X.....", "....X.....", "....X.....", "..........", "....X.....", "..........", "..........", ".........."}));
		// Тест на левую диагональ - \
		assertEquals("YES", fiveInRow.checkFiveInRow(new String[] {"..........", "OO.XOO....", "....X.....", ".....X....", "......X...", "..........", "..........", "..........", "..........", ".........."}));
		// Тест на правую диагональ - /
		assertEquals("YES", fiveInRow.checkFiveInRow(new String[] {"..........", "OO..OO....", "..........", "..........", "..........", "......X...", ".....X....", "..........", "...X......", "..X......."}));
	}
}