import java.util.Scanner;

public class RunApp {
	public static void main(String[] args) {
		FiveInRow fiveInRow = new FiveInRow();
		Scanner scanner = new Scanner(System.in);
		String matrix[] = new String[10];
		for (int i = 0; i < 10; i++) {
			matrix[i] = scanner.nextLine();
		}
		System.out.println(fiveInRow.checkFiveInRow(matrix)) ;
		scanner.close();
	}
}
