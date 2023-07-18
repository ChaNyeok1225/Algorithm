import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		//////////////////////구현부/////////////////////////
		
		int N = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			
			if(st.nextToken().equals("enter"))
				set.add(name);
			else
				set.remove(name);
		}
		
		List<String> lst = new ArrayList<>(set);
		
		Collections.sort(lst, Collections.reverseOrder());
		
		for(int i = 0; i < lst.size(); i++)
			bw.write(lst.get(i) + "\n");
		bw.flush();
		
		////////////////////////////////////////////////////
		br.close();
		bw.close();
		
	}

}
