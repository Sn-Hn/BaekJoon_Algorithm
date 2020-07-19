package fourth_while;

import java.util.Scanner;

public class Add_Cycle_1110 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String newN;
		int N = n;
		int num = 0;
		int cnt = 0;
		
		while(true) {
			if(N < 10) {
				num = N;
				
				newN = Integer.toString(N) + 
						Integer.toString(num);
				
			}else {
				String str = Integer.toString(N);
				num = Character.getNumericValue(str.charAt(0)) + Character.getNumericValue(str.charAt(1));
				if(num >= 10) {
					newN = Character.toString(Integer.toString(N).charAt(1)) + 
							Character.toString(Integer.toString(num).charAt(1));	
				}else {
					newN = Character.toString(Integer.toString(N).charAt(1)) + Integer.toString(num);
				}
			}
			cnt++;
			
			N = Integer.parseInt(newN);
			if(n == N) {
				break;
			}
		}
		System.out.println(cnt);
		
	}
}
