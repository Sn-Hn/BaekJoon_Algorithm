package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*

뱀 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	28684	10802	7149	36.070%
문제
 'Dummy' 라는 도스게임이 있다. 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 
 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.

게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 
보드의 상하좌우 끝에 벽이 있다. 
게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.

뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.

먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.

입력
첫째 줄에 보드의 크기 N이 주어진다. (2 ≤ N ≤ 100) 다음 줄에 사과의 개수 K가 주어진다. (0 ≤ K ≤ 100)

다음 K개의 줄에는 사과의 위치가 주어지는데, 첫 번째 정수는 행, 두 번째 정수는 열 위치를 의미한다. 
사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.

다음 줄에는 뱀의 방향 변환 횟수 L 이 주어진다. (1 ≤ L ≤ 100)

다음 L개의 줄에는 뱀의 방향 변환 정보가 주어지는데, 정수 X와 문자 C로 이루어져 있으며. 
게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다는 뜻이다. 
X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.

출력
첫째 줄에 게임이 몇 초에 끝나는지 출력한다.

예제 입력 1 
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D
예제 출력 1 
9
예제 입력 2 
10
4
1 2
1 3
1 4
1 5
4
8 D
10 D
11 D
13 L
예제 출력 2 
21
예제 입력 3 
10
5
1 5
1 3
1 2
1 6
1 7
4
8 D
10 D
11 D
13 L
예제 출력 3 
13



*/

public class Snake_3190 {
	private static int N, appleCount, L;
	private static int map[][];
	private static int index = 0;
	private static int count = 0;
	private static List<Pair> turnList = new ArrayList<>();
	private static Queue<Snake> snake = new LinkedList<>();
	
	// 0 : 오른쪽, 1 : 아래쪽, 2 : 왼쪽, 3 : 위쪽
	private static int dx[] = {0, 1, 0, -1};
	private static int dy[] = {1, 0, -1, 0};
	
	static class Snake {
		int x, y;
		
		public Snake(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Pair {
		int x;
		String turn;
		
		public Pair(int x, String turn) {
			this.x = x;
			this.turn = turn;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		appleCount = Integer.parseInt(br.readLine());
		
		
		// 빈 칸 : 0
		// 뱀 : 3
		for(int i = 0; i < appleCount; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			// 사과 : 2
			map[row][col] = 2;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String t = st.nextToken();
			
			turnList.add(new Pair(time, t));
		}
		
		turnList.add(new Pair(10001, "X"));
		snake.add(new Snake(1, 1));
		turn(1, 1);
		
//		System.out.println();
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.println(count);
		
		br.close();
	}
	
	private static void turn(int x, int y) {
		int time = 0;
		for(Pair pair : turnList) {
			for(int i = time; i < pair.x; i++) {
				int X = x + dx[index];
				int Y = y + dy[index];
				count++;
				
				// 벽에 닿으면 안되기 떄문에
				if(X > 0 && X <= N && Y > 0 && Y <= N) {
					if(map[X][Y] == 0) {
//						System.out.println("X : " + X + ", Y : " + Y);
						snake.add(new Snake(X, Y));
						Snake s = snake.poll();
						map[X][Y] = 3;
						map[s.x][s.y] = 0;
						
						x = X;
						y = Y;
					}else if(map[X][Y] == 2) {
						map[X][Y] = 3;
						snake.add(new Snake(X, Y));
						
						x = X;
						y = Y;
					}else {
						return;
					}
				}else {
					return;
				}
			}
			if(pair.turn.equals("D")) {
				index = (index+1)%4;
			}else if(pair.turn.equals("L")) {
				index = (index+3)%4;
			}else {
				return;
			}
			time = pair.x;
		}
		
	}
}
