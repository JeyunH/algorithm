package BOJ;

import java.util.Scanner;

public class Test032_10988 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int cnt = 0;
		for(int i = 0;i<str.length()/2;i++) {
			if(str.charAt(i)!=str.charAt(str.length()-i-1)) {
				cnt=0;
			}

		}
		System.out.println(cnt);
	}

}
