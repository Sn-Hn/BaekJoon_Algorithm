package eighth_string;

import java.util.Scanner;

public class CompareNumber_Reverse_2908 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		StringBuffer sb = new StringBuffer();
		sb.append(Integer.toString(a));
		sb.reverse();
		
		a = Integer.parseInt(sb.toString());
		sb.delete(0, sb.length());
		sb.append(Integer.toString(b));
		sb.reverse();
		
		b = Integer.parseInt(sb.toString());
		
		if(a > b) System.out.println(a);
		else System.out.println(b);
		
	}
}
