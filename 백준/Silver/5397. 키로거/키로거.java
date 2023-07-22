import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			char ch[] = br.readLine().toCharArray();
			LinkedList<Character> linkedList = new LinkedList<>();
			ListIterator<Character> liter = linkedList.listIterator();
			
			
			for(char c : ch) {
				
				switch(c) {
				case '<' :
					if(liter.hasPrevious())
						liter.previous();
					break;
					
				case '>' :
					if(liter.hasNext())
						liter.next();
					break;
					
				case '-' :
					if(liter.hasPrevious()) {
						liter.previous();
						liter.remove();
					}
					break;
					
					default :
						liter.add(c);
				}
				
				
			}
			
			for(Character c : linkedList)
				sb.append(c);
			sb.append("\n");
			
			
		}
		
		System.out.println(sb);
		
		////////////////////////////////////////////////////
		br.close();
	}

}
