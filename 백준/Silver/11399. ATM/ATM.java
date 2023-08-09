import java.util.*;
import java.io.*;

public class Main {

	static HashMap<Integer, HashSet<Integer>> hm;
	static int[] popul;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int sum = 0;
		int s = 0;
		for(int i = 0; i < n; i++) {
			s += arr[i];
			sum += s;
		}
		
		System.out.println(sum);
		////////////////////////////////////////////////////
		br.close();

	}


}
