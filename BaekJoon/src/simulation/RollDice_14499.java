package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

주사위 굴리기 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	24360	10255	7192	41.594%
문제
크기가 N×M인 지도가 존재한다. 지도의 오른쪽은 동쪽, 위쪽은 북쪽이다. 
이 지도의 위에 주사위가 하나 놓여져 있으며, 주사위의 전개도는 아래와 같다. 
지도의 좌표는 (r, c)로 나타내며, r는 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로부터 떨어진 칸의 개수이다. 

  2
4 1 3
  5
  6
주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 
놓여져 있는 곳의 좌표는 (x, y) 이다. 
가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.

지도의 각 칸에는 정수가 하나씩 쓰여져 있다. 
주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 
0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.

주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때,
 주사위가 이동했을 때 마다 상단에 쓰여 있는 값을 구하는 프로그램을 작성하시오.

주사위는 지도의 바깥으로 이동시킬 수 없다. 
만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.

입력
첫째 줄에 지도의 세로 크기 N, 가로 크기 M (1 ≤ N, M ≤ 20), 
주사위를 놓은 곳의 좌표 x y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1), 
그리고 명령의 개수 K (1 ≤ K ≤ 1,000)가 주어진다.

둘째 줄부터 N개의 줄에 지도에 쓰여 있는 수가 북쪽부터 남쪽으로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 
주사위를 놓은 칸에 쓰여 있는 수는 항상 0이다. 
지도의 각 칸에 쓰여 있는 수는 10을 넘지 않는 자연수 또는 0이다.

마지막 줄에는 이동하는 명령이 순서대로 주어진다. 
동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.

출력
이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력한다. 
만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.

예제 입력 1 
4 2 0 0 8
0 2
3 4
5 6
7 8
4 4 4 1 3 3 3 2
예제 출력 1 
0
0
3
0
0
8
6
3
예제 입력 2 
3 3 1 1 9
1 2 3
4 0 5
6 7 8
1 3 2 2 4 4 1 1 3
예제 출력 2 
0
0
0
3
0
1
0
6
0
예제 입력 3 
2 2 0 0 16
0 2
3 4
4 4 4 4 1 1 1 1 3 3 3 3 2 2 2 2
예제 출력 3 
0
0
0
0
예제 입력 4 
3 3 0 0 16
0 1 2
3 4 5
6 7 8
4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2
예제 출력 4 
0
0
0
6
0
8
0
2
0
8
0
2
0
8
0
2

*/


// 출처 : https://bcp0109.tistory.com/12

// 혼자 생각하다 이 방법이 떠올랐는데 아무리 생각해도 아닌 거 같아 구글검색을 해봤더니
// 이게 맞다

// 힌트만 얻고 혼자 푸려다가 코드가 너무 깔끔해 보여서 따라 씀

// 이 분 코드로 초기값 클래스로 설정하는 것을 다시 한번배우고 이렇게 써야겠다는 마음이 들었다.

public class RollDice_14499 {
	
	static class Dice {
		int top, bottom, left, right, front, back;
		
		// 생성자를 통해 초기 주사위 값을 0으로 만듬
		public Dice() {
			// TODO Auto-generated constructor stub
			this.top = 0;
			this.bottom = 0;
			this.left = 0;
			this.right = 0;
			this.front = 0;
			this.back = 0;
		}
		
		// 남쪽으로 주사위 굴림
		public void moveSouth() {
			int temp = top;
			top = back;
			back = bottom;
			bottom = front;
			front = temp;
		}
		
		// 북쪽으로 주사위 굴림
		public void moveNorth() {
			int temp = top;
			top = front;
			front = bottom;
			bottom = back;
			back = temp;
		}
		
		// 동쪽으로 주사위 굴림
		public void moveEast() {
			int temp = top;
			top = left;
			left = bottom;
			bottom = right;
			right = temp;
		}
		
		// 서쪽으로 주사위 굴림
		public void moveWest() {
			int temp = top;
			top = right;
			right = bottom;
			bottom = left;
			left = temp;
		}
		
		public void printTopNumber() {
			System.out.println(top);
		}
		
	}
	
	private static int N, M, x, y, K;
	private static int map[][];
	private static int order[];
	
	// 이동 명령      order    :	     동   서   북   남
//	private static int dx[] = {1, -1, 0, 0};
//	private static int dy[] = {0, 0, -1, 1};
	
	private static int dx[] = {0, 0, -1, 1};
	private static int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		// 지도 세로 길이
		M = Integer.parseInt(st.nextToken());		// 지도 가로 길이
		
		x = Integer.parseInt(st.nextToken());		// 주사위 x좌표
		y = Integer.parseInt(st.nextToken());		// 주사위 y좌표
		
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		order = new int[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		// 동쪽 1, 서쪽 2, 북쪽 3, 남쪽 4
		for(int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		rollDice();
		
		br.close();
	}
	
	private static void rollDice() {
		Dice dice = new Dice();
		
		for(int i = 0; i < K; i++) {
			// order : 명령 순서
			int X = x + dx[order[i]-1];
			int Y = y + dy[order[i]-1];
			
			if(X >= 0 && X < N && Y >= 0 && Y < M) {
				// 동쪽으로 굴림
				if(order[i] == 1) {
					dice.moveEast();
				}else if(order[i] == 2) {
					dice.moveWest();
				}else if(order[i] == 3) {
					dice.moveNorth();
				}else {
					dice.moveSouth();
				}
				
				// 바닥이 0이면
				if(map[X][Y] == 0) {
					map[X][Y] = dice.bottom;
				// 0이 아니면
				}else {
					dice.bottom = map[X][Y];
					map[X][Y] = 0;
				}
				
				dice.printTopNumber();
				
				x = X;
				y = Y;
			}
			
		}
		
	}
}
