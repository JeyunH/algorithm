package BOJ;

import java.util.Scanner;

public class Test036_2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int nlen = String.valueOf(n).length();
		int base = n - nlen * 9;
		if(base<1) {
			base=1;
		}
		int blen = String.valueOf(base).length();
		int bsum = 0;
				
		for(int i = base;i<n;i++) {
			blen = String.valueOf(i).length();
			for (int j = 0; j < blen; j++) {
				bsum += String.valueOf(i).charAt(j) - '0';
			}
			if(n==i+bsum) {
				System.out.println(i);
				System.exit(0);
			}
			bsum = 0;
		}
		System.out.println(0);
		

		
	}
	
}
