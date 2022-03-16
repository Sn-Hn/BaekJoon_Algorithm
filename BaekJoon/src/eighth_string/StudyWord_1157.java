package eighth_string;

import java.util.Scanner;

public class StudyWord_1157 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int arr[] = new int[26];
		int n = 0;
		int cnt = 0;
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
				'u','v', 'w', 'x', 'y', 'z'};
		
		
		str = str.toLowerCase();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			for(int j = 0; j < alphabet.length; j++) {
				if(ch == alphabet[j]) {
					arr[j]++;
				}
			}
		}
		
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				n = i;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(max == arr[i]) {
				cnt++;
			}
		}
		
		if(cnt >= 2) {
			System.out.println("?");
		}else {
			System.out.println(Character.toUpperCase(alphabet[n]));
		}
	}
}
