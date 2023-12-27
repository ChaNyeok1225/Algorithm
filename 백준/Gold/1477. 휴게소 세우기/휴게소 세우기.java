import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        int[] rest = new int[n+2];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++) 
        	rest[i] = Integer.parseInt(st.nextToken());
        rest[0] = 0;
        rest[n+1] = l;
        Arrays.sort(rest);
        
        int start = 1, end = l, mid;
        int ans = 0;
        
        while(start <= end) {
        	mid = start + (end - start) / 2;
        	
        	int cnt = 0;
        	for(int i = 1; i < n+2; i++) {
        		int val = (rest[i] - rest[i-1] - 1) / (mid);
        		cnt += val;
        	}
        	
        	if(cnt <= m) {
        		end = mid - 1;
        		ans = mid;
        	} else
        		start = mid + 1;
        }
        
        System.out.println(ans);
        
        
        
    }
}