package 자료구조;

/*

강의실 배정 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	10074	3012	2133	29.368%
문제
수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다. 

김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다. 

참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)

수강신청 대충한 게 찔리면, 선생님을 도와드리자!

입력
첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)

이후 N개의 줄에 Si, Ti가 주어진다. (1 ≤ Si < Ti ≤ 109)

출력
강의실의 개수를 출력하라.

예제 입력 1 
4
1 3
2 4
3 9
3 5
예제 출력 1 
2

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 강의실배정_11000 {
	private static int N;
	private static Lecture[] lectures;
	
	private static class Lecture {
		int start;
		int end;
		
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lectures = new Lecture[N];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			lectures[i] = new Lecture(start, end);
		}
		
		// 정렬
		Arrays.sort(lectures, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
		
		getLectureLoomCount(lectures);
		
		
		br.close();
	}
	
	private static void getLectureLoomCount(Lecture[] lectures) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(lectures[0].end);
		
		for (int i = 1; i < N; i++) {
			if (pq.peek() <= lectures[i].start) {
				pq.poll();
			}
			
			pq.add(lectures[i].end);
		}
		
		System.out.println(pq.size());
	}
}
