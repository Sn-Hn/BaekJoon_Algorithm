package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*

눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 
이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 
이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.

예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 
그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.



<그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.

M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, 
K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 
그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. 
M, N, K는 모두 100 이하의 자연수이다. 
둘째 줄부터 K개의 줄에는 한 줄에 하나씩 
직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 
오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다. 
모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 
오른쪽 위 꼭짓점의 좌표는(N,M)이다. 
입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.

출력
첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 
둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.


*/

public class AreaSave_2583 {
	private static int m, n, k;
	private static int map[][];
	private static boolean visited[][];
	private static int cnt, area;
	private static List<Integer> areaArr = new ArrayList<>();
							// 상 하 좌 우
	private static int dx[] = {0, 0, -1, 1};
	private static int dy[] = {-1, 1, 0, 0};
	
	private static int dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i < dx.length; i++) {
			int X = dx[i] + x;
			int Y = dy[i] + y;
			
			if(X >= 0 && Y >= 0 && X < m && Y < n) {
				if(!visited[X][Y] && map[X][Y] == 0) {
					dfs(X, Y);
					area += 1;
				}
			}
			
		}
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		visited = new boolean[m][n];
		
		cnt = 0;
		
		for(int i = 0; i < k; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(stn.nextToken());
			int startX = Integer.parseInt(stn.nextToken());
			int endY = Integer.parseInt(stn.nextToken());
			int endX = Integer.parseInt(stn.nextToken());
			
			for(int j = startX; j < endX; j++) {
				for(int k = startY; k < endY; k++) {
					map[j][k] = 1;
				}
			}
			
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					area = 1;
					cnt += dfs(i, j);
					areaArr.add(area);
				}
			}
		}
		areaArr.sort(null);
		bw.write(String.valueOf(cnt) + "\n");
		
		for(int i : areaArr) {
			bw.write(i + " ");
		}
		
		br.close();
		bw.close();
		
	}
}
