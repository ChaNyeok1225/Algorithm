import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			String inst = st.nextToken();
			
			switch (inst) {
			case "push":
				deque.add(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				if(deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.pop() + "\n");
				break;
				
			case "size":
				sb.append(deque.size() + "\n");
				break;
				
			case "empty":
				if(deque.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
				
			case "front":
				if(deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.peekFirst() + "\n");
				break;
				
			case "back":
				if(deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.peekLast() + "\n");
				break;
				
			default:
				break;
			}
		}
		
		System.out.println(sb);
		
		
		////////////////////////////////////////////////////
		br.close();

	}

}
