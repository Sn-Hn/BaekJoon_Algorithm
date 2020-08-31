package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
1부터 N까지의 수를 임의로 배열한 순열은 총 N! = N×(N-1)×…×2×1 가지가 있다.

임의의 순열은 정렬을 할 수 있다. 
예를 들어  N=3인 경우 {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}의 순서로 생각할 수 있다. 
첫 번째 수가 작은 것이 순서상에서 앞서며, 첫 번째 수가 같으면 두 번째 수가 작은 것이, 두 번째 수도 같으면 세 번째 수가 작은 것이….

N이 주어지면, 아래의 두 소문제 중에 하나를 풀어야 한다. 
k가 주어지면 k번째 순열을 구하고, 임의의 순열이 주어지면 이 순열이 몇 번째 순열인지를 출력하는 프로그램을 작성하시오.

첫째 줄에 N(1≤N≤20)이 주어진다. 둘째 줄의 첫 번째 수는 소문제 번호이다. 
1인 경우 k(1≤k≤N!)를 입력받고, 2인 경우 임의의 순열을 나타내는 N개의 수를 입력받는다. 
N개의 수에는 1부터 N까지의 정수가 한 번씩만 나타난다.

k번째 수열을 나타내는 N개의 수를 출력하거나, 몇 번째 수열인지를 출력하면 된다.

*/

public class PermutationSequence {
	private static int cnt = 0;
	private static int c = 0;
	public static void main(String[] args) {
		solution();
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
//		List<Integer> arr = new ArrayList<Integer>();
//		List<Integer> result = new ArrayList<Integer>();
//		for(int i = 1; i <= n; i++) {
//			arr.add(i);
//		}
//		long[] res = new long[n];
//		
//		int first = scan.nextInt();
//		
//		if(first == 1) {
//			int second = scan.nextInt();
//			permutation(arr, result, arr.size(), n, sec);
//		}else {
//			String second = scan.nextLine().trim();
//			res = Arrays.stream(second.split(" ")).mapToLong(Integer::parseInt).toArray();
//			permutation(arr, result, arr.size(), n, res);
//		}
		
//		permutations(arr, res, arr.size(), 0, 0);
		
	}
	/* 순열 구하기 */
	private static void permutation(List<Integer> arr, List<Integer> result, int n, int r, int count) {
		
		if(r == 0) {
			cnt++;
			if(cnt==count) {
				System.out.println(result.toString());
				return;
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			result.add(arr.remove(i));
			permutation(arr, result, n-1, r-1, count);
			arr.add(i, result.remove(result.size()-1));
			if(cnt >= count && count != -1) break;
		}
	}
	/* 순열 구하기 오버로딩 */
	private static void permutation(List<Integer> arr, List<Integer> result, int n, int r, long[] res) {
		
		if(r == 0) {
			cnt++;
			if(Arrays.toString(res).equals(result.toString())) {
				System.out.println(cnt);
				c = cnt;
				return;
			}
			System.out.println(result.toString());
			return;
		}
		
		for(int i = 0; i < n; i++) {
			result.add(arr.remove(i));
			permutation(arr, result, n-1, r-1, res);
			arr.add(i, result.remove(result.size()-1));
			if(c >= cnt) {
				break;
			}
		}
	}
	/* ---------------------------------블로그 참조 밑에 출처--------------------------------------- */
	public static void solution() {
        Scanner scan = new Scanner(System.in);
        long [] f = new long[21];
        boolean [] c = new boolean[21]; //n엔 중복된 수가 없으므로 중복을 없앨 boolean 배열
        Arrays.fill(f, 1);				// f라는 배열을 전부 1로 초기화
        
        for(int i=1; i<=20; i++) { //팩토리얼 구하기
            f[i] = f[i-1]*i;
        }
        
        int n = scan.nextInt();
        int what = scan.nextInt();
        
        int [] a = new int[n];
        if(what == 2) { //몇 번째 순열인지
            for(int i=0; i<n; i++)
                a[i] = scan.nextInt();
            
            long ans = 1; //순열은 1 번째 부터 시작
            for(int i=0; i<n; i++) {
                for(int j=1; j<a[i]; j++) {
                    if(!c[j])
                        ans += f[n-i-1];
                }
                c[a[i]]=true;
            }
            System.out.println(ans);
        }
        else if(what == 1) { //k 번째 순열 출력
            long k = scan.nextLong();
            for(int i=0; i<n; i++) {
                for(int j=1; j<=n; j++) {
                    if(c[j])
                        continue;
                    if(f[n-i-1] < k) {
                        k -= f[n-i-1];
                    }
                    else {
                        a[i] = j;
                        c[j] = true;
                        break;
                    }
                }
            }
            for(int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
        }
    }


	/* 출처: https://dundung.tistory.com/60 [DunDung] */
}
