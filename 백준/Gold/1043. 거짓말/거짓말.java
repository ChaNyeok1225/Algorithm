import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        
        st = new StringTokenizer(br.readLine());
        
        Queue<Integer> q = new ArrayDeque<>();
        
        boolean[] personVisited = new boolean[n+1];
        boolean[] partyVisited = new boolean[m];
        
        int cnt = Integer.parseInt(st.nextToken());
        for(int i = 0; i < cnt; i++) {
        	int knowPerson = Integer.parseInt(st.nextToken());
        	personVisited[knowPerson] = true;
        	q.offer(knowPerson);
        }
        
        List<Integer>[] personToParty = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++)
        	personToParty[i] = new ArrayList<>();
        
        List<Integer>[] partyInPerson = new ArrayList[m];
        for(int i = 0; i < m; i++) {
        	partyInPerson[i] = new ArrayList<>();
        	
        	st = new StringTokenizer(br.readLine());
        	cnt = Integer.parseInt(st.nextToken());
        	
        	for(int j = 0; j < cnt; j++) {
        		int pn = Integer.parseInt(st.nextToken());
        		partyInPerson[i].add(pn);
        		personToParty[pn].add(i);
        	}
        }
        
        int ans = m;
       
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	
        	for(int party : personToParty[cur]) {
        		if(partyVisited[party]) continue;
        		partyVisited[party] = true;
        		ans--;
        		for(int pn : partyInPerson[party]) {
        			if(personVisited[pn]) continue;
        			personVisited[pn] = true;
        			q.offer(pn);
        		}
        	}
        }
        
        System.out.println(ans);
    }
}