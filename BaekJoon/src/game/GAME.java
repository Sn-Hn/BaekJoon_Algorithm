package game;

import java.util.Random;
import java.util.Scanner;

public class GAME {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String menu = scan.nextLine();
		String[] me = menu.split(" ");
		Random random = new Random();
		int ran = random.nextInt(me.length);
		
		System.out.println(me[ran]);
		
		
		
		
	}
}
