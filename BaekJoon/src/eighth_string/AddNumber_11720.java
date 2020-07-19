package eighth_string;

import java.util.Scanner;

public class AddNumber_11720 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String str = scan.nextLine();
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			sum += Character.getNumericValue(str.charAt(i));
		}
		
		System.out.println(sum);
		
	}
}
