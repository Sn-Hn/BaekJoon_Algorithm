package sixth_array;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_2562 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[9];
		int a[] = new int[9];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			a[i] = arr[i];
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[arr.length-1]);
		for(int i = 0; i < arr.length; i++) {
			if(arr[arr.length-1] == a[i]) {
				System.out.println(i+1);
			}
		}
		
		for(int i : a) {
			System.out.println(i);
		}
		
	}
}
