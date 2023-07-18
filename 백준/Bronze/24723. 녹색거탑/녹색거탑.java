import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		///////////////////// 구현부  /////////////////////

		int N = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf((int)Math.pow(2, N)));
		
		bw.flush();
		///////////////////////////////////////////////
		bw.close();
		br.close();
	}


}
