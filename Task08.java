package weekly.assignment.week01;

import java.util.Random;

public class Task08 {

	public static void main(String[] args) {
		Random r = new Random();
		
		int rand = r.nextInt(91) + 10; // rand에 10~100사이의 임의의 정수 저장
		boolean num = true;            // 논리변수 num 초기화 -> 출력 라인에 문자가 들어가는 경우 false를 저장하여 숫자를 출력하지 않도록 함

		System.out.println("*** 369 게임 (1 ~ " + rand + ") 시작 ***");
		
		for (int i = 1; i <= rand; i++) {  // 1에서 rand까지 반복 수행

			if (i > 10) {
				if ((i / 10) % 3 == 0) {
					System.out.print("짝"); // 10의 자리에 3,6,9가 들어가는 모든 경우에 "짝" 출력
					num = false;           // 문자를 출력했으니 num에 false를 저장
				}
			}

			if (i % 10 != 0) {
				if ((i - (i / 10) * 10) % 3 == 0) {
					System.out.print("짝"); // 1의 자리에 3,6,9가 들어가는 모든 경우 "짝" 출력
					num = false;           // 문자를 출력했으니 num에 false를 저장
				}
			}

			if (i % 10 == 0) {
				for (int j = 1; j <= i / 10; j++) {
					System.out.print("뽀"); // 10으로 나누어 떨어지는 숫자 중 10의 자리 숫자만큼 "뽀" 출력
				}
				System.out.print("숑");     // 10으로 나누어 떨어지는 숫자에 "숑" 출력
				num = false;               // 문자를 출력했으니 num에 false를 저장
			}

			if (num == true) {         // num이 true 라면 숫자를 출력, false 라면 숫자를 출력하지 않음
				System.out.println(i);
			} else {
				System.out.println();
				num = true;            // num이 다음 반복에도 같은 역할을 수행하도록 초기화
			}

		}

	}

}
