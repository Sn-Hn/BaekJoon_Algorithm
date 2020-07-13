package secondStage_if;

import java.util.Scanner;

public class ExamGrade {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		
		if(A>=90) {
			System.out.println("A");
		}else if(A>=80) {
			System.out.println("B");
		}else if(A>=70){
			System.out.println("C");
		}else if(A>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
	}
}
