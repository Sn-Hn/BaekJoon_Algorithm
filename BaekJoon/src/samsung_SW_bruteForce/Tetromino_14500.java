package samsung_SW_bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

테트로미노 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	34083	12469	7998	34.350%
문제
폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

정사각형은 서로 겹치면 안 된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.



아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 
종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

입력
첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. 
i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 
입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.

예제 입력 1 
5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1
예제 출력 1 
19
예제 입력 2 
4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
예제 출력 2 
20
예제 입력 3 
4 10
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
예제 출력 3 
7

*/

public class Tetromino_14500 {
	private static int N, M;
	private static int map[][];
	private static boolean visited[][];
	private static int max = Integer.MIN_VALUE;
	private static int sum = 0;
	private static int dx[] = {1, -1, 0, 0};
	private static int dy[] = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				sum = map[i][j];
				tetromino(i, j, 1);
				visited[i][j] = false;
				
				exceptionCase(i, j);
			}
		}
		
		System.out.println(max);
		
		br.close();
	}
	
	private static void tetromino(int x, int y, int depth) {
		if(depth == 4) {
			max = Math.max(max, sum);
			
			return;
		}
		for(int i = 0; i < 4; i++) {
			int X = x + dx[i];
			int Y = y + dy[i];
			
			if(X >= 0 && X < N && Y >= 0 && Y < M && !visited[X][Y]) {
				visited[X][Y] = true;
				sum += map[X][Y];
				tetromino(X, Y, depth+1);
				sum -= map[X][Y];
				visited[X][Y] = false;
			}
		}
	}
	
	// https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-14500-%ED%85%8C%ED%8A%B8%EB%A1%9C%EB%AF%B8%EB%85%B8
	// 예외처리에 대한 정리가 잘 되어있다. 예외처리 생각이 잘 나지 않아 검색함
	// ㅗ, ㅏ, ㅓ, ㅜ 모양은 예외로 처리해주어야 한다. 깊이가 3이기 때문
	private static void exceptionCase(int x, int y) {
		int answer = 0;
		if(x >= 0 && x+1 < N && y >= 0 && y+2 < M){
			answer = map[x][y] + map[x][y+1] + map[x][y+2] + map[x+1][y+1];
	        max = Math.max(max, answer);
	    }

	    // 2. ㅏ
	    if(x >= 0 && x+2 < N && y >= 0 && y+1 < M){
	    	answer = map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y+1];
	        max = Math.max(max, answer);
	    }

	    // 3. ㅗ
	    if(x-1 >= 0&& x < N && y >= 0 && y+2 < M){
	    	answer = map[x][y] + map[x][y+1] + map[x][y+2] + map[x-1][y+1];
	        max = Math.max(max, answer);
	    }

	    // 4. ㅓ
	    if(x-1 >= 0 && x+1 < N && y >= 0 && y+1 < M){
	    	answer = map[x][y] + map[x][y+1] + map[x-1][y+1] + map[x+1][y+1];
	        max = Math.max(max, answer);
	    }
	}
	
}
