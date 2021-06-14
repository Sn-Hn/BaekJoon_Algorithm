package dynamicProgramming_DP;

// 최장 증가 수열
// 기본적인 DP를 이용한 것
public class LIS_DP {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 6, 9, 354, 7, 23, 652, 8, 4, 3213, 5, 3 };

		int[] dp = new int[arr.length];

		int[] result = lisDp(arr, dp);

		print(result);
	}

	private static int[] lisDp(int[] arr, int[] dp) {
		dp[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		return dp;
	}

	private static void print(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}