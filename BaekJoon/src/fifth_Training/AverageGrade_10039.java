package fifth_Training;

import java.util.Scanner;

public class AverageGrade_10039 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int grade[] = new int[5];
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			grade[i] = scan.nextInt();
		}
		
		for(int i : grade) {
			if(i >= 40) {
				sum += i;
			}else {
				sum += 40;
			}
		}
		System.out.println(sum/5);
		
	}
}
