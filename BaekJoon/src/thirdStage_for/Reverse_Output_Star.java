package thirdStage_for;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Reverse_Output_Star {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		int num = Integer.parseInt(br.readLine());
		
		
		
		new Reverse_Output_Star().outStar();
		
	}
	
	public void outStar() {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= num; j++) {
				if(j > num-i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
}
