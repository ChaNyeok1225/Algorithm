import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class Docu {
	int idx;
	int pri;
	
	public Docu(int idx, int pri) {
		super();
		this.idx = idx;
		this.pri = pri;
	}
	
}


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		String inst = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			inst = st.nextToken();
			
			switch (inst) {
			
			case "push_front" :
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
				
			case "push_back" :
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop_front" :
				if(deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.pollFirst()+"\n");
				break;
				
			case "pop_back" :
				if(deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.pollLast()+"\n");
				break;
				
			case "size" :
				sb.append(deque.size() + "\n");
				break;
				
			case "empty" :
				if(deque.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
				
			case "front" :
				if(deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.peekFirst()+"\n");
				break;
				
			case "back" :
				if(deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.peekLast()+"\n");
				break;
			}
			
		}
		
		System.out.println(sb);
		
		
		////////////////////////////////////////////////////
		br.close();

	}

}
