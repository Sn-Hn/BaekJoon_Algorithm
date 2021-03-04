package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

정수 삼각형 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	42365	25080	18583	59.193%
문제
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 
아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

입력
첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.

출력
첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.

예제 입력 1 
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
예제 출력 1 
30

*/

public class 정수삼각형_1932 {
	private static int N;
	private static int arr[][];
	private static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		
		br.close();
	}
	
	private static void solve() {		
		dp[1][1] = arr[1][1];
		for(int i = 2; i <= N; i++) {
			dp[i][1] = dp[i-1][1] + arr[i][1];
			dp[i][i] = dp[i-1][i-1] + arr[i][i];
		}
		
		for(int i = 3; i <= N; i++) {
			for(int j = 2; j <= i; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
			}
		}
		
		int max = dp[N][1];
		for(int i = 2; i <= N; i++) {
			max = Math.max(dp[N][i], max);
		}
		
		System.out.println(max);
		
	}
}
