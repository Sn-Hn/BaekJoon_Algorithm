package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

드래곤 커브
시간 제한   메모리 제한   제출   정답   맞힌 사람   정답 비율
1 초   512 MB   16956   9541   6342   53.791%
문제
드래곤 커브는 다음과 같은 세 가지 속성으로 이루어져 있으며, 이차원 좌표 평면 위에서 정의된다. 좌표 평면의 x축은 → 방향, y축은 ↓ 방향이다.

시작 점
시작 방향
세대
0세대 드래곤 커브는 아래 그림과 같은 길이가 1인 선분이다. 아래 그림은 (0, 0)에서 시작하고, 시작 방향은 오른쪽인 0세대 드래곤 커브이다.



1세대 드래곤 커브는 0세대 드래곤 커브를 끝 점을 기준으로 시계 방향으로 90도 회전시킨 다음 0세대 드래곤 커브의 끝 점에 붙인 것이다. 끝 점이란 시작 점에서 선분을 타고 이동했을 때, 가장 먼 거리에 있는 점을 의미한다.



2세대 드래곤 커브도 1세대를 만든 방법을 이용해서 만들 수 있다. (파란색 선분은 새로 추가된 선분을 나타낸다)



3세대 드래곤 커브도 2세대 드래곤 커브를 이용해 만들 수 있다. 아래 그림은 3세대 드래곤 커브이다.



즉, K(K > 1)세대 드래곤 커브는 K-1세대 드래곤 커브를 끝 점을 기준으로 90도 시계 방향 회전 시킨 다음, 그것을 끝 점에 붙인 것이다.

크기가 100×100인 격자 위에 드래곤 커브가 N개 있다. 이때, 크기가 1×1인 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형의 개수를 구하는 프로그램을 작성하시오. 격자의 좌표는 (x, y)로 나타내며, 0 ≤ x ≤ 100, 0 ≤ y ≤ 100만 유효한 좌표이다.

입력
첫째 줄에 드래곤 커브의 개수 N(1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 드래곤 커브의 정보가 주어진다. 드래곤 커브의 정보는 네 정수 x, y, d, g로 이루어져 있다. x와 y는 드래곤 커브의 시작 점, d는 시작 방향, g는 세대이다. (0 ≤ x, y ≤ 100, 0 ≤ d ≤ 3, 0 ≤ g ≤ 10)

입력으로 주어지는 드래곤 커브는 격자 밖으로 벗어나지 않는다. 드래곤 커브는 서로 겹칠 수 있다.

방향은 0, 1, 2, 3 중 하나이고, 다음을 의미한다.

0: x좌표가 증가하는 방향 (→)
1: y좌표가 감소하는 방향 (↑)
2: x좌표가 감소하는 방향 (←)
3: y좌표가 증가하는 방향 (↓)
출력
첫째 줄에 크기가 1×1인 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수를 출력한다.

예제 입력 1
3
3 3 0 1
4 2 1 3
4 2 2 1
예제 출력 1
4
예제 입력 2
4
3 3 0 1
4 2 1 3
4 2 2 1
2 7 3 4
예제 출력 2
11
예제 입력 3
10
5 5 0 0
5 6 0 0
5 7 0 0
5 8 0 0
5 9 0 0
6 5 0 0
6 6 0 0
6 7 0 0
6 8 0 0
6 9 0 0
예제 출력 3
8
예제 입력 4
4
50 50 0 10
50 50 1 10
50 50 2 10
50 50 3 10
예제 출력 4
1992
힌트

https://www.acmicpc.net/problem/15685

*/

public class 드래곤커브_15685 {

    // 오 위 왼 아 -> 90도 회전하면 -> (x+3) / 4
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    private static int N;
    private static Set<Position> positions = new HashSet<>();
    private static List<Integer> directions = new ArrayList<>();

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static void drawDragonCurve(int x, int y, int depth, int g, List<Integer> dirs) {
        if (depth == g) {
            return;
        }

        int X = x;
        int Y = y;

        for (int direction : dirs) {
            X += dx[direction];
            Y += dy[direction];

            positions.add(new Position(X, Y));
        }

        drawDragonCurve(X, Y, depth + 1, g, curve());
    }

    private static List<Integer> curve() {
        Stack<Integer> insteadDirections = new Stack<>();
        insteadDirections.addAll(directions);
        List<Integer> rotationDirections = new ArrayList<>();
        while (!insteadDirections.isEmpty()) {
            int direction = insteadDirections.pop();
            int rotationDirection = (direction + 1) % 4;
            rotationDirections.add(rotationDirection);
            directions.add(rotationDirection);
        }

        return rotationDirections;
    }

    private static int getCount() {
        int count = 0;

        for (Position position : positions){
            if (checkPosition(count, position)) {
                count ++;
            }
        }

        return count;
    }

    private static boolean checkPosition(int count, Position position) {
        int[] checkX = {1, 0, 1};
        int[] checkY = {0, 1, 1};

        for (int i = 0; i < 3; i++) {
            int X = position.x + checkX[i];
            int Y = position.y + checkY[i];

            Position newPos = new Position(X, Y);
            if (!positions.contains(newPos)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());   // x
            int y = Integer.parseInt(st.nextToken());   // y
            int d = Integer.parseInt(st.nextToken());   // 시작 방향
            int g = Integer.parseInt(st.nextToken());   // 세대

            positions.add(new Position(x, y));

            directions.clear();
            directions.add(d);

            drawDragonCurve(x, y, 0, g + 1, directions);
        }

        System.out.println(getCount());

        br.close();
    }
}