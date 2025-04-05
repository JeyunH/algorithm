package BOJ;

import java.util.Scanner;

public class Test040_13015 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i < 2 * (n - 1); i++) {
			if (i == 1) {
				for (int j = 0; j < n; j++) {
					System.out.print("*");
				}
				for (int j = 0; j < 2 * n - 3; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < n; j++) {
					System.out.print("*");
				}
				System.out.println();
			}

			for (int j = 1; j <= n - Math.abs(n - i - 1) - 1; j++) {
				System.out.print(" ");
			}

			System.out.print("*");
			for (int j = 1; j <= n - 2; j++) {
				System.out.print(" ");
			}
			System.out.print("*");

			for (int j = 1; j < Math.abs(2 * (n - i) - 2); j++) {
				System.out.print(" ");
			}

			if (n - 1 != i) {
				System.out.print("*");

			}
			for (int j = 1; j <= n - 2; j++) {
				System.out.print(" ");
			}
			System.out.print("*");

			System.out.println();
			if (i == 2 * n - 3) {
				for (int j = 0; j < n; j++) {
					System.out.print("*");
				}
				for (int j = 0; j < 2 * n - 3; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < n; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}