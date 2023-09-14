import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		long ans = 0;
		for(int i = 0; i < n; i++) {
			int h = Integer.parseInt(br.readLine());
			while(!stack.isEmpty() && stack.peek() <= h) {
				stack.pop();
			}
			ans += stack.size();
			stack.add(h);
			
		}
		System.out.println(ans);
		
	}

}