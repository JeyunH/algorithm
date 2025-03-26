package weekly.assignment.week04.homeWork0325;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarPrint {
	static Scanner sc = new Scanner(System.in);
		
	public static void cp(int y,int m) {
		Calendar cal = Calendar.getInstance();
		cal.set(y, m - 1, 1);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("\t\t<< " + y + "년 " + m + "월 >>");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int j = 1; j < dayOfWeek; j++) {
			System.out.print("\t");
		}
		for (int j = 1; j <= lastDay; j++) {
			System.out.print(j + "\t");
			if ((j + dayOfWeek - 1) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
        System.out.println();
	}
	
	public static int sp(String s) {
		System.out.print(s);
		int n = sc.nextInt();
		sc.nextLine();
		return n;
	}
	
}
