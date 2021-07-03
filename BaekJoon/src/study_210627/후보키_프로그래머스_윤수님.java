package study_210627;

import java.util.ArrayList;
import java.util.HashSet;

public class 후보키_프로그래머스_윤수님 {

	static boolean visited[];
	static String srel[][];
	static int answer;

	public static int solution(String[][] relation) {
		answer = 0;

		// 1. 모든 조합을 만들어야 한다.
		sub = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[relation[0].length];
		int arr[] = new int[relation[0].length];

		srel = relation;

		// 학번
		for (int i = 0; i < relation[0].length; i++) {
			arr[i] = i;
		}

		// 컬럼 개수
		for (int i = 1; i <= arr.length; i++) {
			combi(arr, 0, arr.length, i);
		}

		return answer;
	}

	static ArrayList<ArrayList<Integer>> sub;

	public static void combi(int arr[], int start, int n, int r) {
		if (r == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			ArrayList<String> repo = new ArrayList<String>();

			for (int i = 0; i < arr.length; i++) {

				if (visited[i]) {
					list.add(arr[i]);
				}
			} // for end

			for (int i = 0; i < sub.size(); i++) {
				if (list.containsAll(sub.get(i)))
					return;
			}

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < srel.length; j++) {
				for (int k = 0; k < list.size(); k++) {

					sb.append(srel[j][list.get(k)]);

				}
				if (repo.contains(sb.toString())) { // 들어 있으면 return
					return;
				}

				repo.add(sb.toString());

				sb.setLength(0);
			}

			sub.add(list);
			answer++;

		}

		for (int i = start; i < arr.length; i++) {
			visited[i] = true;
			combi(arr, i + 1, n, r - 1);
			visited[i] = false;
		}

	}

}