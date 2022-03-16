package eighth_string;

import java.util.Scanner;

public class ASCII_CODE_11654 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char ch = str.charAt(0);
		int ascii = ch-0;
		
		System.out.println(ascii);
	}
}
