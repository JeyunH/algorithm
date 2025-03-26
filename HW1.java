package weekly.assignment.week04.homeWork0325;

public class HW1 {
	public static void start() {
		int n = CalendarPrint.sp("항목을 선택하세요(1.특정년도  2.특정월  3.종료) => ");
		if (n == 1) {
			int y = CalendarPrint.sp("년도를 입력하세요 => ");
			for (int i = 1; i <= 12; i++) {
				CalendarPrint.cp(y, i);
			}
		} else if (n == 2) {
			int y= CalendarPrint.sp("년도를 입력하세요 => ");
			int m= CalendarPrint.sp("월을 입력하세요 => ");
			CalendarPrint.cp(y, m);
		}
	}
}
