import java.io.*;
import java.util.*;

public class Main {
	
	static int alpha[], setVal[], idx, ans, n, mlen;
	static boolean vis[];
	static char words[][];
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] use = new boolean[26];
        alpha = new int[10];
        vis = new boolean[10];
        setVal = new int[26];
        idx = 0;
        
        n = Integer.parseInt(br.readLine());
        words = new char[n][];
        for(int i = 0; i < n; i++) {
        	char[] word = br.readLine().toCharArray();
        	int len = word.length;
        	mlen = mlen > len ? mlen : len;
        	words[i] = new char[len];
        	for(int j = len-1; j >= 0; j--) {
        		if(!use[word[j] - 'A']) {
        			use[word[j] - 'A'] = true;
        			alpha[idx++] = word[j] - 'A';
        		}
        		words[i][len-j - 1] = word[j];
        	}
        }
        
        
        dfs(0);
        
        
        System.out.println(ans);
    }
    
    static void dfs(int cnt) {
    	if(cnt == idx) {
    		int total = 0;
    		
    		for(int i = 0; i < mlen; i++) {
    			int sum = 0;
    			for(int j = 0; j < n; j++) {
    				if(words[j].length <= i) continue;
    				sum += setVal[words[j][i] - 'A'];
    			}
    			total += sum * (Math.pow(10, i));
    		}
    		ans = ans > total ? ans : total;
    		return;
    	}
    	
    	for(int i = 0; i < 10; i++) {
    		if(vis[i]) continue;
    		vis[i] = true;
    		setVal[alpha[cnt]] = i;
    		dfs(cnt+1);
    		vis[i] = false;
    	}
    	
    	
    }
    
}