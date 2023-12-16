//start	2023. 12. 16  14 : 52
//end	2023. 12. 16  15 : 53
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

		String root = br.readLine();

		// 이름 별 리스트를 담은 해시맵
		HashMap<String, List<String>> listMap = new HashMap<>();
		
		// 입력을 받을 문자열 배열
		String[] name = new String[3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			name[0] = st.nextToken();
			name[1] = st.nextToken();
			name[2] = st.nextToken();
			
			// 이름 별 리스트 초기화
			for (int j = 0; j < 3; j++) {
				if (!listMap.containsKey(name[j]))
					listMap.put(name[j], new ArrayList<String>());
			}
			
			// 자식 정보 담음
			listMap.get(name[1]).add(name[0]);
			listMap.get(name[2]).add(name[0]);
		}

		// 후보자
		String[] cand = new String[m];
		// 피 섞임 정도
		double[] blood = new double[m];
		for (int i = 0; i < m; i++)
			cand[i] = br.readLine();

		// BFS 큐
		Queue<String> q = new ArrayDeque<String>();
		q.offer(root);

		int step = 0;
		double depth = 1; 
		lp : while (!q.isEmpty()) {

			step = q.size();
			depth /= 2;
			
			for(int i = 0; i < step; i++) {
				for(String s : listMap.get(q.poll())) {
					for(int j = 0; j < m; j++) {
						if(s.equals(cand[j])) 
							blood[j] += depth;
					}
					q.offer(s);
				}
			}
		}
		
		double maxb = 0;
		int midx = 0;
		for(int i = 0; i < m; i++) {
			if(maxb < blood[i]) {
				maxb = blood[i];
				midx = i;
			}
		}
		System.out.println(cand[midx]);
	}
}