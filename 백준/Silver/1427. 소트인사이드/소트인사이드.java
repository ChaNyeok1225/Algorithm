import java.io.*;
import java.util.*;

// 백준 형식

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/////////////////////구현부//////////////////////
		
		int N = Integer.parseInt(br.readLine());

		List<Integer> num = new ArrayList<>();

		while(N > 0) {
			num.add(N%10);
			N /= 10;
		}
		
		Collections.sort(num, Collections.reverseOrder());
		
		for(int i = 0; i<num.size(); i++)
			bw.write(String.valueOf(num.get(i)));
		
		bw.flush();
			
		br.close();
		bw.close();
		////////////////////////////////////////////////
	}

}
