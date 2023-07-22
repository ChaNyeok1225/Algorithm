import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		///////////////////// 구현부//////////////////////
		
		int l = Integer.parseInt(br.readLine());
		
		char[] ch = br.readLine().toCharArray();
		
		long hash = 0;
		
		for(int i = 0; i < l; i++) {
			int mul = 1;
			for(int j = 0; j < i; j++) {
				mul *= 31;
				mul %= 1234567891;
			}
			
			hash += (ch[i]+1 - 'a') * mul % 1234567891;
		}
		
		System.out.println(hash);
		
	}
	
}
