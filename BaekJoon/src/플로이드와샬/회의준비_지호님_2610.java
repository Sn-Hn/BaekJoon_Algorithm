package 플로이드와샬;

import java.util.*;

/*
https://www.acmicpc.net/problem/2610
 */
public class 회의준비_지호님_2610 {
    static int n, m;
    static int[][] arr, copy_arr;
    static int INF = (int)1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1][n+1];
        copy_arr = new int[n+1][n+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) arr[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }

        // 플로이드 와샬
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    arr[a][b] = Math.min(arr[a][b], arr[a][k] + arr[k][b]);
                }
            }
        }

        // 배열 copy
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                copy_arr[i][j] = arr[i][j];
            }
        }

        List<Integer> list = new ArrayList<>();
        // dfs로 그룹찾기 - 기존 arr 에서
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == INF) continue;
                dfs(i,j);
                list.add(i);
            }
        }

        // K 출력
        System.out.println(list.size());

        list.add(n+1);// 아래 반복문에서 마지막까지 확인하기 위해서 n+1 값 add
        // 1 4 8 9

        int[] d = new int[list.size()-1]; // 그룹별 최소 row 인덱스 기록용 배열
        for (int i = 0; i < list.size()-1; i++) {
            int a = list.get(i);
            int b = list.get(i+1);

            // 각 로우마다 행중에 가장 큰 값 기준으로 제일 적은 로우값 기록
            int min = INF;
            for (int x = a; x < b; x++) {
                int max = 0;
                for (int y = a; y < b; y++) {
                    max = Math.max(copy_arr[x][y], max);
                }
                if (min > max) {
                    min = max;
                    d[i] = x;
                }
            }
        }

        // 위원회 대표 번호 차례로 출력
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }
    }

    private static void dfs(int i, int j) {
        if (i == 0 || j == 0 || i > n || j > n) return;
        if (arr[i][j] == INF) return;
        arr[i][j] = INF;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
}