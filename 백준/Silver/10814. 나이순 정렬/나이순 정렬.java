import java.io.*;
import java.util.*;


class Person implements Comparable<Person>{
	int age;
	int idx;
	String name;

	
	public Person(int age, int idx, String name) {
		super();
		this.age = age;
		this.idx = idx;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return age + " " + name;
	}
	@Override
	public int compareTo(Person o) {
		
		if(this.age == o.age)
			return this.idx - o.idx;
		else
			return this.age - o.age;
		
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		///////////////구현부/////////////////
		
		int N = Integer.parseInt(br.readLine());
		
		List<Person> lst = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			lst.add(new Person(age, i, name));
		}
		
		Collections.sort(lst);
		
		for(int i = 0; i < lst.size(); i++)
			System.out.println(lst.get(i));
		
		//////////////////////////////////////
	}
	
}
