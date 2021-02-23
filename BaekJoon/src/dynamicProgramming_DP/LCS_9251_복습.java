package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCS_9251_복습 {
	private static int dp[][];
	private static String a = "";
	private static String b = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();
		dp = new int[a.length()+1][b.length()+1];
		
		// Bottom-Up
		for(int i = 1; i <= a.length(); i++) {
			for(int j = 1; j <= b.length(); j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[a.length()][b.length()]);
		
		for(int i = 0; i <= a.length(); i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(dp(a.length(), b.length()));
		
		br.close();
	}
	
	// Top-Down
	private static int dp(int x, int y) {
		if(x <= 0 || y <= 0) {
			return 0;
		}
		
		if(dp[x][y] == -1) {
			dp[x][y] = 0;
			if(a.charAt(x-1) == b.charAt(y-1)) dp[x][y] = dp(x-1, y-1) + 1;
			else dp[x][y] = Math.max(dp(x-1, y), dp(x, y-1));			
		}
		
		return dp[x][y];
	}
}
