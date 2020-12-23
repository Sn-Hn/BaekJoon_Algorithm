package samsung_SW_Graph_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*

이모티콘 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	9384	3556	2293	34.440%
문제
영선이는 매우 기쁘기 때문에, 효빈이에게 스마일 이모티콘을 S개 보내려고 한다.

영선이는 이미 화면에 이모티콘 1개를 입력했다. 
이제, 다음과 같은 3가지 연산만 사용해서 이모티콘을 S개 만들어 보려고 한다.

화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
화면에 있는 이모티콘 중 하나를 삭제한다.
모든 연산은 1초가 걸린다. 또, 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기가 된다. 
클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다. 
또한, 클립보드에 있는 이모티콘 중 일부를 삭제할 수 없다. 
화면에 이모티콘을 붙여넣기 하면, 클립보드에 있는 이모티콘의 개수가 화면에 추가된다.

영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 S (2 ≤ S ≤ 1000) 가 주어진다.

출력
첫째 줄에 이모티콘을 S개 만들기 위해 필요한 시간의 최솟값을 출력한다.

예제 입력 1 
2
예제 출력 1 
2
예제 입력 2 
4
예제 출력 2 
4
예제 입력 3 
6
예제 출력 3 
5
예제 입력 4 
18
예제 출력 4 
8

*/

public class Emoticon_14226 {
	private static int N, min;
	private static boolean visited[][];
	
	private static class Pair {
		int count, depth, clipboard;
		public Pair(int count, int clipboard, int depth) {
			this.count = count;
			this.depth = depth;
			this.clipboard = clipboard;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[2002][2002];
		
		visited[1][0] = true;
		bfs();
		System.out.println(min);
		br.close();
	}
	
	private static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(1, 0, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(p.count == N) {
				min = p.depth;
				return;
			}
			
			if(!visited[p.count][p.count]) {
				visited[p.count][p.count] = true;
				q.add(new Pair(p.count, p.count, p.depth+1));
			}
			
			if(!visited[p.count + p.clipboard][p.clipboard] && p.count+p.clipboard <= N) {
				visited[p.count+p.clipboard][p.clipboard] = true;
				q.add(new Pair(p.count + p.clipboard, p.clipboard, p.depth+1));				
			}
			
			if(p.count > 0 && !visited[p.count-1][p.clipboard]) {
				visited[p.count-1][p.clipboard] = true;
				q.add(new Pair(p.count-1, p.clipboard, p.depth+1));
			}
		}
		
	}
}
