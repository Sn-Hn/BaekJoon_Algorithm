package ninth_math;

import java.util.Scanner;

public class Honeycomb_2292 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int i = 1;
		int sequence = 1;
		
		while(true) {
			sequence += 6*i;
			if(n <= sequence && n != 1) {
				System.out.println(i+1);
				break;
			}else if(n == 1) {
				System.out.println(i);
				break;
			}
			i++;
		}
		
	}
}
