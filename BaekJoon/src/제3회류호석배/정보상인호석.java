package 제3회류호석배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정보상인호석 {
	private static int Q;
	private static long sum = 0;
	private static Map<String, List<Integer>> info = new HashMap<String, List<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Q = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		
		for (int i = 0; i < Q; i++) {
			List<Integer> values = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			if (n == 1) {
				if (info.containsKey(name)) {
					values = info.get(name);
				}
				for (int j = 0; j < k; j++) {
					values.add(Integer.parseInt(st.nextToken()));
				}
				System.out.println("1 : " + values);
				info.put(name, values);
			}else {
				int j = 0;
				values = info.get(name);
				if (values == null) {
					continue;
				}
				Collections.sort(values, (o1, o2) -> o2 - o1);
				System.out.println("2 : " + values);
				while (!values.isEmpty()) {
					if (j == k) {
						break;
					}
					sum += values.get(0);
					values.remove(0);
					j++;
				}
			}
		}
		
		System.out.println(sum);
		
		
		br.close();
	}
}
