import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int r = Integer.parseInt(br.readLine());

		int[] student = new int[101];

		ArrayList<int[]> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < r; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			if(student[number] == 0) {
				if(list.size() == n) {
					student[list.get(n-1)[0]] = 0;
					list.remove(n-1);
				}
				student[number]++;
				list.add(new int[] {number, i});
				
			}
			else 
				student[number]++;

			
			Collections.sort(list, (int[] a, int[] b) -> {
				if(student[a[0]] == student[b[0]])
					return b[1] - a[1];
				return student[b[0]] - student[a[0]];
			});
			
//			for(int[] p : list) {
//				System.out.print(Arrays.toString(p) + " ");
//			}
//			System.out.println();System.out.println();
		}
		
		for(int i = 1; i < 101; i++) {
			if(student[i] > 0)
				sb.append(i+" ");
		}

		System.out.println(sb);
	}
}
