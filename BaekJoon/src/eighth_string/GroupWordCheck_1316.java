package eighth_string;

import java.util.Scanner;

public class GroupWordCheck_1316 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cnt = 0;
		boolean flag = false;
		for(int i = 0; i < n; i++) {
			String word = scan.next();
			char ch = word.charAt(0);
			for(int j = 0; j < word.length(); j++) {
				if(ch != word.charAt(j)) {
					for(int k = j+1; k < word.length(); k++) {
						if(ch == word.charAt(k)) {
							flag = false;
							break;
						}else {
							flag = true;
						}
					}
					if(!flag) {
						break;
					}
				}else {
					flag = true;
				}
				ch = word.charAt(j);
			}
			if(flag) {
				System.out.println(word);
				cnt++;				
			}
		}
		
		System.out.println(cnt);
	}
}
