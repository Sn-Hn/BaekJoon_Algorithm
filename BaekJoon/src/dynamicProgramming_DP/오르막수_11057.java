package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

오르막 수 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	29275	14151	10891	47.155%
문제
오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.

입력
첫째 줄에 N (1 ≤ N ≤ 1,000)이 주어진다.

출력
첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.

예제 입력 1 
1
예제 출력 1 
10
예제 입력 2 
2
예제 출력 2 
55
예제 입력 3 
3
예제 출력 3 
220

*/

public class 오르막수_11057 {
	private static int N;
	private static int dp[][];
	private static int mod = 10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][10];
		// N = 1은 0 ~ 9
		int result = 0;
		
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					dp[i][k] += dp[i-1][j];
					dp[i][k] %= mod;
				}
			}
		}
		
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		
//		for(int i = 3; i <= N; i++) {
//			dp[i][1] = sum;
//			for(int j = 2; j < 10; j++) {
//				dp[i][j] = dp[i][j-1] - dp[i-1][j-1];
//				dp[i][j] %= mod;
//				sum += dp[i][j];
//			}
//		}
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j < 10; j++) {
//				result += dp[i][j]%mod;				
//			}
//		}
		
		System.out.println(result%mod);

		print();
		
		br.close();
	}
	
	private static void print() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
