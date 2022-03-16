package fourth_while;

import java.util.Scanner;

public class OXQuiz_8958 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String OX[] = new String[n];
		char ch;
		int score = 0;
		int sumScore = 0;
		
		for(int i = 0; i < n; i++) {
			OX[i] = scan.nextLine();
			for(int j = 0; j < OX[i].length(); j++) {
				if(OX[i].charAt(j) == 'O') {
					score++;
					sumScore += score;
				}else {
					score = 0;
				}
			}
			System.out.println(sumScore);
			score = 0;
			sumScore = 0;
		}
		
		
	}
}
