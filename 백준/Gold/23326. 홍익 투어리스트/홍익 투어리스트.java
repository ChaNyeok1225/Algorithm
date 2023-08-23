import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st=  new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q= Integer.parseInt(st.nextToken());
		
		boolean[] lm = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		TreeSet<Integer> ts = new TreeSet<>();
		for(int i = 1; i < n+1; i++)  {
			lm[i] = st.nextToken().equals("1")? true: false;
			if(lm[i]) {
				ts.add(i);
				ts.add(i+n);
			}
		}
		
		int pos = 1;
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int inst = Integer.parseInt(st.nextToken());
			
			switch(inst) {
			case 1 :
				int num = Integer.parseInt(st.nextToken());
				if(lm[num]) {
					ts.remove(num);
					ts.remove(num+n);
					lm[num] = false;
				} else {
					ts.add(num);
					ts.add(num+n);
					lm[num] = true;
				}
				break;
				
			case 2 :
				int mv = Integer.parseInt(st.nextToken());
				pos = (pos + mv) % n;
				if(pos == 0) pos = n;
				break;
				
			case 3:
				if(!ts.isEmpty()) {
					if(ts.contains(pos)) 
						sb.append(0 + "\n");
					else {
						int np = ts.higher(pos);
						sb.append(np-pos + "\n");
					}
				} else 
					sb.append(-1 + "\n");
				break;
			}
		}
		System.out.println(sb);
		
	}

}
