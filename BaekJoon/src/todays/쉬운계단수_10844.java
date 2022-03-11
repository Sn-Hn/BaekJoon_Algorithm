package todays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 쉬운계단수_10844 {
  private static final int MOD = 1_000_000_000;

  private static int[][] dp;

  private static Long solveEasyStairNumber(int digits, int[][] dp) {
    for (int i = 2; i <= digits; i ++) {
      for (int j = 0; j < 10; j ++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j + 1] % MOD ;
          continue;
        }

        if (j == 9) {
          dp[i][j] = dp[i - 1][j - 1] % MOD;
          continue;
        }

        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
      }
    }

    return getResult(digits);
  }

  private static long getResult(int digits) {
    Long result = 0L;
    for (int i = 0; i < 10; i ++) {
      result += dp[digits][i];
    }

    return result % MOD;
  }

  private static void initSolution(int digits) {
    dp = new int[digits + 1][10];
    Arrays.fill(dp[1], 1);
    dp[1][0] = 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int digits = Integer.parseInt(br.readLine());
    initSolution(digits);

    System.out.println(solveEasyStairNumber(digits, dp));

    br.close();
  }
}