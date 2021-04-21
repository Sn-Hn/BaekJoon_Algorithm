package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*

후보 추천하기 출처분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
2 초   128 MB   6102   1945   1539   32.592%
문제
월드초등학교 학생회장 후보는 일정 기간 동안 전체 학생의 추천에 의하여 정해진 수만큼 선정된다.
그래서 학교 홈페이지에 추천받은 학생의 사진을 게시할 수 있는 사진틀을 후보의 수만큼 만들었다.
추천받은 학생의 사진을 사진틀에 게시하고 추천받은 횟수를 표시하는 규칙은 다음과 같다.

학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고, 그 자리에 새롭게 추천받은 학생의 사진을 게시한다.
이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는 그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀐다.
후보의 수 즉, 사진틀의 개수와 전체 학생의 추천 결과가 추천받은 순서대로 주어졌을 때, 최종 후보가 누구인지 결정하는 프로그램을 작성하시오.

입력
첫째 줄에는 사진틀의 개수 N이 주어진다. (1≤N≤20)
둘째 줄에는 전체 학생의 총 추천 횟수가 주어지고, 셋째 줄에는 추천받은 학생을 나타내는 번호가 빈 칸을 사이에 두고 추천받은 순서대로 주어진다.
총 추천 횟수는 1,000번 이하이며 학생을 나타내는 번호는 1부터 100까지의 자연수이다.

출력
사진틀에 사진이 게재된 최종 후보의 학생 번호를 증가하는 순서대로 출력한다.

예제 입력 1
3
9
2 1 4 3 5 6 2 7 2
예제 출력 1
2 6 7

3
9
2 2 4 3 5 6 2 7 2

*/

public class 후보추천하기_1713 {
    private static int N;
    private static int M;
    private static int recommand[];
    private static List<Integer> student = new ArrayList<>();
    private static int picture[];
    private static List<Integer> pictureFrame = new ArrayList<>();

    private static class Pair {
        int index, recommand;
        public Pair(int index, int recommand) {
            this.index = index;
            this.recommand = recommand;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        recommand = new int[M+1];
        picture = new int[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
            recommand[i] = Integer.parseInt(st.nextToken());
        }

        solve();

//        printResult();

        br.close();
    }

    private static void solve(){
        for(int i = 1; i <= M; i++) {
            if(student.size() < N) {
                if(existRecommand(recommand[i])) {
                    picture[recommand[i]]++;
                    continue;
                }
                picture[recommand[i]]++;
                student.add(0, recommand[i]);
                continue;
            }

            printResult();

            if(!student.contains(recommand[i])) {
                int index = removeIndex();
                picture[student.get(index)] = 0;
                student.remove(index);
                student.add(0, recommand[i]);
            }

            picture[recommand[i]]++;
        }
    }

    private static int removeIndex() {
        int min = 10000;
        int min_index = 0;
        for(int i = 0; i < N; i++) {
            if(min >= picture[student.get(i)]) {
                min = picture[student.get(i)];
                min_index = i;
            }
        }

        return min_index;
    }

    private static boolean existRecommand(int num){
        if(picture[num] != 0) return true;
        return false;
    }

    private static void printResult() {
//        Collections.sort(student);
        for(int i : student) System.out.print(i + " ");
        System.out.println();
    }
}