import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> link = new LinkedList<Integer>();
		
		for(int i = 1; i < n + 1; i++)
			link.add(i);
		
		int step = -1;
		
		sb.append("<");
		while(!link.isEmpty()) {
			step = (step + k) % link.size();
			sb.append(link.remove(step--) + ", ");
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb);
		
		////////////////////////////////////////////////////
		br.close();

	}

}
