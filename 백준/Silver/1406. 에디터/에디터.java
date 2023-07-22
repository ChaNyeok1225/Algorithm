import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		char[] ch = br.readLine().toCharArray();
		
		LinkedList<Character> linkedList = new LinkedList<>();
		for(char c : ch) {
			linkedList.add(c);
		}
		
		ListIterator<Character> liter = linkedList.listIterator(); 
		
		while(liter.hasNext())
			liter.next();
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			
			switch(s) {
			case "L" :
				if(liter.hasPrevious())
					liter.previous();
				break;
				
			case "D":
				if(liter.hasNext())
					liter.next();
				break;
				
			case "B" :
				if(liter.hasPrevious()) {
					liter.previous();
					liter.remove();
				}
				break;
				
			case "P" :
				liter.add(st.nextToken().charAt(0));
				break;
			}
			
		}
		
		for(char c : linkedList)
			sb.append(c);
		
		System.out.println(sb);
		
		////////////////////////////////////////////////////
		br.close();
	}

}
