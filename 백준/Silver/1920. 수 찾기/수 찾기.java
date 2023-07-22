import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		///////////////////// 구현부//////////////////////
		
		int n = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			set.add(Integer.parseInt(st.nextToken()));
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			if(set.contains(Integer.parseInt(st.nextToken())))
				System.out.println("1");
			else
				System.out.println("0");
		}
		
		
		
	}
	
}
