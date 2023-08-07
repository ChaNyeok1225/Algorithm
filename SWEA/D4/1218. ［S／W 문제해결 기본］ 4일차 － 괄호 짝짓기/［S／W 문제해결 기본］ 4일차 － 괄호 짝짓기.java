import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		Stack<Character> stack = new Stack<>();

		for (int tc = 1; tc < 11; tc++) {
			int l = Integer.parseInt(br.readLine()); 
			char[] c = br.readLine().toCharArray();

			int res = 1;
			// 0부터 문자열의 길이만큼
			L: for (int i = 0; i < c.length; i++) {
				// 문자에 따라 실행 분기
				switch (c[i]) {
				// 여는 괄호라면 add
				case '(':
				case '[':
				case '{':
				case '<':
					stack.add(c[i]);
					break;
					
				// 닫는 괄호일 때, 짝이 맞지 않거나 스택이 Empty면 종료
				// 짝이 맞다면 짝을 pop()
				case ')':
					if(stack.isEmpty() || stack.peek() != '(') {
						res = 0;
						break L;
					} else {
						stack.pop();
					}
					break;

				case ']':
					if(stack.isEmpty() || stack.peek() != '[') {
						res = 0;
						break L;
					} else {
						stack.pop();
					}
					break;
				case '}':
					if(stack.isEmpty() || stack.peek() != '{') {
						res = 0;
						break L;
					} else {
						stack.pop();
					}
					break;
				case '>':
					if(stack.isEmpty() || stack.peek() != '<') {
						res = 0;
						break L;
					} else {
						stack.pop();
					}
					break;
				}

			}

			System.out.printf("#%d %d\n", tc, res);
		}

	}

}
