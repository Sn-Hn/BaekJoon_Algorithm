package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 평범한배낭_12865_복습 {
	private static int N, K;
	private static int w[];
	private static int v[];
	private static int dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		w = new int[N+1];
		v = new int[N+1];
		dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		// Bottom-Up
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				// 무게가 들어갈 공간보다 크므로 이전의 물품이 들어갔을 때로 변경한다.
				if(w[i] > j) {
					dp[i][j] = dp[i-1][j];
				// 무게가 들어갈 공간보다 작다면 현재의 물품이 들어갈 수 있다.
				}else {					// 이전 물품 ,   자신을 뺀 가치 + 자신의 가치
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(dp(N, K));
		br.close();
	}
	
	// Top-Down
	private static int dp(int i, int k) {
		if(i < 0) {
			return 0;
		}
		
		if(dp[i][k] == -1) {
			if(w[i] > k) {
				dp[i][k] = dp(i-1, k);
			}else {
				dp[i][k] = Math.max(dp(i-1, k), dp(i-1, k-w[i]) + v[i]);
			}
		}
		
		return dp[i][k];
	}
}
