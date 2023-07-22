import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////
		
		int n = Integer.parseInt(br.readLine());
		
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int inst = Integer.parseInt(st.nextToken());
			
			switch (inst) {
			case 1:
				stack.add(Integer.parseInt(st.nextToken()));
				break;

			case 2:
				if(stack.isEmpty())
					sb.append("-1\n");
				else {
					sb.append(stack.pop()+"\n");
				}
				break;
				
			case 3:
				sb.append(stack.size()+"\n");
				break;
				
			case 4:
				if(stack.isEmpty())
					sb.append("1\n");
				else {
					sb.append("0\n");
				}
				break;
				
			case 5:
				if(stack.isEmpty())
					sb.append("-1\n");
				else {
					sb.append(stack.peek()+"\n");
				}
				break;
			default:
				break;
			}
			
		}
		System.out.println(sb);
		
	}
	
}
