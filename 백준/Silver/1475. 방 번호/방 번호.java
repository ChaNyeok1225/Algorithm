import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int[] cnt = new int[10];
		
		char[] carr = br.readLine().toCharArray();
		for(int i = 0; i < carr.length; i++) {
			cnt[carr[i]- '0']++;
		}
		cnt[6] += cnt[9];
		cnt[6] = (int) Math.ceil((double)cnt[6]/2);
		cnt[9] = 0;
		
		int needs = Arrays.stream(cnt).max().getAsInt();
		System.out.println(needs);

		////////////////////////////////////////////////////
		br.close();
	}

}
