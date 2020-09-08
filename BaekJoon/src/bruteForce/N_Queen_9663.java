package bruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*	골드 5

N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

첫째 줄에 N이 주어진다. (1 ≤ N < 15)

첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

*/

public class N_Queen_9663 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] arr = new int[n][n];
		List<Integer> list = new ArrayList<Integer>();
		int[] result = new int[n];
		boolean flag = false;
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		permutation(list, result, 0, n, n);
	}

	private static void permutation(List<Integer> list, int[] result, int depth, int n, int r) {
		if(depth == r) {
			return;
		}
		
		for(int i = 0; i < n-depth; i++) {
			result[depth] = list.remove(i);
			permutation(list, result, depth+1, n, r);
			list.add(i, result[depth]);
		}
	}
}
