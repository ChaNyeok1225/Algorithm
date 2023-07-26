import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////

		st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[] floors = new int[f + 1];
		Arrays.fill(floors, -1);
		
		
		LinkedList<Integer> q = new LinkedList<>();
		q.add(s);
		floors[s] = 0;

		
		while (!q.isEmpty()) {
			int p = q.pop();
			for(int nxt : new int[] {p + u, p - d}) {
				if(nxt > f || nxt <= 0 || floors[nxt] != -1)
					continue;
				
				floors[nxt] = floors[p] + 1;
				q.add(nxt);
			}
		}

		if(floors[g] == -1)
			System.out.println("use the stairs");
		else 
			System.out.println(floors[g]);
	}

}
