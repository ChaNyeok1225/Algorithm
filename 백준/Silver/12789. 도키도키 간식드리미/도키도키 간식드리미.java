import java.io.*;
import java.util.*;


// 20230803 - SWEA 2001 파리퇴치
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int num;
		st = new StringTokenizer(br.readLine());
		
		int nxtNum = 1;
		for(int i = 0; i < n; i++) {
			
			while(!stack.isEmpty() && stack.peek() == nxtNum) {
				nxtNum++;
				stack.pop();
			}
			
			num = Integer.parseInt(st.nextToken());
			
			if(num == nxtNum) {
				nxtNum++;
				continue;
			}
			else {
				stack.add(num);
			}
		}
		
		while(!stack.isEmpty()) {
			int top = stack.peek();
			
			if(top != nxtNum++) {
				break;
			}
			stack.pop();
		}
		
		if(!stack.isEmpty())
			System.out.println("Sad");
		else
			System.out.println("Nice");
	}

}
