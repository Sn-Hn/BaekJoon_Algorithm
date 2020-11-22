package algorithm;

// 순열 : 1 2 3 4 5 중 3가지를 뽑는 경우의 수 (순서 상관 있음) 123 != 321 5P3 = 5!/2!
// 조합 : 1 2 3 4 5 중 3가지를 뽑는 경우의 수 (순서 상관 없음) 123  = 321 5C3 = 5P3/3! = 5!/2!*3!

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationCombination {
	
	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		/* 순열 */
		List<Integer> result = new ArrayList<>();
//		permutation(arr, result, arr.size(), 2);
		
		/* 중복순열 */
		int[] result1 = new int[2];
//		int[] result1 = new int[1];
//		rePermutation(arr, result1, 0, arr.size(), 2);
		
		/* 조합 */
		combination(arr, result, 0, arr.size(), 2);
		
//		reCombination(arr, result1, 0, arr.size(), 2, 0);
		
	}

	/**
	 * 순열 구하기	(중복 X)
	 * 
	 * @param arr    : 기준 리스트
	 * @param result : 결과를 담아줄 리스트
	 * @param n      : 전체 갯수
	 * @param r      : 뽑을 갯수
	 */
	private static void permutation(List<Integer> arr, List<Integer> result, int n, int r) {

		if (r == 0) {

			System.out.println(result.toString());
			return;
		}

		for (int i = 0; i < n; i++) {

			result.add(arr.remove(i));
			permutation(arr, result, n - 1, r - 1);			// r = 0이어서 reculsion이 돌지 않았으므로
			arr.add(i, result.remove(result.size() - 1));	// arr에 result에 넣었던 것을 뺴서 arr에 다시 넣는다.
		}
	}
	
	private static void rePermutation(List<Integer> arr, int[] result1, int depth, int n, int r) {
		if(depth == r) {
			System.out.println(Arrays.toString(result1));
			return;
		}
		
		/* 순열  */
//		for(int i = 0; i < n - depth; i++) {
//			result1[depth] = arr.remove(i);
//			rePermutation(arr, result1, depth+1, n, r);
//			arr.add(i, result1[depth]);
//		}
		
		/* 중복 순열 */
		for(int i = 0; i < n; i++) {
			result1[depth] = arr.get(i);
			rePermutation(arr, result1, depth+1, n, r);
		}
		
		
	}
	
	/**
	 * 조합 구하기
	 * 
	 * @param arr    : 기준 리스트
	 * @param result : 결과를 담아줄 리스트
	 * @param index  : 반복문 시작 인덱스
	 * @param n      : 전체 갯수
	 * @param r      : 뽑을 갯수
	 */
	private static void combination(List<Integer> arr, List<Integer> result, int index, int n, int r) {

		if (r == 0) {

			System.out.println(result.toString());
			return;
		}

		for (int i = index; i < n; i++) {

			result.add(arr.get(i));
			combination(arr, result, i + 1, n, r - 1);
			result.remove(result.size() - 1);
		}
	}
	/* 중복 조합 */
	private static void reCombination(List<Integer> arr, int[] result1, int index, int n, int r, int st) {
		if(r == 0) {
			System.out.println(Arrays.toString(result1));
			return;
		}
		
		/* 중복 조합 */
		for(int i = st; i < n; i++) {
			result1[index] = arr.get(i);
			reCombination(arr, result1, index+1, n, r-1, i);
		}
		
		
	}
	
	
}
