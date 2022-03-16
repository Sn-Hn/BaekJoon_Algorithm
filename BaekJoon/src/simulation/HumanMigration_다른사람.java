package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HumanMigration_다른사람 {
	static int[][] map;
	static boolean[][] visit;
	static int cnt = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};//nesw
	static int N,L,R;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = true;
		while(flag) {
			visit = new boolean[N][N];
			flag = check();
		}
		System.out.println(cnt);
	}
	
	static void bfs(int x, int y) {
		ArrayList<Pos> union = new ArrayList<>();
		
		Queue<Pos> q = new LinkedList<>();
		Pos temp = new Pos(x,y);
		q.offer(temp);
		union.add(temp);
		visit[x][y] = true;
		
		while(!q.isEmpty()){
			Pos p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny= p.y+dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<N) {
					int diff = Math.abs(map[nx][ny] - map[p.x][p.y]);
					if(diff>= L && diff<=R && !visit[nx][ny]) {
						temp = new Pos(nx,ny);
						q.offer(temp);
						visit[nx][ny] = true;
						union.add(temp);
					}
				}
			}
		}
		
		int sum =0;
		for(int i=0;i<union.size();i++) {
			sum+= map[union.get(i).x][union.get(i).y];
		}
		sum /= union.size();
		for(int i=0;i<union.size();i++) {
			map[union.get(i).x][union.get(i).y]=sum;
		}

	}
	static boolean check() {
		boolean flag = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=1;k<=2;k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx>=0 && ny>=0 && nx<N && ny<N) {
						int diff = Math.abs(map[i][j] -map[nx][ny]);
						if(diff>=L && diff<=R && !visit[i][j] && !visit[nx][ny]) {
							bfs(i,j);
							flag = true;
						}
					}
				}
			}
		}
		if(flag) {
			cnt++;
		}
		return flag;
	}
	
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
