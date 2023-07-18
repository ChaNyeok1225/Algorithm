import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		//////////////////////구현부/////////////////////////
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums[i] = num;
		}
		
		int max = Arrays.stream(nums).max().getAsInt();
		int min = Arrays.stream(nums).min().getAsInt();
		
		bw.write(String.valueOf(max*min));
		
		
		bw.flush();
		
		////////////////////////////////////////////////////
		br.close();
		bw.close();
		
	}

}
