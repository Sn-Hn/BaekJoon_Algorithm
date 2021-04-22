package 트라이_trie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*

전화번호 목록 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	21207	6539	3768	29.581%
문제
전화번호 목록이 주어진다. 이때, 이 목록이 일관성이 있는지 없는지를 구하는 프로그램을 작성하시오.

전화번호 목록이 일관성을 유지하려면, 한 번호가 다른 번호의 접두어인 경우가 없어야 한다.

예를 들어, 전화번호 목록이 아래와 같은 경우를 생각해보자

긴급전화: 911
상근: 97 625 999
선영: 91 12 54 26
이 경우에 선영이에게 전화를 걸 수 있는 방법이 없다. 
전화기를 들고 선영이 번호의 처음 세 자리를 누르는 순간 바로 긴급전화가 걸리기 때문이다. 따라서, 이 목록은 일관성이 없는 목록이다. 

입력
첫째 줄에 테스트 케이스의 개수 t가 주어진다. (1 ≤ t ≤ 50) 
각 테스트 케이스의 첫째 줄에는 전화번호의 수 n이 주어진다. (1 ≤ n ≤ 10000) 
다음 n개의 줄에는 목록에 포함되어 있는 전화번호가 하나씩 주어진다. 
전화번호의 길이는 길어야 10자리이며, 목록에 있는 두 전화번호가 같은 경우는 없다.

출력
각 테스트 케이스에 대해서, 일관성 있는 목록인 경우에는 YES, 아닌 경우에는 NO를 출력한다.

예제 입력 1 
2
3
976
97625999
91125426
5
113
12340
123440
12345
98346
예제 출력 1 
NO
YES

*/

public class 전화번호목록_트라이_5052 {
	public static class Trie {
		private static int childSize = 10;
		private static TrieNode root;
		
		private class TrieNode {
			TrieNode child[] = new TrieNode[childSize];
			boolean isFinish = false;
		}
		
		public Trie() {
			root = new TrieNode();
		}
		
		private void insert(String insert) {
			TrieNode pointer = this.root;
			
			for(int i = 0; i < insert.length(); i++) {
				int index = insert.charAt(i) - '0';
				if(pointer.child[index] == null) {
					pointer.child[index] = new TrieNode();
				}
				
				pointer = pointer.child[index];
			}
			
			pointer.isFinish = true;
		}
		
		private boolean search(String target) {
			TrieNode pointer = this.root;
			
			for(int i = 0; i < target.length(); i++) {
				int index = target.charAt(i) - '0';
				if(pointer.child[index] == null) {
					return false;
				}
				
				pointer = pointer.child[index];
				
				// 길이가 끝까지 안갔는데 isFinish가 발견되면 중간길이의 다른문자가 있는 것.
				if(i < target.length()-1 && pointer.isFinish) {
					return false;
				}
			}
			
			return (pointer != null) && pointer.isFinish;
		}
	}
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] num = new String[n];
            Trie trie = new Trie();

            for (int j = 0; j < n; j++) {
                num[j] = br.readLine();
                trie.insert(num[j]);
            }
            
            boolean isChecked = true;

            for(int j = 0; j <n; j++) {
            	if(!trie.search(num[j])) {
            		isChecked = false;
            		break;
            	}
            }

            if (isChecked) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}