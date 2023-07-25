import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] pos = new int[200005];
		
		LinkedList<Integer> q = new LinkedList<>();
		q.add(n);
		
		while(!q.isEmpty()) {
			int p = q.pop();
			if(p == k)
				break;
			
			if (p + 1 < 200005 && pos[p+1] == 0) {
				pos[p+1] = pos[p] + 1;
				q.add(p+1);
			}
			if (p - 1 >= 0 && pos[p-1] == 0) {
				pos[p-1] = pos[p] + 1;
				q.add(p-1);
			}
			if (2 * p < 200005 && pos[2*p] == 0) {
				pos[2*p] = pos[p] + 1;
				q.add(2*p);
			}
		}
		
		System.out.println(pos[k]);
		

	}

}
