package secondStage_if;

import java.util.Scanner;

public class SubTime {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int minute = 0;
		int hour = 0;
		minute = A*60 + B;
		minute -= 45;
		
		hour = minute/60;
		minute %= 60;
		if(minute < 0) {
			hour = 23;
			minute = 60+minute;
		}
		
		System.out.println(hour + " " + minute);
	}
}
