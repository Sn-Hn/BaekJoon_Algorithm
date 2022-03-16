package sixth_array;

import java.util.Scanner;

public class OverAverage {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		for(int i = 0; i < n; i++) {
			double sum = 0;
			double average = 0;
			double cnt = 0;
			double per = 0;
			int persons = scan.nextInt();
			double arr[] = new double[persons];
			
			for(int j = 0; j < persons; j++) {
				arr[j] = scan.nextInt();
				sum += arr[j];
			}
			average = sum/persons;
			for(int j = 0; j < persons; j++) {
				if(average < arr[j]) {
					cnt ++;
				}
			}
			per = cnt/persons*100.0;
			per = Math.round(per*1000)/1000.0;
			System.out.println(String.format("%.3f", per) +"%");
			
			
		}
		
	}
}
