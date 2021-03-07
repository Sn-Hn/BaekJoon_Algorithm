package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합_1912 {
	private static int N;
	private static int arr[];
	private static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		Arrays.fill(dp, -1000000000);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i+1] = Integer.parseInt(st.nextToken());
		}
		dp[N] = arr[N];
		int max = Integer.MIN_VALUE;
		for(int i = N-1; i > 0; i--) {
			dp[i] = Math.max(arr[i], dp[i+1] + arr[i]);
			max = Math.max(max, dp[i]);
		}
		
		max = Math.max(max, dp[N]);
		
		if(N == 1) {
			System.out.println(arr[N]);
		}else {
			System.out.println(max);
		}

		br.close();
	}
}
