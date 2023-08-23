import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static HashMap<Integer, TreeSet<Problem>> group = new HashMap<>();
	static TreeSet<Problem> problems = new TreeSet<>();
	static HashMap<Integer, int[]> pinfo = new HashMap<>();

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		int num, g, l, x;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			add(num, l, g);
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String inst = st.nextToken();

			switch (inst) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				l = Integer.parseInt(st.nextToken());
				g = Integer.parseInt(st.nextToken());

				if (pinfo.containsKey(num))
					remove(num);
				add(num, l, g);
				break;

			case "recommend":
				g = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());

				switch (x) {
				case 1:
					sb.append(group.get(g).last().index + "\n");
					break;
				case -1:
					sb.append(group.get(g).first().index + "\n");
					break;
				}

				break;

			case "recommend2":
				x = Integer.parseInt(st.nextToken());
				
				switch(x) {
				case 1:
					sb.append(problems.last().index+"\n");
					break;
				case -1:
					sb.append(problems.first().index+"\n");
					break;
				}
				break;

			case "recommend3":
				x = Integer.parseInt(st.nextToken());
				l = Integer.parseInt(st.nextToken());
				
				switch(x) {
				case 1:
					Problem cp = problems.ceiling(new Problem(0, l, 0));
					if(cp==null)
						sb.append(-1 + "\n");
					else
						sb.append(cp.index + "\n");
					break;
				case -1:
					Problem fp = problems.floor(new Problem(0, l, 0));
					if(fp==null)
						sb.append(-1 + "\n");
					else
						sb.append(fp.index + "\n");
					break;
				}
				break;

			case "solved":
				num = Integer.parseInt(st.nextToken());
				remove(num);
				break;
			}
		}

		System.out.println(sb);
		
//		System.out.println(problems);
//		for (int x : group.keySet())
//			System.out.println(group.get(x));
	}

	private static void remove(int num) {
		int[] info = pinfo.get(num);
		int l = info[0];
		int g = info[1];

		Problem p = new Problem(num, l, g);
		problems.remove(p);
		group.get(g).remove(p);
		if (group.get(g).isEmpty())
			group.remove(g);
		pinfo.remove(num);
	}

	private static void add(int num, int l, int g) {
		Problem p = new Problem(num, l, g);

		problems.add(p);
		if (!group.containsKey(g))
			group.put(g, new TreeSet<>());
		group.get(g).add(p);
		pinfo.put(num, new int[] { l, g });
	}

	static class Problem implements Comparable<Problem> {
		int index;
		int level;
		int group;

		public Problem(int index, int level, int group) {
			this.index = index;
			this.level = level;
			this.group = group;
		}

		@Override
		public int compareTo(Problem p) {
			if (this.level == p.level)
				return this.index - p.index;
			return this.level - p.level;
		}

		@Override
		public String toString() {
			return "[index=" + index + ", level=" + level + ", group=" + group + "]\n";
		}

	}
}
