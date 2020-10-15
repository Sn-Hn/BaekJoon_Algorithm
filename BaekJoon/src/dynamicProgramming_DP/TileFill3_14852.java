package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

문제
2×N 크기의 벽을 2×1, 1×2, 1×1 크기의 타일로 채우는 경우의 수를 구해보자.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000,000)이 주어진다.

출력
첫째 줄에 경우의 수를 1,000,000,007로 나눈 나머지를 출력한다.

예제 입력 1 
1
예제 출력 1 
2
예제 입력 2 
2
예제 출력 2 
7
예제 입력 3 
3
예제 출력 3 
22


*/

// 시간 초과 (2차원 배열)
public class TileFill3_14852 {
	
	private static long dp[][];
	
	private static long dp(int n) {
		dp[0][0] = 0;
		dp[1][0] = 2;
		dp[2][0] = 7;
		dp[2][1] = 1;
		
		for(int i = 3; i <= n; i++) {
			dp[i][1] = (dp[i-3][0] + dp[i-1][1])%1000000007;
			dp[i][0] = (3*dp[i-2][0] + 2*dp[i-1][0] + 2*dp[i][1])%1000000007;
		}
		
		return dp[n][0];
	}
	
//	private static int dp(int n) {
//		if(n == 0) return 1;
//		if(n == 1) return 2;
//		if(n == 2) return 7;
//		
//		int result = 2*dp(n-1) + 3*dp(n-2);
//		
//		for(int i = 3; i <= n; i++) {
//			result += 2*dp(n-i);
//		}
//		
//		return dp[n] = result % 1000000007;
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new long[n+1][2];
		
		System.out.println(dp(n));
		
		
		br.close();
		
	}
}
