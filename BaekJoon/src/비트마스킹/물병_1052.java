package 비트마스킹;

/*

물병 분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
1 초   512 MB   2573   893   677   35.613%
문제
지민이는 N개의 물병을 가지고 있다.
각 물병에는 물을 무한대로 부을 수 있다.
처음에 모든 물병에는 물이 1리터씩 들어있다.
지민이는 이 물병을 또 다른 장소로 옮기려고 한다.
지민이는 한 번에 K개의 물병을 옮길 수 있다.
하지만, 지민이는 물을 낭비하기는 싫고, 이동을 한 번보다 많이 하기는 싫다. 따라서, 지민이는 물병의 물을 적절히 재분배해서, K개를 넘지 않는 비어있지 않은 물병을 만들려고 한다.

물은 다음과 같이 재분배 한다.

먼저 같은 양의 물이 들어있는 물병 두 개를 고른다.
그 다음에 한 개의 물병에 다른 한 쪽에 있는 물을 모두 붓는다. 이 방법을 필요한 만큼 계속 한다.

이런 제약 때문에, N개로 K개를 넘지않는 비어있지 않은 물병을 만드는 것이 불가능할 수도 있다.
다행히도, 새로운 물병을 살 수 있다.
상점에서 사는 물병은 물이 1리터 들어있다.

예를 들어, N=3이고, K=1일 때를 보면, 물병 3개로 1개를 만드는 것이 불가능하다.
한 병을 또다른 병에 부으면, 2리터가 들어있는 물병 하나와, 1리터가 들어있는 물병 하나가 남는다.
만약 상점에서 한 개의 물병을 산다면, 2리터가 들어있는 물병 두 개를 만들 수 있고, 마지막으로 4리터가 들어있는 물병 한 개를 만들 수 있다.

입력
첫째 줄에 N과 K가 주어진다.
N은 107보다 작거나 같은 자연수이고, K는 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 상점에서 사야하는 물병의 최솟값을 출력한다.
만약 정답이 없을 경우에는 -1을 출력한다.

예제 입력 1
3 1
예제 출력 1
1

*/

// 20 / 2 = 10 .. 0    // 1
// 10 / 2 = 5  .. 0    // 2
//  5 / 2 = 2  .. 1    // 4
//  2 / 2 = 1  .. 0    // 8
//  1 / 2 = 0  .. 1    // 16
//                     // 32 - 20 = 12
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 물병_1052 {
    private static int N;       // 10^7 = 10,000,000
    private static int K;       // 1,000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = solve();
        
        System.out.println(result);

        br.close();
    }
    
    private static int solve() {
    	List<Integer> list = mergeWater(N);

    	//  1   1
    	// 2^0 2^1
    	//  1   2  -> 4 - 3
    	return getMaxCount(list);    	
    }
    
    private static int getMaxCount(List<Integer> list) {
    	int maxCount = 0;
    	int first = 0;
    	int remain = 0;
    	for (int i = 0; i < list.size(); i++) {
    		if (list.get(i) == 1) {
    			maxCount++;
    			if (maxCount <= K) {
    				first = (int) Math.pow(2, list.size() - i - 1);
    				continue;
    			}
    			
    			remain = (int) Math.pow(2,  list.size() - i - 1);
    			first -= remain;
    		}
    	}
    	
    	if (K >= maxCount) {
    		return 0;
    	}
    	
    	return first;
    }

    private static List<Integer> mergeWater(int n) {
        List<Integer> list = new ArrayList<>();

        while(n >= 1) {
            list.add(0, n % 2);
            n /= 2;
        }

        return list;
    }
}