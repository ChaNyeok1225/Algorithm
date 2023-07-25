import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////

		char[] ch = br.readLine().toCharArray();

		Stack<Character> stack = new Stack<>();

		int sum = 0;
		int idx = 0;
		int cal = 1;
		l: for (int i = 0; i < ch.length; i++) {

			switch (ch[i]) {

			case '(':
				cal *= 2;
				stack.add('(');
				break;

			case '[':
				cal *= 3;
				stack.add('[');
				break;

			case ')':
				if (!(stack.isEmpty())) {
					if (ch[i - 1] == '(')
						sum += cal;
					if (stack.peek() != '(')
						break l;
				} else {
					sum = 0;
					break l;
				}
				stack.pop();
				cal /= 2;
				break;

			case ']':
				if (!(stack.isEmpty())) {
					if (ch[i - 1] == '[')
						sum += cal;
					if (stack.peek() != '[')
						break l;
				} else {
					sum = 0;
					break l;
				}
				stack.pop();
				cal /= 3;
				break;
			}

//			System.out.println("cal : " + cal + " sum : " + sum);
		}
		if (!(stack.isEmpty()))
			sum = 0;

		System.out.println(sum);
	}

}
