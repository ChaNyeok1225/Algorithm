import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		////////////////////// 구현부/////////////////////////

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int[] student = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < n+1; i++) 
				student[i] = Integer.parseInt(st.nextToken());

			int[] studentGroup = new int[n + 1];
			
			for(int i = 1; i < n+1; i++) {
				int nxt = i;
				
				if(studentGroup[nxt] == 0) {
					while(true) {
//						System.out.println("i : " + i + ", " + studentGroup[nxt]);
						studentGroup[nxt] = i;
						nxt = student[nxt];
						
						if(studentGroup[nxt] == i) {
							while(studentGroup[nxt] != -1) {
								studentGroup[nxt] = -1;
								nxt = student[nxt];
							}
							break;
						}
						else if (studentGroup[nxt] != 0)
							break;
					}
				}
			}
//			System.out.println(Arrays.toString(studentGroup));
			
			int cnt = 0;
			for(int i = 1; i < n+1; i++ )
				if(studentGroup[i] != -1)
					cnt ++;

			System.out.println(cnt);
		}


		////////////////////////////////////////////////////
		br.close();
	}


}
