import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;
	static boolean[] vis;

	
	

	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		vis = new boolean[n];
		func(0, 0);

		System.out.println(sb);
		////////////////////////////////////////////////////
		br.close();
	}

	static void func(int idx, int cnt) {
//		System.out.println(Arrays.toString(vis));
		if (cnt == m) {
			for(int i = 0; i < n; i++) {
				if(vis[i] == true) {
					sb.append((i+1) + " ");
				}
			}
			sb.append("\n");
			return;
		}	
		
		for(int i = idx; i < n; i++) {
			if(vis[i] == true) continue;
			
			vis[i] = true;
			func(i + 1, cnt + 1);
			vis[i] = false;
			
		}
		
	}

}
