package 스터디_복습.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lie {
  private static int N;
  private static int M;
  private static int truthPeopleCount;
  private static int[] people;
  private static int[] truthPeople;
  private static List[] attendPeople;

  private static int countLie() {
    int lie = M;
    if (truthPeopleCount == 0) {
      return lie;
    }
    for (List<Integer> attendPerson : attendPeople) {
      if (attendPerson == null) {
        continue;
      }
      for (int i = 0; i < truthPeopleCount; i++) {
        if (find(truthPeople[i]) == find(attendPerson.get(0))) {
          lie --;
          break;
        }

      }
    }

    return lie;
  }

  private static int find(int person) {
    if (people[person] == person) {
      return person;
    }

    return people[person] = find(people[person]);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a > b) {
      people[a] = b;
    } else {
      people[b] = a;
    }
  }

  private static boolean isTruthPerson(int person) {
    return people[person] == -1 ? true : false;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    truthPeopleCount = Integer.parseInt(st.nextToken());
    people = new int[N + 1];
    attendPeople = new ArrayList[M + 1];
    truthPeople = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      people[i] = i;
    }

    for (int i = 0; i < truthPeopleCount; i++) {
      truthPeople[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      attendPeople[i] = new ArrayList();
      int attendPeopleCount = Integer.parseInt(st.nextToken());
      int prevPerson = -1;
      for (int j = 0; j < attendPeopleCount; j++) {
        int attendPerson = Integer.parseInt(st.nextToken());
        attendPeople[i].add(attendPerson);
        if (prevPerson != -1) {
          union(prevPerson, attendPerson);
          continue;
        }

        prevPerson = attendPerson;
      }
    }

    System.out.println(countLie());

    br.close();
  }
}
