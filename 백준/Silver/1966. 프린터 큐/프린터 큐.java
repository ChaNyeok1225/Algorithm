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

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			LinkedList<Docu> link = new LinkedList<>();
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int pri = Integer.parseInt(st.nextToken());
				link.add(new Docu(i,pri));
				map.put(pri, map.getOrDefault(pri, 0) + 1);				
			}
			
			int order = 0;
			loop: while (!map.isEmpty()) {
				Entry<Integer, Integer> entry = map.pollLastEntry();
				int p = entry.getKey();
				int cnt = entry.getValue();
				
				while (cnt != 0) {
					if (link.peekFirst().pri == p) {
						order++;
						cnt--;
						if(link.pollFirst().idx == m)
							break loop;
					}
					else {
						link.add(link.pollFirst());
					}
				}
				
			}
			
			System.out.println(order);
			
		}

		////////////////////////////////////////////////////
		br.close();

	}

}
