import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		TreeMap<Integer, TreeSet<Integer>> tm = new TreeMap<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			if(!tm.containsKey(l))
				tm.put(l, new TreeSet<>());
			
			tm.get(l).add(p);
			hm.put(p,l);
		}
		
		int m = Integer.parseInt(br.readLine());
		
		int pl, key;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			String inst = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			switch(inst) {
			case "recommend" :
				if(num == 1) {
					key = tm.lastKey();
					sb.append(tm.get(key).last()+"\n");
				}else {
					key = tm.firstKey();
					sb.append(tm.get(key).first()+"\n");
				}
				break;
				
			case "add" :
				if(hm.containsKey(num)) {
					pl = hm.get(num);
					tm.get(pl).remove(num);
				}
				pl = Integer.parseInt(st.nextToken());
				if(!tm.containsKey(pl))
					tm.put(pl, new TreeSet<>());
				tm.get(pl).add(num);
				hm.put(num, pl);
				break;
				
			case "solved" :
				pl = hm.get(num);
				TreeSet ts = tm.get(pl);
				ts.remove(num);
				if(ts.size() == 0)
					tm.remove(pl);
				hm.remove(num);
				break;
			}
		}
		
		System.out.println(sb);
	}

}
