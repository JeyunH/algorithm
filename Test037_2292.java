package BOJ;

import java.util.Scanner;

public class Test037_2292 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 1;
        while(true){
            if(n<=((x-1)*3*x+1)){
                System.out.print(x);
                System.exit(0);
            }
        x++;
        }
//        x    (x-1)*3    (x-1)*3*x+1
    }
}