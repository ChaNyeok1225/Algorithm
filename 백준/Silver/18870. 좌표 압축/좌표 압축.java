import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//////////////////////구현부/////////////////////////
		
		int N = Integer.parseInt(br.readLine());
		
		TreeSet<Integer> set = new TreeSet<>();
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			set.add(num);
		}
		
		List<Integer> lst = new ArrayList<>(set);
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < lst.size(); i++)
			map.put(lst.get(i), i);
		
		
		int[] result = new int[N];
		
		for(int i = 0; i < N; i++) {
			result[i] = map.get(arr[i]);
		}
		
		for(int i = 0; i < N; i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
		
		
		////////////////////////////////////////////////////
		br.close();
		bw.close();
		
	}

}
