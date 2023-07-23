import java.util.*;
import java.io.*;

class A {
	int num;
	int idx;
	public A(int num, int idx) {
		super();
		this.num = num;
		this.idx = idx;
	}
	
	
	
}


public class Main {

	static int[] arr = new int [1000005];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		
		Stack<A> stack = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!(stack.isEmpty()) && stack.peek().num < num) {
				A a = stack.pop();
				arr[a.idx] = num;
			}
			
			stack.add(new A(num, i));
			
		}
		
		while(!(stack.isEmpty())) {
			A a = stack.pop();
			arr[a.idx] = -1;
		}
		
		for(int i = 0; i < n; i++)
			sb.append(arr[i] + " ");
		
		System.out.println(sb);

		////////////////////////////////////////////////////
		br.close();
	}

}
