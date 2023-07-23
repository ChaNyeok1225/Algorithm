import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		long sum = 0;
		int cnt = 0, height;
		for(int i = 0; i < n; i++) {
			height = Integer.parseInt(br.readLine());
			cnt = 0;
			while(!(stack.isEmpty()) && stack.peek() <= height) {
				stack.pop();
				sum += cnt;
				cnt++;
			}
			
			if(!(stack.isEmpty())) {
				sum += cnt * stack.size();
			}
			stack.add(height);
		}
		
		cnt = 0;
		while(!(stack.isEmpty())) {
			stack.pop();
			sum += cnt;
			cnt++;
		}
		
		System.out.println(sum);

		////////////////////////////////////////////////////
		br.close();
	}

}
