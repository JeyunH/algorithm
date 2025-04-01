package BOJ;

import java.util.Scanner;

public class Test038_2501 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;
        for(int i = 1; i <=n ; i++){
            if(n%i == 0){
                cnt++;
                if(k == cnt){
                    System.out.print(i);
                    System.exit(0);
                }
            }
        }
        System.out.print(0);
    }
}