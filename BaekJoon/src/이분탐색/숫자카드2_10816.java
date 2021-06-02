package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

숫자 카드 2 분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
1 초   256 MB   33825   12020   8569   35.674%
문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 
정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 
둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 
숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 
넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다.
이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

출력
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.

예제 입력 1 
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
예제 출력 1 
3 0 0 1 2 0 0 2

*/

public class 숫자카드2_10816 {
    private static int N, M;
    private static int arr[];
//    private static List<Integer> list = new ArrayList<>();
    private static int result[];
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
//            list.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
//        Collections.sort(list);
        M = Integer.parseInt(br.readLine());
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        System.out.println(Arrays.toString(arr));
        System.out.println("up low");
        for(int i = 0; i < M; i++) {
            int search = Integer.parseInt(st.nextToken());
            int up = upper(search);
            int low = lower(search);
            
            System.out.println(up + " , " + low);

            sb.append(up - low + 1 + " ");
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static int lower(int search) {
        int start = 0;
        int end = N-1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(search > arr[mid]) {
            	start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return start;
    }

    private static int upper(int search) {
        int start = 0;
        int end = N-1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(search >= arr[mid]) {
            	start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return end;
    }
}