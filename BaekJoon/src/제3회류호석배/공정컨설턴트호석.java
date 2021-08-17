package 제3회류호석배;

/*

공정 컨설턴트 호석 성공출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	512 MB	170	73	52	40.945%
문제
거듭된 창업 성공을 이룬 류진국 사장은 이번에는 맞춤형 선물을 제작해주는 공장을 만들기로 했다. 
현재 들어온 맞춤형 선물 주문은 총 개이며, 각 맞춤형 선물마다 제작에 필요한 시간이 정해져있다. 
주문의 번호는 번부터 번까지 매겨져 있으며, 다음과 같은 규칙에 맞게 공정이 이뤄진다.

공정 라인이 총 개가 있다면 번부터 번까지의 번호가 존재한다.
공정 라인의 사용 시간은 배정된 맞춤형 선물들의 제작 시간의 총합이다.
번 선물은 번 부터 번 선물들이 배정된 이후에 사용 시간이 가장 적은 공정 라인 중 하나에 배정된다.
모든 맞춤형 선물의 제작이 완료될 때까지 최대 시간이 남아있는 상황인데, 아직 공정 라인의 개수 가 정해져 있지 않다. 
류진국 사장은 이 분야 최고 권위자, 공정 컨설턴트 호석에게 의뢰했다. 
공정 컨설턴트 호석은 최소한의 비용을 쓰기 위해서 공정 라인의 개수를 최소화 시키고자 한다. 
호석을 도와 필요한 최소 공정 라인 개수를 계산하자.

입력
첫 번째 줄에 맞춤형 선물 주문의 개수 , 제작 완료까지 남은 시간 가 공백으로 구분되어 주어진다.

두 번째 줄에는 번부터 번 선물이 필요한 공정 시간이 순서대로 주어진다. 단위는 '시간' 이다.

출력
모든 선물을 시간 이내에 제작하기 위해 필요한 최소 공정 라인 개수를 출력하라.

제한
, 은 자연수이다.
, 는 자연수이다.
 각 선물의 공정 시간 , 모든 시간은 자연수이다.
예제 입력 1 
6 11
5 2 8 4 3 5
예제 출력 1 
3

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 공정컨설턴트호석 {
	private static int N;
	private static long X;
	private static long[] present;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		present = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			present[i] = Long.parseLong(st.nextToken());
		}
		
		int minLineCount = getMinLineCount();
		
		System.out.println(minLineCount);
		
		br.close();
	}
	
	private static int getMinLineCount() {
		int start = 1;
		int end = N;
		int mid = 0;
		
		while (start <= end) {
			mid = (start + end) / 2;
			
			long minTime = getMinTime(mid);
			
			if (minTime <= X) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return start;
	}
	
	private static long getMinTime(int count) {
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		int index = count;
		long firstTime = 0;
		long maxTime = 0;
		for (int i = 0; i < count; i++) {
			q.add(present[i]);
		}
		
		while (!q.isEmpty()) {
			firstTime = q.poll();
			
			if (index == N) {
				break;
			}
			
			firstTime += present[index++];
			maxTime = Math.max(maxTime, firstTime);
			q.add(firstTime);
		}
		
		
		return maxTime;
	}
}
