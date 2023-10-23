import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		Student[] ss = new Student[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			ss[i] = new Student(name, a, b, c);
		}
		Arrays.sort(ss);
		
		for(int i = 0; i < n; i++)
			sb.append(ss[i].name).append("\n");
		
		System.out.print(sb);
		
	}
	
	static class Student implements Comparable<Student>{
		
		String name;
		int a;
		int b;
		int c;
		
		public Student(String name, int a, int b, int c) {
			super();
			this.name = name;
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public int compareTo(Student s) {
			if(this.a == s.a) {
				if(this.b == s.b) {
					if(this.c == s.c)
						return this.name.compareTo(s.name);
					return s.c - this.c;
				}
				return this.b - s.b;
			}
			return s.a - this.a;
		}
	}
	
}