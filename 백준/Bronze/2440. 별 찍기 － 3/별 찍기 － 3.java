import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i< n; i++) {
			for(int j = n-i; j >0; j--)
				sb.append("*");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}