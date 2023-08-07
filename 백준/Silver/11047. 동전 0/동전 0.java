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
		int k = Integer.parseInt(st.nextToken());
		
		int[] value = new int[n];
		for(int i = 0; i < n; i++)
			value[i] = Integer.parseInt(br.readLine());
		
		int total = 0;
		for(int i = n-1; i >= 0; i--) {
			total += k / value[i];
			k %= value[i];
		}
		
		System.out.println(total);
		////////////////////////////////////////////////////
		br.close();

	}


}
