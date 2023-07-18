import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class student implements Comparable<student> {
	String sid;
	int idx;
	
	public student(String sid, int idx) {
		super();
		this.sid = sid;
		this.idx = idx;
	}

	@Override
	public int compareTo(student o) {
		return this.idx - o.idx;
	}
	
	
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		///////////////////////// 구현부
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		
		Map<String, Integer> student = new HashMap<>();
		
		for(int i = 0; i < l; i++) {
			student.put(br.readLine(), i);
		}
		
		//System.out.println(student);
		
		ArrayList<student> lst = new ArrayList<>();
		
		for (Entry<String, Integer> entry : student.entrySet()) {
			lst.add(new student(entry.getKey(), entry.getValue()));
		}
		
		Collections.sort(lst);
		
		for(int i = 0; i < k && i < lst.size(); i++)
			sb.append(lst.get(i).sid + "\n");
		
		System.out.println(sb);
		
		
		////////////////////////////
		br.close();
	}
}
