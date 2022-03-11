package todays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11653
 */
public class 소인수분해_11653 {
  private static int N;

  private static void splitNumberOptimization(int number) {
    StringBuilder result = new StringBuilder();
    for (int i = 2; i * i <= number; i++) {
      while (number % i == 0) {
        number /= i;
        result.append(i).append("\n");
      }
    }

    if (number != 1) {
      result.append(number);
    }

    System.out.println(result);
  }

  private static void splitNumber(int number) {
    StringBuilder result = new StringBuilder();
    int i = 2;
    while (number > 1) {
      if (number % i == 0) {
        number /= i;
        result.append(i).append("\n");
        i = 2;
        continue;
      }
      i ++;
    }

    System.out.println(result);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    splitNumberOptimization(N);

    br.close();
  }
}