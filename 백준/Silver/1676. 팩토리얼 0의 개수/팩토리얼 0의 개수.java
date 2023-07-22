import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////
		
		int num = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		 
		while (num >= 5) {
			cnt += num / 5;
			num /= 5;
		}
		
		System.out.println(cnt);
	}
	
}
