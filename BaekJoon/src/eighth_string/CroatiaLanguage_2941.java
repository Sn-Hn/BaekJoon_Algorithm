package eighth_string;

import java.util.Scanner;

public class CroatiaLanguage_2941 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String croatia[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String lang = scan.nextLine();
		String str = lang;
		
		for(int i = 0; i < croatia.length; i++) {
			str = str.replaceAll(croatia[i], "a");
		}
		System.out.println(str.length());
	}
}
