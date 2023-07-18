import java.io.*;
import java.util.*;

// 백준 형식

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/////////////////////구현부//////////////////////
		
		int N = Integer.parseInt(br.readLine());

		int[] num = new int[2000001];
		
		for(int i = 0; i<N; i++)
			num[Integer.parseInt(br.readLine())+1000000]++;
		
		
		for(int i = 0; i<2000001; i++)
			for(int j = 0; j<num[i]; j++)
				bw.write(String.valueOf(i-1000000)+ "\n");
		
		bw.flush();
			
		br.close();
		bw.close();
		////////////////////////////////////////////////
	}

}
