package bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*

N개의 정수로 이루어진 배열 A가 주어진다. 
이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 
둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 
배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.

첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.

*/

// 순열 문제
public class MaximumDifference_10819 {
	private static int maxSum = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Integer> arr = new ArrayList<Integer>();
		int[] result = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr.add(scan.nextInt());
		}
		
		permutation(arr, result, 0, n, n);
		System.out.println(maxSum);
		
	}
	
	private static void permutation(List<Integer> arr, int[] result, int depth, int n, int r) {
		if(depth == r) {
			sum(result, n);
			return;
		}
		
		for(int i = 0; i < n-depth; i++ ) {
			result[depth] = arr.remove(i);
			permutation(arr, result, depth+1, n, r);
			arr.add(i, result[depth]);
		}
	}
	
	private static void sum(int[] result, int n) {
		int sum = 0;
		for(int i = 0; i < n-1; i++) {
			sum += Math.abs(result[i] - result[i+1]);
		}
		if(sum > maxSum) maxSum = sum;
	}
}
