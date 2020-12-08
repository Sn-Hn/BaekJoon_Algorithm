package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


/*

탈출 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	24896	8003	5479	30.960%
문제
사악한 암흑의 군주 이민혁은 드디어 마법 구슬을 손에 넣었고, 그 능력을 실험해보기 위해 근처의 티떱숲에 홍수를 일으키려고 한다. 
이 숲에는 고슴도치가 한 마리 살고 있다. 고슴도치는 제일 친한 친구인 비버의 굴로 가능한 빨리 도망가 홍수를 피하려고 한다.

티떱숲의 지도는 R행 C열로 이루어져 있다. 
비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 
비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.

매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다. 
(위, 아래, 오른쪽, 왼쪽) 물도 매 분마다 비어있는 칸으로 확장한다. 
물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 
물과 고슴도치는 돌을 통과할 수 없다. 또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.

티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.

고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 이동할 수 있으면 고슴도치가 물에 빠지기 때문이다. 

입력
첫째 줄에 50보다 작거나 같은 자연수 R과 C가 주어진다.

다음 R개 줄에는 티떱숲의 지도가 주어지며, 문제에서 설명한 문자만 주어진다. 'D'와 'S'는 하나씩만 주어진다.

출력
첫째 줄에 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간을 출력한다. 만약, 안전하게 비버의 굴로 이동할 수 없다면, "KAKTUS"를 출력한다.

예제 입력 1 
3 3
D.*
...
.S.
예제 출력 1 
3
예제 입력 2 
3 3
D.*
...
..S
예제 출력 2 
KAKTUS
예제 입력 3 
3 6
D...*.
.X.X..
....S.
예제 출력 3 
6
예제 입력 4 
5 4
.D.*
....
..X.
S.*.
....
예제 출력 4 
4
예제 입력 5
3 3
S..
.D.
...
예제 출력 5
2
예제 입력 6 
5 5
.....
..XD.
..XXX
.S...
...*.
예제 출력 6 
4

*/

public class Escape_3055 {
	private static int R, C;
	private static String map[][];
	private static List<Pair> waterList = new ArrayList<Pair>();
	private static Pair hedgehogIndex;
	private static boolean visited[][];
	private static Pair safetyZone;
	
	private static int dx[] = {1, -1, 0, 0};
	private static int dy[] = {0, 0, 1, -1};
	
	private static class Pair {
		int x, y, depth;
		String s;
		public Pair(int x, int y, String s, int depth) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.depth = depth;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		// 고슴도치가 온 길을 다시 돌아가지 않게 하려고
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String nextToken = br.readLine();
			map[i] = nextToken.split("");
			for(int j = 0; j < C; j++) {
				if(map[i][j].equals("*")) {
					waterList.add(new Pair(i, j, map[i][j], 0));
				}else if(map[i][j].equals("S")) {
					hedgehogIndex = new Pair(i, j, map[i][j], 0);
				}else if(map[i][j].equals("D")) {
					safetyZone = new Pair(i, j, map[i][j], 0);
				}
			}
			
		}
		
		moveAndExpand();
		
		
		br.close();
	}

	
	private static void moveAndExpand() {
		Queue<Pair> q = new LinkedList<Pair>();
		int depth = 0;
		boolean flag = false;
		for(Pair p : waterList) {
			q.add(p);
		}
		q.add(hedgehogIndex);
		
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			if(pair.s.equals("*")) {
				for(int i = 0; i < 4; i++) {
					int X = pair.x + dx[i];
					int Y = pair.y + dy[i];
					
					if (X >= 0 && X < R && Y >= 0 && Y < C) {
						if(map[X][Y].equals(".") || map[X][Y].equals("S")) {
							map[X][Y] = "*";
							depth = pair.depth + 1;
							q.add(new Pair(X, Y, map[X][Y], depth));
						}
					}
				}
			}else if(pair.s.equals("S")) {
				visited[pair.x][pair.y] = true;
				map[pair.x][pair.y] = ".";
				for(int i = 0; i < 4; i++) {
					int X = pair.x + dx[i];
					int Y = pair.y + dy[i];
					
					// for문이 돌기 때문에 hedgehogIndex의 값은 정답이었다가 다시 바뀔 수 있다.
					// 그래서 if문을 for문 안쪽으로 넣어 같아지자마자 break
					if (X >= 0 && X < R && Y >= 0 && Y < C) {
						if((map[X][Y].equals(".") || map[X][Y].equals("D")) && !visited[X][Y]) {
							map[X][Y] = "S";
							visited[X][Y] = true;
							depth = pair.depth + 1;
							hedgehogIndex = new Pair(X, Y, "S", depth);
							if(safetyZone.x == hedgehogIndex.x && safetyZone.y == hedgehogIndex.y) {
								flag = true;
								System.out.println(depth);
								break;
							}else {
								flag = false;
							}
							q.add(new Pair(X, Y, map[X][Y], depth));
						}else {
							if(map[X][Y].equals("S")) {
								map[pair.x][pair.y] = ".";
							}
						}
					}
				}
			}
			if(flag) {
				break;
			}
		}
		
		if(!flag) {
			System.out.println("KAKTUS");
		}
		
		
	}
	
	
	
	private static void printMap() {
		for(int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			} 
			System.out.println();
		}
	}
}

