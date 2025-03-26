package weekly.assignment.week04.homeWork0325;

public class CalendarMain {

	public static void main(String[] args) {
		int n = CalendarPrint.sp("과제을 선택하세요(1. 1번 과제  2. 2번 과제  3. 종료) => ");
		switch (n) {
		case 1 : HW1.start(); break;
		case 2 : HW2.start();
		}
	}

}
