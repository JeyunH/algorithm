package BOJ;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q14425S4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet<>();

		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			set.add(sc.nextLine());
		}

		for (int i = 0; i < m; i++) {
			if (set.contains(sc.nextLine())) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}