package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

쉬운 계단 수 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	75633	23024	16529	28.491%
문제
45656이란 수를 보자.

이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.

세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.

예제 입력 1 
1
예제 출력 1 
9
예제 입력 2 
2
예제 출력 2 
17

*/

public class 쉬운계단수_10844 {
	private static int N;
	private static long dp[][];
	private static int mod = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N+1][10];
		
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					dp[i][0] = dp[i - 1][1] % mod;
				}
				
				else if(j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		
		long answer = 0;
		for(int i = 0; i < 10; i++) {
			answer += dp[N][i];
		}
		
		System.out.println(answer % mod);
		
		br.close();
	}
}
