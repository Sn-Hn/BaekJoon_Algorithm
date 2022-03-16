package thirdStage_for;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Smaller_X {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamReader(System.out));
//		StringTokenizer st;
//		
//		int N = Integer.parseInt(br.readLine());
//		int X = Integer.parseInt(br.readLine());
//		int A[] = new int[N];
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			A[i] = Integer.parseInt(st.nextToken());
//			if(A[i] < X) {
//				list.add(A[i]);
//			}
//		}
//		
//		System.out.println(list);
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int X = scan.nextInt();
		int A[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		
		for(int a : A) {
			if(a < X) {
				System.out.print(a + " ");
			}
		}
		
		
		
	}
}
