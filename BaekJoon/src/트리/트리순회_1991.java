package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

트리 순회 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	23121	14389	10976	63.659%
문제
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.



예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다. 
둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 
노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현된다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.

예제 입력 1 
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
예제 출력 1 
ABDCEFG
DBAECFG
DBEGFCA

*/

public class 트리순회_1991 {
	private static int N;
	
	// 이진 트리 (부모)
	private static class Node {
		char data;
		Node left;
		Node right;
		
		public Node(char data) {
			this.data = data;
		}
	}
	
	private static class Tree {
		Node root;
		
		// 트리 생성
		public void createNode(char data, char leftData, char rightData) {
			if(root == null) {
				root = new Node(data);
				
				if(leftData != '.') {
					root.left = new Node(leftData);
				}
				
				if(rightData != '.') {
					root.right = new Node(rightData);
				}
			}else {
				searchNode(root, data, leftData, rightData);
			}
		}
		
		// 검색
		public void searchNode(Node root, char data, char leftData, char rightData) {
			// 부모가 없으면 찾을 노드 X
			if(root == null) {
				return;
			}else if(root.data == data) {
				if(leftData != '.') {
					root.left = new Node(leftData);
				}
				if(rightData != '.') {
					root.right = new Node(rightData);
				}
			}else {
				searchNode(root.left, data, leftData, rightData);
				searchNode(root.right, data, leftData, rightData);
			}
		}
		
		// 전위 순회 : 부모 -> 왼쪽 자식 -> 오른쪽 자식
		public void preOrder(Node root) {
			System.out.print(root.data);
			if(root.left != null) preOrder(root.left);
			if(root.right != null) preOrder(root.right);
		}
		
		// 중위 순회 : 왼쪽 자식 -> 부모 -> 오른쪽 자식
		public void inOrder(Node root) {
			if(root.left != null) inOrder(root.left);
			System.out.print(root.data);
			if(root.right != null) inOrder(root.right);
		}
		
		// 후위 순회 : 왼쪽 자식 -> 오른쪽 자식 -> 부모
		public void postOrder(Node root) {
			if(root.left != null) postOrder(root.left);
			if(root.right != null) postOrder(root.right);
			System.out.print(root.data);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		Tree tree = new Tree();
		
		for(int i = 0; i < N; i++) {
			char[] data;
			data = br.readLine().replaceAll(" ", "").toCharArray();
			// 첫줄로 트리를 만든다
			tree.createNode(data[0], data[1], data[2]);
		}
		
		// 전위 순회
		tree.preOrder(tree.root);
		System.out.println();
		
		// 중위 순회
		tree.inOrder(tree.root);
		System.out.println();
		
		// 후외 순회
		tree.postOrder(tree.root);
		System.out.println();
		
		br.close();
	}
}
