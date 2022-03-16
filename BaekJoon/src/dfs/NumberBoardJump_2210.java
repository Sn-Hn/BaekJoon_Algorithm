package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/*

문제
5×5 크기의 숫자판이 있다. 
각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다. 
이 숫자판의 임의의 위치에서 시작해서, 
인접해 있는 네 방향으로 다섯 번 이동하면서, 
각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다. 
이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며, 
0으로 시작하는 000123과 같은 수로 만들 수 있다.

숫자판이 주어졌을 때, 
만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.

입력
다섯 개의 줄에 다섯 개의 정수로 숫자판이 주어진다.

출력
첫째 줄에 만들 수 있는 수들의 개수를 출력한다.

예제 입력 1 
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 2 1
1 1 1 1 1
예제 출력 1 
15

*/


// 20/10/16 오전12:54 거의 맞는 것 같은데 무언가가 잘못 되었다... 내일 출근하면서 풀어보자
// 20/10/18 중복을 제외하니까 Hash 쓰면 되네.. 생각도 못했다..
// 출근하면서 다익스트라 강의 두번 보기.. 투 포인터도..
public class NumberBoardJump_2210 {
	private static int map[][] = new int[6][6];
	private static HashSet<String> list = new HashSet<>();
	// 상 하 좌 우
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	
	public static void dfs(int x, int y, int cnt, String numStr) {
		if(cnt == 6) {
			
			list.add(numStr);
			
			return;
		}
		numStr += map[x][y];
		for(int i = 0; i < 4; i++) {
			int X = dx[i] + x;
			int Y = dy[i] + y;
			
			if(X <= 5 && Y <= 5 && X > 0 && Y > 0) {
				
				dfs(X, Y, cnt+1, numStr);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 1; i <= 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		String numStr = new String();
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				dfs(i, j, 0, numStr);
				
			}
		}
		
		System.out.println(list.size());
		
		
		br.close();
		bw.close();
	}
}
