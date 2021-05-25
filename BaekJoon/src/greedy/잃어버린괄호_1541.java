package greedy;
/*

잃어버린 괄호 분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
2 초   128 MB   27321   12906   10447   47.445%
문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

출력
첫째 줄에 정답을 출력한다.

예제 입력 1
55-50+40
예제 출력 1
-35

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 잃어버린괄호_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        List<Integer> numbers = new ArrayList<>();

        int result = 0;

        for (int i = 0; i < input.length; i++) {
            String[] addNumbers = input[i].split("\\+");
            int sum = add(addNumbers);
            if (i == 0) {
                result = sum;
                continue;
            }

            result -= sum;
        }

        System.out.println(result);

        br.close();
    }

    private static int add(String[] numbers) {
        int sum = 0;
        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private static void print(String[] value) {
        for (String str : value) {
           System.out.print(str + " ");
        }
        System.out.println();
    }
}