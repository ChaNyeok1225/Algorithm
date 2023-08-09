import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((n1, n2) ->{
			if(Math.abs(n1) == Math.abs(n2)) return n1 - n2;
			return Math.abs(n1) - Math.abs(n2);
		}); 
		
		while (n-- > 0) {
			int ins = Integer.parseInt(br.readLine());
			
			if(ins == 0) {
				if(q.isEmpty())
					sb.append(0+"\n");
				else
					sb.append(q.poll() + "\n");
			}
			else
				q.add(ins);
		}
		
		System.out.print(sb);
	}
	

}