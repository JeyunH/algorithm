package weekly.assignment.week03;

import java.util.Arrays;
import java.util.Random;

public class SJF_Assignment {

	public static void main(String[] args) {
		Random rd = new Random();
		int[] a = new int[10];

		System.out.println("10개의 작업을 생성");
		for (int i = 0; i < 10; i++) { 					// 10개의 작업을 생성
			a[i] = rd.nextInt(9) + 1;
			System.out.print(a[i] + " ");
		}

		System.out.println();
		Arrays.sort(a);									 // 소요되는 시간이 짧은 순서대로 작업을 정렬
		System.out.println("소요되는 시간이 짧은 작업부터 정렬");

		for (int i = 0; i < 10; i++) { 					// 정렬된 작업들을 출력
			System.out.print(a[i] + " ");
		}

		System.out.println();
		System.out.println("각 작업을 1단위로 수행");
		System.out.println();

		for (int i = 0; i < 10; i++) {					 // 각 작업 수행
			System.out.println("작업" + a[i] + "시작");
			for (int j = 1; j <= a[i]; j++) {
				System.out.print(a[i]);
			}
			System.out.println();
			System.out.println("작업" + a[i] + "종료");
			System.out.println();
		}

	}

}
