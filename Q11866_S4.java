package BOJ;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q11866_S4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int index = k - 1;
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(i + 1);
		}
		System.out.print("<");
		while (!list.isEmpty()) {
			System.out.print(list.remove(index));
			if (!list.isEmpty()) {
				System.out.print(", ");
				index += k - 1;
				index %= (list.size());
			}
		}
		System.out.print(">");
	}
}
