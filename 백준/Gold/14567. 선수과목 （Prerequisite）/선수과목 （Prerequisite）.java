import java.io.*;
import java.util.*;

//start	2023. 12. 15  13 : 10
//end	2023. 12. 15  13 : 22
public class Main {
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] in = new int[n+1]; // 진입차수 배열
        int[] ans = new int[n+1]; // 결과 출력할 배열
        
        List<Integer>[] graph = new ArrayList[n+1]; // 선수과목 관계를 저장할 인접리스트
        for(int i = 1; i < n + 1;i ++) { // 리스트 초기화
        	graph[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	in[to]++; // 진입차수 증가
        	graph[from].add(to); // 연결
        }
        
        Queue<Integer> q = new ArrayDeque<Integer>(); 
        for(int i = 1; i < n + 1; i++) { // 진입 차수가 0인 과목 q에 삽입
        	if(in[i] == 0)
        		q.offer(i);
        }
        
        int semester = 0; // 현재 학기
        while(!q.isEmpty()) {
        	int re = q.size(); // 현재 학기에 들을 수 있는 과목 개수
        	semester++; // 학기 증가
        	
        	for(int i = 0; i < re; i++) { // q 반복
        		int cur = q.poll();
        		ans[cur] = semester;
        		for(int nxt : graph[cur]) {
        			in[nxt]--;
        			if(in[nxt] == 0)
        				q.offer(nxt);
        		}
        	}
        }
        
        for(int i = 1; i < n + 1; i++)
        	sb.append(ans[i]).append(" ");
        System.out.println(sb);
        
        
    }
}