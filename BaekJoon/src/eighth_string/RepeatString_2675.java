package eighth_string;

import java.util.Scanner;

public class RepeatString_2675 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String repeatStr = "";
		
		for(int i = 0; i < n; i++) {
			int cnt = scan.nextInt();
			String str = scan.next();
			
			for(int j = 0; j < str.length(); j++) {
				for(int k = 0; k < cnt; k++) {
					repeatStr += str.charAt(j);
				}
			}
			
			System.out.println(repeatStr);
			repeatStr = "";
			
		}
		
	}
}
