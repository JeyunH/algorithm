package weekly.assignment.week02.Assignment_0312;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

class Icecream {
	String name;
	int price;
}

public class Assignment0312 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		re: while (true) {

			System.out.print("아이스크림 몇 개 구입할래? : ");
			n = sc.nextInt();

			Icecream[] ice = new Icecream[n];
			for (int i = 0; i < n; i++) {
				ice[i] = new Icecream();
			}

			System.out.println();

			for (int i = 0; i < n; i++) {
				System.out.printf("*** %d번째 아이스크림 구매 정보 입력 ***\n", i + 1);
				System.out.print("아이스크림명 : ");
				ice[i].name = sc.next();
				System.out.print("아이스크림가격 : ");
				ice[i].price = sc.nextInt();
				System.out.println();
			}

			System.out.printf("< %d개 아이스크림 구매 정보 출력 >\n", n);
			System.out.println("번호   아이스크림명   아이스크림가격");

			for (int i = 0; i < n; i++) {

				System.out.printf("%d      %s", i + 1, ice[i].name);
				for (int j = 0; j < 12 - ice[i].name.length(); j++) {
					System.out.print(" ");
				}
				System.out.println(ice[i].price);

			}

			int sum = Arrays.stream(ice).mapToInt(p -> p.price).sum();
			System.out.println("총합 : " + sum);
			System.out.println();
			char con = '0';

			while (con != 'y' && con != 'n') {
				System.out.println("계속구매할까? (y/n) => ");
				con = sc.next().charAt(0);
			}

			if (con == 'n') {
				System.out.println();
				break re;
			}

		}

	}

}
