package BOJ;

import java.util.Scanner;

public class Q10997S2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 1;
		if (n != 1) { // n이 1이 아닐 때
			for (int i = 0; i < 4 * n - 3; i++) { // 1째줄 따로 그림 (비패턴)
				System.out.print("*");
			}
			System.out.println();
			System.out.println("*"); // 2째줄 따로 그림 (비패턴)

			for (int i = 0; i < 2 * n - 2; i++) { // 3째줄부터 중간까지 그리기 (패턴1)
				System.out.print("*");
				System.out.print(" ");
				for (int k = 0; k < i; k++) {
					switch (k % 2) {
					case 0:
						System.out.print("*");
						break;
					case 1:
						System.out.print(" ");
						break;
					}
				}
				for (int k = 0; k < 4 * n - 5 - 2 * i; k++) {
					switch (i % 2) {
					case 0:
						System.out.print("*");
						break;
					case 1:
						System.out.print(" ");
						break;
					}
				}
				for (int k = 0; k < i; k++) {
					switch ((k + i) % 2) {
					case 1:
						System.out.print("*");
						break;
					case 0:
						System.out.print(" ");
						break;
					}
				}
				System.out.println();
			}
			for (int i = 0; i < 2 * n - 1; i++) { // 중반부터 끝까지 그리기 (패턴2)
				for (int j = 0; j < 2 * n - 2 - i; j++) {
					switch (j % 2) {
					case 0:
						System.out.print("*");
						break;
					case 1:
						System.out.print(" ");
						break;
					}
				}
				for (int j = 0; j < i * 2 + 1; j++) {
					switch (i % 2) {
					case 0:
						System.out.print("*");
						break;
					case 1:
						System.out.print(" ");
						break;
					}
				}
				for (int j = 0; j < 2 * n - 2 - i; j++) {
					switch ((j + i) % 2) {
					case 0:
						System.out.print(" ");
						break;
					case 1:
						System.out.print("*");
						break;
					}
				}

				System.out.println();
			}
		} else {
			System.out.println("*");
		}
	}
}