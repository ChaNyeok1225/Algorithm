import java.util.*;
import java.io.*;

public class Main {
	static int min = Integer.MAX_VALUE;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());

		int[] D = new int[n+1];
		
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		q.add(n);
		
		while(!q.isEmpty()) {
			int w = q.poll();
			
			if(w - 3 >= 0 && D[w-3] == 0) {
				D[w-3] = D[w] + 1;
				q.offer(w-3);
			}
			
			if(w - 5 >= 0 && D[w-5] == 0) {
				D[w-5] = D[w] + 1;
				q.offer(w-5);
			}
			
		}
		
//		System.out.println(Arrays.toString(D));
		
		if(D[0] == 0)
			System.out.println(-1);
		else
			System.out.println(D[0]);
		
		////////////////////////////////////////////////////
		br.close();

	}


}
