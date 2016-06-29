import java.util.Scanner;

public class PascalTriangle {
	public static void main(String[] args) {

		System.out.println("Enter a number: ");
		Scanner scanner = new Scanner(System.in);
		Integer rows = scanner.nextInt();
		Integer columns = rows; 
		/**
		 * 1
		 * 121
		 * 1331
		 * 14641
		 */
		Integer[][] array = new Integer[rows][columns];
		array[0][0] = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int row = i-1<0?0:i-1;
				int column = j-1<0?0:j-1;
				array[i][j]=array[row][column];
				
			}
			System.out.println(array[i]);
		}
	}
}
