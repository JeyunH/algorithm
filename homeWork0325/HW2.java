package weekly.assignment.week04.homeWork0325;

import java.util.Calendar;

public class HW2 {
	public static void start(){
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		while (true) {
			int n= CalendarPrint.sp("항목을 선택하세요(1.현재  2.이전월  3.다음월  4.종료) => ");
			if (n == 1) {
				y = cal.get(Calendar.YEAR);
				m = cal.get(Calendar.MONTH)+1;

			} else if (n == 2) {
				m--;
				if (m == 0) {
					m = 12;
					y--;
				}

			} else if (n == 3) {
				m++;
				if (m == 13) {
					m = 1;
					y++;
				}

			} else {
				break;
			}
			CalendarPrint.cp(y,m);
		}
	}
}
