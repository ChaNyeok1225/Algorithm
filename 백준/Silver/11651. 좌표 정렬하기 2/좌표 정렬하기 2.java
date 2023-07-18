import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}


	@Override
	public int compareTo(Point o) {
		if(this.y == o.y) {
			return this.x - o.x;
		} else {
			return this.y - o.y;
		}
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		///////////////구현부/////////////////
		
		int N = Integer.parseInt(br.readLine());
		
		List<Point> lst = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lst.add(new Point(
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())));	
		}
		
		Collections.sort(lst);
		
		for(int i = 0; i < N; i++)
			System.out.println(lst.get(i));
		
		//////////////////////////////////////
	}
	
}
