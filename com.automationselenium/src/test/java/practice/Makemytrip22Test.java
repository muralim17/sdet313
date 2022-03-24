package practice;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Makemytrip22Test {
public static void main(String[] args) {
	LocalDateTime dateandtime = LocalDateTime.now();
	int day1 = dateandtime.getDayOfMonth();
	DayOfWeek day2 = dateandtime.getDayOfWeek();
	int day3 = dateandtime.getDayOfYear();
	System.out.println(day1);
	System.out.println(day2);
	System.out.println(day3);
	int hour = dateandtime.getHour();
	long log = dateandtime.getLong(null);
	System.out.println(hour);
     System.out.println(log);
}
}
