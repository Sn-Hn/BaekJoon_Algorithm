package eighth_string;

import java.util.Scanner;

public class Dial_5622 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
				'U', 'V', 'W', 'X', 'Y', 'Z'};
		int num = 0;
		int sum = 0;
		char ch = ' ';
		for(int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			for(int j = 0; j < alphabet.length; j++) {
				if(ch == alphabet[j]) {
					num = j;
				}
			}
			if(num >= 18) {
				num--;
			}
			if(num >= 24) {
				num--;
			}
			
			num = num/3+2;		// 문자에 따른 다이얼 넘버
			num++;
			sum += num;
		}
		
		System.out.println(sum);
	}
}
