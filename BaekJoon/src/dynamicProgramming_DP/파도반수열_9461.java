package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

파도반 수열 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	41515	17275	14246	40.242%
문제
오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 
첫 삼각형은 정삼각형으로 변의 길이는 1이다. 
그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 
나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.

파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. 
P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.

N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)

출력
각 테스트 케이스마다 P(N)을 출력한다.

예제 입력 1 
2
6
12
예제 출력 1 
3
16

*/

public class 파도반수열_9461 {
	private static int T;
	private static long dp[] = new long[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		int N = 0;
		
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(dp(N));
		}
		
		br.close();
	}
	
	private static long dp(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 1;
		if(n == 3) return 1;
		if(n == 4) return 2;
		if(n == 5) return 2;
		if(dp[n] != 0) return dp[n];
		
		return dp[n] = dp(n-1) + dp(n-5);
	}
}
