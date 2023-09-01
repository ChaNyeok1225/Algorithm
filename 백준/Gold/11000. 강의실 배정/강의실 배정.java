import java.io.*;
import java.util.*;

public class Main {

	static boolean[] chk;
	static int n, end;
	static TreeSet<int[]> tm = new TreeSet<>((a,b) -> {
		if(a[0] == b[0]) return a[2] - b[2];
		return a[0] - b[0];
	});
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			tm.add(new int[] {s,e,i});
		}

//		Iterator<int[]> iter = tm.iterator();
//		while(iter.hasNext()) {
//			System.out.println(Arrays.toString(iter.next()));
//		} System.out.println();
			
		
		int res = 0, etime = 0;
		while(!tm.isEmpty()) {
			
			int[] c = tm.pollFirst();
			res++;
			etime = c[1];
//			System.out.println(Arrays.toString(c));
			
			while(!tm.isEmpty()) {
				int[] p = tm.ceiling(new int[] {etime,0,0});
//				System.out.println(Arrays.toString(p));
				if(p == null)
					break;
				else {
					etime = p[1];
					tm.remove(p);
				}
			}
		}
		
		System.out.println(res);
		
		

	}
	

}