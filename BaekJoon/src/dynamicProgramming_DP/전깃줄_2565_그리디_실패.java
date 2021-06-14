package dynamicProgramming_DP;

/*

전깃줄 출처분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
1 초   128 MB   15760   7362   5840   46.713%
문제
두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다.
합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.

예를 들어, <그림 1>과 같이 전깃줄이 연결되어 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄,
A의 3번 위치와 B의 9번 위치를 잇는 전깃줄,
A의 4번 위치와 B의 1번 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다.



전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다.
전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때,
남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다.
전깃줄의 개수는 100 이하의 자연수이다.
둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호가 차례로 주어진다.
위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.

출력
첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.

예제 입력 1
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6
예제 출력 1
3

6
1 8
2 9
4 4
5 2
6 1
7 5

5
3 4
1 5
4 2
2 3
5 1

10
1 6
2 8
3 2
4 9
5 5
6 10
7 4
8 1
9 7
10 3

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 그리디 실패
public class 전깃줄_2565_그리디_실패 {
    private static int N;
    private static int[][] electricFlex;
    private static Node[] nodeList;
    private static int[] intersection;
    private static int result = 0;

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        electricFlex = new int[501][501];
        nodeList = new Node[N];
        intersection = new int[N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            electricFlex[a][b] = 1;
            nodeList[i] = new Node(a, b);
        }

        getCrossElectricFlexCount();

//        printFlex();

        System.out.println(result);

        br.close();
    }

    private static void getMinCount() {
        int maxIndex = getMaxIndex();

//        System.out.println(maxIndex);

        if (maxIndex == -1) {
            return;
        }
        result += 1;
        nodeList[maxIndex].x = 0;
        nodeList[maxIndex].y = 0;

        getCrossElectricFlexCount();
    }

    private static int getMaxIndex() {
        int max = 0;
        int maxIndex = -1;
        printIntersection();
        for (int i = 0; i < N; i++) {
            if (max < intersection[i]) {
                max = intersection[i];
                maxIndex = i;
            }
        }

        Arrays.fill(intersection, 0);

        return maxIndex;
    }

    private static void getCrossElectricFlexCount() {
        Node nodeA = null;
        Node nodeB = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                nodeA = nodeList[i];
                nodeB = nodeList[j];

                if (!isCross(nodeA, nodeB)) {
                    intersection[i]++;
                }
            }
        }

        getMinCount();
    }

    private static boolean isCross(Node a, Node b) {
        if (a.x == 0 && a.y == 0 && b.x == 0 && b.y == 0) {
            return true;
        }

        if (a.x > b.x && a.y > b.y) {
            return true;
        }

        if (a.x < b.x && a.y < b.y) {
            return true;
        }

        return false;
    }

    private static void printIntersection() {
        for (int i = 0; i < N; i++) {
            System.out.print(intersection[i] + " ");
        }
        System.out.println();
    }

    private static void printFlex() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(electricFlex[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}