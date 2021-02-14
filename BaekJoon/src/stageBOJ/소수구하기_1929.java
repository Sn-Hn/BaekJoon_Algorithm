package stageBOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

소수 구하기 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	89247	25047	17779	27.310%
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1 
3 16
예제 출력 1 
3
5
7
11
13

*/

public class 소수구하기_1929 {
	private static int N, M;
	private static boolean isChecked[];
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		solution();
		
		br.close();
	}
	
	private static void solution() {
		isChecked = new boolean[1000001];
		isChecked[0] = isChecked[1] = false;
		for(int i = 2; i <= M; i++) {
			isChecked[i] = true;
		}
		
		for(int i = 2; i*i <= M; i++) {
			for(int j = i*i; j <= M; j+=i) {
				isChecked[j] = false;
			}
		}
		
		for(int i = N; i <= M; i++) {
			if(isChecked[i]) sb.append(i + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
