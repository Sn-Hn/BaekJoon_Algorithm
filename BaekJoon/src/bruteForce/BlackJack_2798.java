package bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*

카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 
카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 
블랙잭은 카지노마다 다양한 규정이 있다.

한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.

김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 
그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 
그런 후에 딜러는 숫자 M을 크게 외친다.

이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 
블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 
둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는다.

합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
*/

/* 순열 재귀는 시간과 메모리를 많이 잡아먹음.. */
public class BlackJack_2798 {
	private static int sum = 0;
	private static int st = 0;
	private static int temp = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		st = m;
		// 순열을 이용한 방법들 전부 주석
//		List<Integer> arr = new ArrayList<>();
//		int[] result = new int[3];
		
		int[] list = new int[n];
		for(int i = 0; i < n; i++) {
//			arr.add(scan.nextInt());
			list[i] = scan.nextInt();
		}
		
		solve(list);
//		permutation(arr, result, 0, n, 3);
		
		System.out.println(sum);
	}
	// 순열을 이용한 방법
	/*
	private static void permutation(List<Integer> arr, int[] result, int depth, int n, int r) {
		if(depth == r) {
			sum(result);
			return;
		}
		
		for(int i = 0; i < n-depth; i++) {
			result[depth] = arr.remove(i);
			permutation(arr, result, depth+1, n, r);
			arr.add(i, result[depth]);
		}
		
	}
	*/
	
	private static void solve(int[] list) {
		for(int i = 0; i < list.length; i++) {
			temp = 0;
			for(int j = i+1; j < list.length; j++) {
				for(int k = j+1; k < list.length; k++) {
					temp = list[i] + list[j] + list[k];
					if(st >= temp) {
						if(sum < temp) {
							sum = temp;				
						}
					}
				}
			}
			
		}
	}
	/*
	private static void sum(int[] result) {
		temp = Arrays.stream(result).sum();
		if(st >= temp) {
			if(sum < temp) {
				sum = Arrays.stream(result).sum();				
			}
		}
	}
	*/
	
}
