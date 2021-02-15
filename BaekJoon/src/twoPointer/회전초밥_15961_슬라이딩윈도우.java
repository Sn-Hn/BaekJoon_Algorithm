package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전초밥_15961_슬라이딩윈도우 {
	private static int N, d, k, c;
	private static int arr[];
	private static int visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new int[d+1];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(solve());
		
		br.close();
	}
	
	private static int solve() {
		int total = 0, max = 0;
		
		// 일단 k개를 먹는다.
		for(int i = 0; i < k; i++) {
			if(visited[arr[i]] == 0) {
				total++;
			}
			visited[arr[i]]++;
		}
		
		max = total;
		
		for(int i = 1; i < N; i++) {
			if(max <= total) {
				if(visited[c] == 0) {
					max = total + 1;
				}else {
					max = total;
				}
			}
				
			visited[arr[i-1]]--;
			if(visited[arr[i-1]] == 0) total--;
			
			// 회전하기때문에 N개를 넘어 k-1개까지 먹을 수 있다.
			if(visited[arr[(i+k-1) % N]] == 0) total++;
			visited[arr[(i+k-1) % N]]++;
		}
		
		return max;
		
	}
}
