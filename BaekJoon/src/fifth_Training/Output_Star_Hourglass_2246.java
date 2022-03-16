package fifth_Training;

import java.util.Scanner;

public class Output_Star_Hourglass_2246 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num*2-i-1; j++) {
				if(j >= i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			
			System.out.println();
		}
		for(int i = 1; i < num; i++) {
			for(int j = 0; j < num+i; j++) {
				if(j >= num-i-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
//				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
}
