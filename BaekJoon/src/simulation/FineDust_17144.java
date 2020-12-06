package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

https://www.acmicpc.net/problem/17144

미세먼지 안녕! 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	512 MB	12167	6594	4286	53.289%
문제
미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다. 
공기청정기의 성능을 테스트하기 위해 구사과는 집을 크기가 R×C인 격자판으로 나타냈고, 1×1 크기의 칸으로 나눴다. 
구사과는 뛰어난 코딩 실력을 이용해 각 칸 (r, c)에 있는 미세먼지의 양을 실시간으로 모니터링하는 시스템을 개발했다. 
(r, c)는 r행 c열을 의미한다.



공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다. 
공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.

1초 동안 아래 적힌 일이 순서대로 일어난다.

미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
(r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
확산되는 양은 Ar,c/5이고 소수점은 버린다.
(r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
공기청정기가 작동한다.
공기청정기에서는 바람이 나온다.
위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
다음은 확산의 예시이다.



왼쪽과 오른쪽에 칸이 없기 때문에, 두 방향으로만 확산이 일어났다.



인접한 네 방향으로 모두 확산이 일어난다.



공기청정기가 있는 칸으로는 확산이 일어나지 않는다.

공기청정기의 바람은 다음과 같은 방향으로 순환한다.



방의 정보가 주어졌을 때, T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양을 구해보자.

입력
첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.

둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다. 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다. -1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.

출력
첫째 줄에 T초가 지난 후 구사과 방에 남아있는 미세먼지의 양을 출력한다.

예제 입력 1 
7 8 1
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
예제 출력 1 
188
미세먼지의 확산이 일어나면 다음과 같은 상태가 된다. 



공기청정기가 작동한 이후 상태는 아래와 같다.



예제 입력 2 
7 8 2
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
예제 출력 2 
188
예제 입력 3 
7 8 3
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
예제 출력 3 
186
예제 입력 4 
7 8 4
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
예제 출력 4 
178
예제 입력 5 
7 8 5
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
예제 출력 5 
172
예제 입력 6 
7 8 20
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
예제 출력 6 
71
예제 입력 7 
7 8 30
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
예제 출력 7 
52
예제 입력 8 
7 8 50
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
예제 출력 8 
46




*/

public class FineDust_17144 {
	private static int R, C, T;
	private static int map[][];
	private static int copyMap[][];
	
	private static int dx[] = {1, -1, 0, 0};
	private static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		copyMap = new int[R][C];
		
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copyMap[i][j] = map[i][j];
			}
		}
		
		int index = 0;
		while(index < T) {
			// 1초 후
			index++;
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					// 1번 조건
					diffusion(i, j);
				}
			}
			System.out.println();
			
			purify();
			mapCopy();
		}
		
		System.out.println(countFineDust());
		
		br.close();
	}
	
	private static void diffusion(int x, int y) {
		int index = 0;
		for(int i = 0; i < 4; i++) {
			int X = x + dx[i];
			int Y = y + dy[i];
			
			if(X >= 0 && X < R && Y >= 0 && Y < C && map[X][Y] != -1) {
				copyMap[X][Y] = copyMap[X][Y] + map[x][y]/5;
				index++;
			}
		}
		
		copyMap[x][y] = copyMap[x][y] - ((map[x][y]/5) * index);
	}
	
	private static void purify() {
		int airPurifier = 0;
		int index = 0;
		for(int i = 0; i < R; i++) {
			if(copyMap[i][0] == -1) {
				airPurifier = i;
				break;
			}
		}
		
		// 위쪽 공기청정기 순환
		for(int i = airPurifier-1; i > 0; i--) {
			copyMap[i][0] = copyMap[i-1][0];
		}
		
		for(int i = 0; i < C-1; i++) {
			copyMap[0][i] = copyMap[0][i+1];
		}
		
		for(int i = 0; i < airPurifier; i++) {
			copyMap[i][C-1] = copyMap[i+1][C-1];
		}
		
		for(int i = C-1; i > 0; i--) {
			if(copyMap[airPurifier][i-1] != -1) {
				copyMap[airPurifier][i] = copyMap[airPurifier][i-1];				
			}else {
				copyMap[airPurifier][i] = 0;
			}
		}
		
		// 아래쪽 공기청정기 순환
		airPurifier += 1;
		
		for(int i = airPurifier+1; i < R-1; i++) {
			copyMap[i][0] = copyMap[i+1][0];
		}
		
		for(int i = 0; i < C-1; i++) {
			copyMap[R-1][i] = copyMap[R-1][i+1];
		}
		
		for(int i = R-1; i > airPurifier; i--) {
			copyMap[i][C-1] = copyMap[i-1][C-1];
		}
		
		for(int i = C-1; i > 0; i--) {
			if(copyMap[airPurifier][i-1] != -1) {
				copyMap[airPurifier][i] = copyMap[airPurifier][i-1];				
			}else {
				copyMap[airPurifier][i] = 0;
			}
		}
		
	}
	
	private static void mapCopy() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}
	
	private static int countFineDust() {
		int count = 0;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != -1) {
					count += map[i][j];
				}
			}
		}
		
		return count;
	}
	
//	private static void printMap() {
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(copyMap[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
	
}
