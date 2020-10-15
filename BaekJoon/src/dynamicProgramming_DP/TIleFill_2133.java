package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

문제
3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

입력
첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.

출력
첫째 줄에 경우의 수를 출력한다.

예제 입력 1 
2
예제 출력 1 
3

*/

public class TIleFill_2133 {
	private static int dp[];
	
	private static int dp(int n) {
		if(n == 0) return 1;
		if(n == 1) return 0;
		if(n == 2) return 3;
		if(dp[n] != 0) return dp[n];
		
		int result = 3*dp(n-2);
		
		for(int i = 4; i <= n; i+=2) {
			result += 2 * dp(n-i);
		}
		
		return dp[n] = result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		System.out.println(dp(n));
		
		br.close();
	}
}
