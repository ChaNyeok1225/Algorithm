import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		String n;
		while((n = br.readLine()) != null) {
			int num = (int) Math.pow(3, Integer.parseInt(n));
			sb.setLength(0);
			for(int i = 0; i < num; i++)
				sb.append("-");
			
			replace(sb, 0, num);
			
			System.out.println(sb);
		}
		
		
		////////////////////////////////////////////////////
		br.close();
	}
	
	static void replace(StringBuilder sb, int s, int size) {
		if(size == 1)
			return;
		//System.out.println(sb);
		
		int d = size / 3;
		
		for(int i = s + d; i < s + d + d; i++)
			sb.setCharAt(i, ' ');
		
		replace(sb, s, d);
		replace(sb, s + d + d, d);		
		
	}
	

}
