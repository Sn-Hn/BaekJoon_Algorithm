package unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 전국시대_복습_15809 {
	private static int N, M;
	private static int parent[];
	private static int mil[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		mil = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			mil[i] = Integer.parseInt(br.readLine());
			parent[i] = i;
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			if(o == 1) {
				union(p, q);
			}else {
				int P = find(p);
				int Q = find(q);
				
				if(P == Q) {
					mil[P] = mil[Q] = 0;
				}else if(mil[P] > mil[Q]) {
					mil[P] -= mil[Q];
					mil[Q] = 0;
					parent[Q] = P;
				}else {
					mil[Q] -= mil[P];
					mil[P] = 0;
					parent[P] = Q;
				}
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(mil[i] != 0) {
				list.add(mil[i]);
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		System.out.println(list.size());
		for(int i : list) sb.append(i + " ");
		System.out.println(sb.toString());
		
		
		br.close();
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a < b) {
			parent[b] = a;
			mil[a] += mil[b];
			mil[b] = 0;
		}
		else {
			parent[a] = b;
			mil[b] += mil[a];
			mil[a] = 0;
		}
	}
}
