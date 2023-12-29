import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        long start = 1, end = k, mid;
        long ans = 0;
        
        while(start <= end) {
        	mid = start + (end - start) / 2;
        	
        	long cnt = 0, val;
        	for(int i = 1; i < n+1; i++) {
        		val = mid / i;
        		cnt += n < val ? n : val;
        	}
        	
        	if(cnt >= k) {
        		end = mid - 1;
        		ans = mid;
        	} else
        		start = mid + 1;
        }
        
        System.out.println(ans);
        
    }
}