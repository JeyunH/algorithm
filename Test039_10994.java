package BOJ;

import java.util.Scanner;

public class Test039_10994 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int cnt2 = 0;
		for (int i = 1; i <= 4 * n - 3; i++) {
			System.out.print("*");

			for (int j = 0; j < cnt / 2; j++) {
				System.out.print(" ");
				System.out.print("*");
			}

			if (i % 2 == 1) {
				for (int j = 1; j <= 4 * n - 5 - cnt * 2; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = 1; j <= 4 * n - 3 - cnt * 2; j++) {
					System.out.print(" ");
				}
			}

			for (int j = 0; j < cnt / 2; j++) {
				if (n * 2 - 1 == i && cnt2 == 0) {
					System.out.print(" ");
					cnt2++;
					continue;
				}
				System.out.print("*");
				System.out.print(" ");
			}

			if (n != 1) {
				System.out.print("*");
				System.out.println();
			}

			if (i < 2 * n - 1) {
				cnt++;
			} else {
				cnt--;
			}
		}
	}
}
