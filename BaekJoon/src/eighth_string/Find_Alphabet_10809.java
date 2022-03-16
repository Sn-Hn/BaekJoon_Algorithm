package eighth_string;

import java.util.Scanner;

public class Find_Alphabet_10809 {
	public static void main(String[] args) {
		int[] alphabetCount = new int[26];
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
				'u','v', 'w', 'x', 'y', 'z'};
		
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < alphabet.length; j++) {
				int index = str.indexOf(alphabet[j]);
				alphabetCount[j] = index;
			}
		}
		
		for(int i : alphabetCount) {
			System.out.print(i + " ");
		}
		
	}
}
