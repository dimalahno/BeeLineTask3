public class FiveInRow {

	// Применён алгоритм перебора возможных решений и определения совпадения позиции.

	public String checkFiveInRow(String[] matrix) {
		for (int i = 0; i < 10; i++) {

			//Ищем строку с первым вхождение X
			// int indexOf(int ch) — возвращает индекс в данной строке первого вхождения указанного символа
			// или -1, если символ не встречается.
			int indexOfX = matrix[i].indexOf("X");
			while (indexOfX != -1) {

				//Горизонтальный анализ
				String matrixLine = matrix[i];
				if(matchSearch(matrixLine)) return "YES";

				//Вертикальный анализ
				matrixLine = buildVerticalLine(matrix,indexOfX); //Передаём матрицу и индекс первого Х
				if(matchSearch(matrixLine)) return "YES";

				//Анализ по диагонали левой - \
				matrixLine = buildLeftDiagonalLine(matrix, i, indexOfX); //Передаём матрицу, индекс строки, индекс первого Х
				if(matchSearch(matrixLine)) return "YES";

				//Анализ по диагонали правой - /
				matrixLine = buildRightDiagonalLine(matrix, i, indexOfX);
				if(matchSearch(matrixLine)) return "YES";

				//Двигаемя по строке вправо, может ещё есть Х
				//int indexOf(int ch, int fromIndex) — возвращает индекс в данной строке первого вхождения указанного символа,
				// начиная поиск по указанному индексу, или значение -1, если символ не встречается.
				indexOfX = matrix[i].indexOf("X", indexOfX+1);
			}
		}
		return "NO";
	}

	// Проверка на совпадение
	private boolean matchSearch(String line) {
		if ((line.contains("XXXX."))||(line.contains("X.XXX"))||(line.contains("XX.XX"))||(line.contains("XXX.X"))||(line.contains(".XXXX"))) {
			return true;
		}
		return false;
	}

	// Строим вертикальную линию
	private String buildVerticalLine(String[] matrix, int indexOfX) {
		StringBuilder verticalLine = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			verticalLine.append(matrix[i].charAt(indexOfX));
		}
		return verticalLine.toString();
	}

	//Строим левую диагональную линию
	private String buildLeftDiagonalLine(String[] matrix, int i, int indexOfX) {
		StringBuilder diagonalLine = new StringBuilder();

		if ((i > 0) && (indexOfX > 0)) {
			char c = matrix[i-1].charAt(indexOfX-1);
			if (c == '.') {
				diagonalLine.append(c);
			}
		}

		for (int j = i; j < 10; j++) {
			if (indexOfX < 10) {
				diagonalLine.append(matrix[j].charAt(indexOfX++));
			} else break;
		}
		return diagonalLine.toString();
	}

	//Строим правую диагональную линию
	private String buildRightDiagonalLine(String[] matrix, int i, int indexOfX) {
		StringBuilder diagonalLine = new StringBuilder();

		if ((i > 0) && (indexOfX < 9)) {
			char c = matrix[i-1].charAt(indexOfX+1);
			if (c == '.') {
				diagonalLine.append(c);
			}
		}

		for (int idX = i; idX < 10; idX++) {
			if(indexOfX >= 0)
				diagonalLine.append(matrix[idX].charAt(indexOfX--));
			else break;
		}
		return diagonalLine.toString();
	}
}