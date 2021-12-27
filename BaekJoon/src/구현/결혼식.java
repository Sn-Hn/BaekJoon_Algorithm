package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 결혼식 {
	
	private static int N;
	private static int M;
	private static boolean[][] checkedFriend;
	private static boolean[] results;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		checkedFriend = new boolean[N + 1][N + 1];
		results = new boolean[N + 1];
		
		StringTokenizer st;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			checkedFriend[a][b] = true;
			checkedFriend[b][a] = true;
		}
		
		for (int i= 2; i <= N; i++) {
			if (checkedFriend[1][i]) {
				results[i] = true;
				for (int j = 2; j <= N; j++) {
					if (checkedFriend[i][j]) {
						results[j] = true;
					}
				}
			}
		}
		
		int sum = 0;
		
		for (int i = 1; i <= N; i++) {
			if (results[i]) {
				sum ++;
			}
		}
		
		System.out.println(sum);
		
		br.close();
	}
}
