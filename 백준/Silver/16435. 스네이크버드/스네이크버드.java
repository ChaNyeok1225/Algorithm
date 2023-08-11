import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] fruit = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			fruit[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(fruit);
		
		for(int i = 0; i < n; i++) {
			if(fruit[i] <= l) {
				l++;
			} else
				break;
		}
		
		System.out.println(l);
		
		
		////////////////////////////////////////////////////
		br.close();

	}

}
