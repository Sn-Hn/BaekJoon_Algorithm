package bruteForce;

/*

치킨 배달 분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
1 초   512 MB   34976   16330   9263   42.508%
문제
크기가 N×N인 도시가 있다. 도시는 1×1크기의 칸으로 나누어져 있다.
도시의 각 칸은 빈 칸, 치킨집, 집 중 하나이다. 도시의 칸은 (r, c)와 같은 형태로 나타내고, r행 c열 또는 위에서부터 r번째 칸, 왼쪽에서부터 c번째 칸을 의미한다.
r과 c는 1부터 시작한다.

이 도시에 사는 사람들은 치킨을 매우 좋아한다.
따라서, 사람들은 "치킨 거리"라는 말을 주로 사용한다.
치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다.
즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다.
도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.

임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.

예를 들어, 아래와 같은 지도를 갖는 도시를 살펴보자.

0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
0 0 0 1 1
0 0 0 1 2
0은 빈 칸, 1은 집, 2는 치킨집이다.

(2, 1)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |2-1| + |1-2| = 2, (5, 5)에 있는 치킨집과의 거리는 |2-5| + |1-5| = 7이다.
따라서, (2, 1)에 있는 집의 치킨 거리는 2이다.

(5, 4)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |5-1| + |4-2| = 6, (5, 5)에 있는 치킨집과의 거리는 |5-5| + |4-5| = 1이다.
따라서, (5, 4)에 있는 집의 치킨 거리는 1이다.

이 도시에 있는 치킨집은 모두 같은 프랜차이즈이다.
프렌차이즈 본사에서는 수익을 증가시키기 위해 일부 치킨집을 폐업시키려고 한다.
오랜 연구 끝에 이 도시에서 가장 수익을 많이 낼 수 있는  치킨집의 개수는 최대 M개라는 사실을 알아내었다.

도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다.
어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.

둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.

도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다.
집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.

출력
첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.

예제 입력 1
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
예제 출력 1
5
예제 입력 2
5 2
0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
2 0 0 1 1
2 2 0 1 2
예제 출력 2
10
예제 입력 3
5 1
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
예제 출력 3
11
예제 입력 4
5 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
예제 출력 4
32

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치킨배달_15686 {
    private static int N, M;
    private static int map[][];
    private static boolean visit[];
    private static Set<Pair> houseList = new HashSet<Pair>();
    private static List<Pair> chickenList = new ArrayList<>();
    private static Pair[] combination;
    private static int min = 100000000;

    private static class Pair {
        int x, y, distance;

        public Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        combination = new Pair[M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if(a == 2) {
                    chickenList.add(new Pair(i, j, 0));
                }else if(a == 1) {
                    houseList.add(new Pair(i, j, 0));
                }
            }
        }
        visit = new boolean[chickenList.size()];

        combination(0, 0);

        System.out.println(min);

        br.close();
    }
    
    // 이렇게 간단히 풀 수 있음. 
    // houseList를 HashSet으로 선언한 이유는 순서에 상관없이 계산만 해주면 되기 때문에
    // List보다 탐색에 훨씬 빠른 set으로 선언함
    private static int solve() {
    	int dis = 0;
    	int sum = 0;
    	for(Pair pair : houseList) {
    		int minDis = 10000000;
    		for(Pair p : combination) {
    			dis = Math.abs(pair.x - p.x) + Math.abs(pair.y - p.y);
    			minDis = Math.min(minDis, dis);
    		}
    		sum += minDis;
    	}
    	
    	return sum;
    }
    
    // 조합
    // 1, 2와 2, 1은 같다. (시간초과 나는 이유)
    private static void combination(int index, int depth){
        if(depth == M) {
            min = Math.min(min, solve());
            return;
        }

        for(int i = index; i < chickenList.size(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination[depth] = chickenList.get(i);
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
    
    
    /* BFS 문
    // 처음엔 이것때문에 시간초과나는줄 알았는데 조합을 잘못 세워서 시간초과
    // 그러나 하나하나 BFS를 다 돌기 때문에 매우 느리다.
    
    private static int dx[] = {1, -1, 0, 0};
    private static int dy[] = {0, 0, 1, -1};

    private static int bfs(Pair pair){
        Queue<Pair> q = new LinkedList<>();
        q.add(pair);
        boolean visited[][] = new boolean[N][N];
        int sum = 0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            if(map[p.x][p.y] == 9) {
            	sum += p.distance;
            	break;
            }

            for(int i = 0; i < 4; i++) {
                int X = p.x + dx[i];
                int Y = p.y + dy[i];

                if(X >= 0 && X < N && Y >= 0 && Y < N && !visited[X][Y]) {
                    visited[X][Y] = true;
                    q.add(new Pair(X, Y, p.distance+1));
                }
            }
        }

        return sum;
    }

    // 조합
    // 1, 2와 2, 1은 같다. (시간초과 나는 이유)
    private static void combinationBFS(int index, int depth){
        if(depth == M) {
            print();
            int sum = 0;
            for(Pair pair : houseList) {
            	sum += bfs(pair);
            }
            
            min = Math.min(min, solve());
            return;
        }

        for(int i = index; i < chickenList.size(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                int x = chickenList.get(i).x;
                int y = chickenList.get(i).y;
                map[x][y] = 9;
                combination[depth] = chickenList.get(i);
                combinationBFS(i + 1, depth + 1);
                visit[i] = false;
                map[x][y] = 2;
            }
        }
    }
    */

    private static void print(){
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}