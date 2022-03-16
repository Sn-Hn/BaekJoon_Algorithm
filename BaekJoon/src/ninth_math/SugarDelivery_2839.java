package ninth_math;

import java.util.ArrayList;
import java.util.Scanner;

public class SugarDelivery_2839 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int kilogram = scan.nextInt();
		int n3 = kilogram/3;
		int n5 = kilogram/5;
		ArrayList<Integer> bagcnt = new ArrayList<>();
		for(int i = 0; i <= n3; i++) {
			for(int j = 0; j <= n5; j++) {
				if((3*i)+(5*j) == kilogram) {
					bagcnt.add(i+j);
				}
			}
		}
		bagcnt.sort(null);
		
		if(bagcnt.size() == 0) {
			System.out.println("-1");
		}else {
			System.out.println(bagcnt.get(0));			
		}
	}
}
