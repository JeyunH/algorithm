package BOJ;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1316S5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int cnt = 0;
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			char cha = str.charAt(0);
			set.add(str.charAt(0));
			for (int j = 1; j < str.length(); j++) {

				if (!set.add(str.charAt(j)) && cha != str.charAt(j)) {
					cnt++;
					break;
				}

				cha = str.charAt(j);
			}

			set.clear();
		}

		System.out.println(n - cnt);
	}
}