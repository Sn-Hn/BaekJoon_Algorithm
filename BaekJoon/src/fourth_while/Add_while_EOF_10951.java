package fourth_while;

import java.util.Scanner;

public class Add_while_EOF_10951 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextInt()) {		// EOF 개념
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			System.out.println(a+b);
		}
	}
}
