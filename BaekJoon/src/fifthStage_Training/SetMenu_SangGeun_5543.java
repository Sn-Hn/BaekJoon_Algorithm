package fifthStage_Training;

import java.util.Scanner;

public class SetMenu_SangGeun_5543 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		int burger[] = new int[3];
//		int Cola[] = new int[2];
		int burgerCola[] = new int[5];
		int setMenuPrice = 0;
		for(int i = 0; i < 5; i++) {
			burgerCola[i] = scan.nextInt();
		}
		int burgerSmallPrice = burgerCola[0];
		int colaSmallPrice = burgerCola[3];
		for(int i = 1; i < 3; i++) {
			if(burgerSmallPrice > burgerCola[i]) {
				burgerSmallPrice = burgerCola[i];
			}
		}
		if(colaSmallPrice > burgerCola[4]) {
			colaSmallPrice = burgerCola[4];
		}
		
		setMenuPrice = burgerSmallPrice + colaSmallPrice - 50;
		System.out.println(setMenuPrice);
		
		
	}
}
