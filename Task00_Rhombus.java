package weekly.assignment.week02.Assignment_0311;

import java.util.Scanner;

public class Task00_Rhombus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("라인 수 입력 : ");
		int input = sc.nextInt();
		int n = (input+1)/2;
		System.out.println();
		
		for (int i = 1; i <= n * 2; i++) {
			for (int j = 1; j <= Math.abs(n - i); j++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= 2 * (n - Math.abs(n - i)) - 1; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}

}
