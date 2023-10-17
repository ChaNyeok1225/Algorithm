import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int size = 2*n;
		
		int[] cb = new int[size];
		boolean[] robot = new boolean[size];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++)
			cb[i] = Integer.parseInt(st.nextToken());

		
		int uidx = 0;
		int bcnt = 0;
		int step = 1;
		
		while(true) {
			
			uidx = (size + uidx - 1) % size;
			
			robot[(uidx+n-1) % size] = false;
			for(int i = uidx + n; i >= uidx; i--) {
				int cur = i % size;
				if(!robot[cur]) continue;
				
				int nxt = (i+1) % size;
				
				if(!robot[nxt] && cb[nxt] > 0) {
					cb[nxt]--;
					robot[nxt]=true;
					robot[cur]=false;
					if(cb[nxt]==0)
						bcnt++;
				}
			}
			robot[(uidx+n-1) % size] = false;
			
			if(!robot[uidx] && cb[uidx] > 0) {
				robot[uidx] = true;
				cb[uidx]--;
				if(cb[uidx]==0)
					bcnt++;
			}
			
			if(bcnt >= k)
				break;
			
			step++;
		}
		
		System.out.println(step);
	}

}