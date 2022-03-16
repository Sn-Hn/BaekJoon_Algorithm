package sixth_array;

import java.util.Arrays;
import java.util.Scanner;

public class GradeAverage_1546 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double grade[] = new double[n];
		double maximum = 0;
		double sum = 0;
		for(int i = 0; i < n; i++) {
			grade[i] = scan.nextInt();
		}
		Arrays.sort(grade);
		maximum = grade[grade.length-1];
		for(int i = 0; i < n; i++) {
			sum += (grade[i]/maximum)*100;
		}
		
		System.out.println(sum/n);
		
	}
}
