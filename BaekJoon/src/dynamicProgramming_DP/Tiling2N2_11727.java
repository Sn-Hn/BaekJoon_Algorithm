package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

문제
2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×17 직사각형을 채운 한가지 예이다.

입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

예제 입력 1 
2
예제 출력 1 
3
예제 입력 2 
8
예제 출력 2 
171
예제 입력 3 
12
예제 출력 3 
2731


*/


// 점화식 세우기 (중요) dp(n) = dp(n-1) + 2*dp(n-2)
public class Tiling2N2_11727 {
	private static int dp[];
	private static int dp(int n) {
		if(n == 1) return 1;		// 타일이 n-1일 때 경우의 수는 1가지
		if(n == 2) return 3;		// 타일이 n-2일 때 경우의 수는 3가지
		if(dp[n] != 0) return dp[n];
		
		// n-1일 떄 경우의 수는 한 가지, n-2일 때 경우의 수는 3가지이지만 한 경우가 n-1 경우에 포함되므로 2가지
		// 따라서 점화식은 dp(n) = dp(n-1) + 2*dp(n-2) 이렇게 된다
		return dp[n] = (dp(n-1) + 2*dp(n-2))%10007;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		System.out.println(dp(n));
		
		br.close();
	}
}
