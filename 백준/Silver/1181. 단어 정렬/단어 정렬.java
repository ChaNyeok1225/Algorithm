import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		///////////////구현부/////////////////
		
		int N = Integer.parseInt(br.readLine());
		
		List<String> lst = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			if(!lst.contains(s))
				lst.add(s);	
		}
		
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				else
					return o1.length() - o2.length();
				
			}
			
		};
		
		Collections.sort(lst, comp);
		
		for(int i = 0; i < lst.size(); i++)
			System.out.println(lst.get(i));
		
		//////////////////////////////////////
	}
	
}
