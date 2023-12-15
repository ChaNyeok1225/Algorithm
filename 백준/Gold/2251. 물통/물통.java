import java.io.*;
import java.util.*;

//start = 2023. 12. 15  12 : 21
//end = 2023. 12. 15
public class Main {

	static class Data {
		int water[] = new int[3];

		public Data(int a, int b, int c) {
			super();
			this.water[0] = a;
			this.water[1] = b;
			this.water[2] = c;
		}

		public int hashCode() {
			return 1;
		}

		public boolean equals(Object obj) {
			Data o = (Data) obj;

			if (this.water[0] == o.water[0] && this.water[1] == o.water[1] && this.water[2] == o.water[2])
				return true;
			return false;
		}

		public String toString() {
			return Arrays.toString(water);
		}
	}

	static Set<Data> set = new HashSet<>();
	static int max[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		max = new int[3];
		max[0] = Integer.parseInt(st.nextToken());
		max[1] = Integer.parseInt(st.nextToken());
		max[2] = Integer.parseInt(st.nextToken());

		Data data = new Data(0, 0, max[2]);
		set.add(data);

		dfs(new int[] { 0, 0, max[2] });
		
		TreeSet<Integer> ts = new TreeSet<>();
		
		for(Data d : set) {
			if(d.water[0] == 0)
				ts.add(d.water[2]);
		}
		
		for(int v : ts)
			sb.append(v).append(" ");
		
		System.out.println(sb);
	}

	static void dfs(int[] water) {
		for (int i = 0; i < 3; i++) {
			int w = water[i];

			if (w == 0)
				continue;
			
			for (int j = 0; j < 3; j++) {
				if (i == j || water[j] == max[j])
					continue;
				
				int[] tmp = water.clone();
				Data data;
				if(tmp[i] > max[j] - tmp[j]) {
					tmp[i] = tmp[i] - (max[j] - tmp[j]);
					tmp[j] = max[j];
				} else {
					tmp[j] = tmp[j] + tmp[i];
					tmp[i] = 0;
				}
				
				data = new Data(tmp[0], tmp[1], tmp[2]);
				if(!set.contains(data)) {
					set.add(data);
					dfs(tmp);
				}
			}
		}
	}

}