package BOJ;

import java.util.Scanner;

public class Q7489_B2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int c = 1;
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			for (int j = 1; j <= n; j++) {
				c *= j;
				while (true) {
					if (c % 10 == 0) {
						c /= 10;
					} else {
						c %= 1000;
						break;
					}
				}
			}
			System.out.println(c % 10);
			c = 1;
		}
	}
}