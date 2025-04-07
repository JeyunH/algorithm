package BOJ;

import java.util.Scanner;

public class Q25206_S5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double gs = 0;
		double s = 0;
		for (int i = 0; i < 20; i++) {
			String str = sc.next();
			double gss = sc.nextDouble();
			double ss = 0;
			gs += gss;
			str = sc.next();
			switch (str.charAt(0)) {
			case 'A':
				if (str.charAt(1) == '+') {
					ss = 4.5;
				} else {
					ss = 4.0;
				}
				break;
			case 'B':
				if (str.charAt(1) == '+') {
					ss = 3.5;
				} else {
					ss = 3.0;
				}
				break;
			case 'C':
				if (str.charAt(1) == '+') {
					ss = 2.5;
				} else {
					ss = 2.0;
				}
				break;
			case 'D':
				if (str.charAt(1) == '+') {
					ss = 1.5;
				} else {
					ss = 1.0;
				}
				break;
			case 'F':
				ss = 0;
				break;
			case 'P':
				gs -= gss;
			}
			s += ss * gss;
			ss = 0;
		}
		System.out.println(s / gs);
	}
}