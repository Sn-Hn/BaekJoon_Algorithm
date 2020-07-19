package eighth_string;

import java.util.Scanner;

public class WordCount_1152 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String[] st = str.split(" ");
		int length = st.length;
		if(length == 0) {
			System.out.println("0");
			
		}else {
			
			if("".equals(st[0])) {
				System.out.println(length-1);
			}else {
				System.out.println(length);
			}
		}
		
		
	}
}
