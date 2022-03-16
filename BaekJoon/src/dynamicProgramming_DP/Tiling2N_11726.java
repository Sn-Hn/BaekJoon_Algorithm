package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

문제
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

예제 입력 1 
2
예제 출력 1 
2
예제 입력 2 
9
예제 출력 2 
55

*/

// DP 문제는 규칙성을 찾아 점화식을 세우는 것이 제일 중요!!!!!
public class Tiling2N_11726 {
	private static int[] dp;
	
	private static int dp(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(dp[n] != 0) return dp[n];
		
		// 점화식
		return dp[n] = dp(n-1) + dp(n-2);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		System.out.println(dp(n)%10007);
		
		br.close();
	}
}
