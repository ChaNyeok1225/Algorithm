import java.util.*;
import java.io.*;

public class Main {

	static int[] arr = new int [1000005];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		char[] ch = br.readLine().toCharArray();
		
		int sum = 0;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < ch.length; i++) {
			if(ch[i] == '(') {
				if(!(stack.isEmpty()) && ch[i-1] == '(')
					sum++;
				stack.add(ch[i]);
			}
			else {
				if(!(stack.isEmpty()) && ch[i-1] == '(') {
					stack.pop();
					
					sum += stack.size();
				}
				else {
					stack.pop();
				}
			}
			
//			System.out.println(sum);
			
		}

		System.out.println(sum);
		
		////////////////////////////////////////////////////
		br.close();
	}

}
