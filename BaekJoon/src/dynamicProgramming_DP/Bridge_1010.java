package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

문제
재원이는 한 도시의 시장이 되었다. 
이 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다. 
하지만 재원이는 다리가 없어서 시민들이 강을 건너는데 큰 불편을 겪고 있음을 알고 다리를 짓기로 결심하였다. 
강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 한다. 
재원이는 강 주변을 면밀히 조사해 본 결과 강의 서쪽에는 N개의 사이트가 있고 동쪽에는 M개의 사이트가 있다는 것을 알았다. (N ≤ M)

재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다. 
(이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.) 
재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다. 
다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.

입력
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
그 다음 줄부터 각각의 테스트케이스에 대해 강의 서쪽과 동쪽에 있는 사이트의 개수 정수 N, M (0 < N ≤ M < 30)이 주어진다.

출력
각 테스트 케이스에 대해 주어진 조건하에 다리를 지을 수 있는 경우의 수를 출력한다.

예제 입력 1 
3
2 2
1 5
13 29

예제 출력 1 
1
5
67863915


*/

// 조합 경우의 수 nCr = n! / (n-r)! * r!
public class Bridge_1010 {
	private static int[][] dp;

	public static void combination(int r, int n) {
		// nCr
		long cnt = 1;
		int max = r;
		int min = n - r;
		if (n == r || r == 0) {
			System.out.println(cnt);
		}
		if (n - r > max) {
			max = n - r;
			min = r;
		}

		for (int j = max + 1; j <= n; j++) {
			cnt *= j;
		}

		for (int j = 1; j <= min; j++) {
			cnt /= j;
		}

		System.out.println(cnt);
	}

	public static void dp1(int r, int n) {
		for (int i = 1; i <= n; i++) {
			dp[1][i] = i;
		}
		for (int i = 2; i <= r; i++) {
			for (int j = i; j <= n; j++) {
				if (i == j) {
					dp[i][j] = 1;
				} else if (j - i == 1) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j - 2];
				} else {
					for (int t = j - 1; t > i - 2; t--) {
						dp[i][j] += dp[i - 1][t];
					}
				}
			}
		}
		System.out.println(dp[r][n]);

	}
	
	private static void dp2(int r, int n) {
		for(int i=2;i<=r;i++)
			dp[i][1]=0;
		
		for(int i=1;i<=n;i++)
			dp[1][i]=i;
		
		// 점화식
		for(int x=2;x<=r;x++) {
			for(int y=2;y<=n;y++) {
				dp[x][y]=dp[x][y-1]+dp[x-1][y-1];
			}
		}
		System.out.println(dp[r][n]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			dp = new int[r + 1][n + 1];

//			combination(r, n);
//			dp1(r, n);	// 삼중 for문이라 아쉽
			dp2(r, n);
		}

		br.close();
	}
}
