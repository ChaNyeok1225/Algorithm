import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		// cursor와 스택 생성
		int cursor = 0;
		Stack<Integer> stack = new Stack<>();
		
		// n번 돌면서 num을 받고 cursor 값에 따라 stack 정리
		
		int num;
		int top;
		for(int i = 0; i < n; i++) {
			num = Integer.parseInt(br.readLine());
			
			while (cursor < num) {
				cursor++;
				stack.add(cursor);
				sb.append("+\n");
			}
			
			top = stack.peek();
			
			if(top != num)
				break;
			else {
				stack.pop();
				sb.append("-\n");
			}
			
		}
		
		if(!stack.isEmpty()) {
			sb.setLength(0);
			sb.append("NO");
		}
		
		System.out.println(sb);
		
		////////////////////////////////////////////////////
		br.close();

	}

}
