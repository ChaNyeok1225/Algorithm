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
	static int[] arr;

	
	

	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		func(0);

		System.out.println(sb);
		////////////////////////////////////////////////////
		br.close();
	}

	static void func(int cnt) {
//		System.out.println(Arrays.toString(vis));
		if (cnt == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}	
		
		for(int i = 0; i < n; i++) {
			arr[cnt] = i+1;
			func(cnt+1);
			
		}
		
	}

}
