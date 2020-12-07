package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*

문제
세로 두 줄, 가로로 N개의 칸으로 이루어진 표가 있다. 
첫째 줄의 각 칸에는 정수 1, 2, …, N이 차례대로 들어 있고 
둘째 줄의 각 칸에는 1이상 N이하인 정수가 들어 있다. 
첫째 줄에서 숫자를 적절히 뽑으면, 그 뽑힌 정수들이 이루는 집합과, 
뽑힌 정수들의 바로 밑의 둘째 줄에 들어있는 정수들이 이루는 집합이 일치한다. 
이러한 조건을 만족시키도록 정수들을 뽑되, 
최대로 많이 뽑는 방법을 찾는 프로그램을 작성하시오. 
예를 들어, N=7인 경우 아래와 같이 표가 주어졌다고 하자.



이 경우에는 첫째 줄에서 1, 3, 5를 뽑는 것이 답이다. 
첫째 줄의 1, 3, 5밑에는 각각 3, 1, 5가 있으며 두 집합은 일치한다. 
이때 집합의 크기는 3이다. 만약 첫째 줄에서 1과 3을 뽑으면, 
이들 바로 밑에는 정수 3과 1이 있으므로 두 집합이 일치한다. 
그러나, 이 경우에 뽑힌 정수의 개수는 최대가 아니므로 답이 될 수 없다.

입력
첫째 줄에는 N(1≤N≤100)을 나타내는 정수 하나가 주어진다. 
그 다음 줄부터는 표의 둘째 줄에 들어가는 정수들이 순서대로 한 줄에 하나씩 입력된다.

출력
첫째 줄에 뽑힌 정수들의 개수를 출력하고, 그 다음 줄부터는 뽑힌 정수들을 작은 수부터 큰 수의 순서로 한 줄에 하나씩 출력한다.

예제 입력 1 
7
3
1
1
5
5
4
6
예제 출력 1 
3
1
3
5

*/

//반례
//10
//2
//4
//1
//7
//7
//4
//4
//8
//2
//1

// List형으로 중복을 제거하려다 보니 방문처리를 제대로 하지 못함
// 테스트케이스와 다른 반례들은 통과하였는데 위 반례를 통과하지 못함
// 보니 방문처리 실수
// 방문처리를 제대로 하니 중복된 값이 들어갈 수 있어 Set으로 중복처리
// 그 후 정렬을 위하여 List로 대체
public class PickNumber_2668 {
	private static int[] arr;
	private static int[] ranArr;
	private static int n;
	private static boolean[] visited;
	private static Set<Integer> result;
	private static List<Integer> compare;
	
	private static void dfs(int idx, int ran) {
		// 정상 배열과 입력받은 배열의 같은 인덱스의 값이 같다면 무조건 포함
		if(arr[idx] == ranArr[idx]) {
			result.add(arr[idx]);
			visited[idx] = true;
			return;
		}
		
		// 인덱스를 방문하지 않았다면
		if(!visited[idx]) {
			if(arr[idx] == ranArr[ran]) {
				compare.add(arr[idx]);
				compare.add(ran);
				result.addAll(compare);
				visited[idx] = true;
				visited[ran] = true;
			}else {
				compare.add(ran);
				if(!compare.contains(ranArr[ran])) {
					visited[ran] = true;
					dfs(idx, ranArr[ran]);
				
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];					// 정상 배열
		ranArr = new int[n+1];				// 입력 배열
		result = new HashSet<Integer>();	// 결과 값
		
		// 정상 배열과 입력받을 배열을 초기화
		for(int i = 1; i <= n; i++) {
			arr[i] = i;
			ranArr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= n; i++) {
			compare = new ArrayList<Integer>();
			visited = new boolean[n+1];			// 방문 처리
			if(!visited[i]) {
				dfs(i, ranArr[i]);				
			}
		}
		
		System.out.println(result.size());
		
		List<Integer> list = new ArrayList<>(result);
		Collections.sort(list);
		
		// 정렬 처리를 하지 않아 오답처리
//		Iterator<Integer> it = result.iterator();
//		
//		// hasNext() : 데이터가 있으면 true, 없으면 false
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		
		
		br.close();
	}
}
