package BOJ;

import java.util.Scanner;

public class Test033_5086 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a>b){
                if(a%b==0){
                    System.out.println("multiple");
                    
                }else{
                    System.out.println("neither");
                }
              
                
                    
            }else if(b>a){
                if( b%a==0){
                    System.out.println("factor");
                    
                }else{
                     System.out.println("neither");
                }
                
            }else{
                break;
            }

        }

    }
}