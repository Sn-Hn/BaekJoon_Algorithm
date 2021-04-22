package 트라이_trie;

// 트라이란 문자열 탐색에 아주 효율적인 자료구조
// 트라이는 문자열 탐색에서 아주 빠른 속도를 가지고 있지만
// 메모리를 많이 쓴다는 단점이 있다.
public class TrieStudy {
	// 나올 수 있는 모든 경우의 수는 A에서 Z사이
	private static int childSize = 'Z' - 'A';
	
	// ROOT는 값을 가지지 않고 오직 TrieNode 하나만을 가진다.
	private static trieNode root;
	
	// 생성자에서 Root에 TrieNode를 설정해준다.
	public TrieStudy() {
		root = new trieNode();
	}
	
	private static class trieNode {
		trieNode child[] = new trieNode[childSize];
		boolean isFinish = false;
	}
	
	// Trie에 문자열을 삽입하는 과정
	private static void insert(String wantInsert) {
		
		// 처음은 root에서 시작한다.
		trieNode pointer = root;
		
		for(int i = 0; i < wantInsert.length(); i++) {
			
			// 입력받은 String을 단계적으로 처리하는 for를 돌리며 넣어준다.
			int index = wantInsert.charAt(i) - 'A';
			
			// 만약에 child[index]가 null이라면 처음 가보는 곳.
			// 없다는 이야기니 trieNode를 설정
			if(pointer.child[index] == null) {
				pointer.child[index] = new trieNode();
			}
			
			// child를 가리키는 주소값을 업데이트
			pointer = pointer.child[index];
		}
		
		// 모든 for문이 끝나서 가리키고 있는 주소값에 마지막이라는 것을 체크
		pointer.isFinish = true;
	}
	
	// Trie에 넣어둔 문자열을 찾는 과정
	private boolean search(String target) {
		
		// root에서 시작
		trieNode pointer = root;
		
		// 한 글자씩 탐색
		for(int i = 0; i < target.length(); i++) {
			int index = target.charAt(i) - 'A';
			
			// 만약 현재 글자에 해당하는 index가 없다면 그 단계에 없다는 것
			if(pointer.child[index] == null) {
				return false;
			}
			
			pointer = pointer.child[index];
		}
		
		// 전체가 끝나서 pointer에 마지막 값을 저장했을 때 null이라면 target의 마지막 문자가 없는 것이다.
		// 또한 현재 pointer에 마지막글자를 뜻하는 isFinish가 true여야 글자수도 맞고, 중간글자도 맞게 검색한다.
		
		return (pointer != null) && pointer.isFinish;
	}
	
}
