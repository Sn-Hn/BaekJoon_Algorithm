package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N번째큰수_2075 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> bigNumbers = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int inputNumber = Integer.parseInt(st.nextToken());
                collectBigNumbers(bigNumbers, inputNumber);
            }
        }

        System.out.println(bigNumbers.peek());

        br.close();
    }

    private static void collectBigNumbers(PriorityQueue<Integer> bigNumbers, int inputNumber) {
        bigNumbers.add(inputNumber);

        if (bigNumbers.size() > N) {
            bigNumbers.poll();
        }
    }
}