package ninth_math;

import java.util.Scanner;

public class Findfraction_1193 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int denominator = 0;
		int numerator = 0;
		int i = 1;				// 분모, 분자가 되는 수
		int se = 1;
		
		while(true) {
			se += i;
			if(n < se) {
				System.out.println(se-i);
				System.out.println(se);
				denominator = n-(se-i)+1;
				numerator = i-(n-(se-i));
				System.out.println("se : " + se);
				System.out.println("i : " + i);
				if(i%2==0) {
					System.out.println(denominator+"/"+numerator);
					break;					
				}else {
					System.out.println(numerator+"/"+denominator);
					break;
				}
			}
			
			i++;
		}
		
	}
}
