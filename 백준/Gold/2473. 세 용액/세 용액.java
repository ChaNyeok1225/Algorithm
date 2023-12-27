import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] fluid = new int[n];
        
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        	fluid[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(fluid);
        
        long ans = Long.MAX_VALUE;
        int[] res = new int[3];
        
        
        for(int i = 0; i < n-2; i++) {
        	for(int j = i+1; j < n-1; j++) {
        		
        		int start = j + 1, end = n - 1, mid;
        		
        		while(start <= end) {
        			mid = start + (end - start) / 2;
        			
        			long value = (long)fluid[i] + fluid[j] + fluid[mid];
        			
        			if(ans > Math.abs(value)) {
        				ans = Math.abs(value);
        				res[0] = fluid[i];
        				res[1] = fluid[j];
        				res[2] = fluid[mid];
        			}
        			
        			if(value > 0)
        				end = mid - 1;
        			else if(value < 0)
        				start = mid + 1;
        			else if (value == 0)
        				break;
        			
        		}
        		
        		
        	}
        }
        
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}