import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static boolean[] sel;
	static int max = Integer.MIN_VALUE, size;

	static LinkedList<Integer> nums = new LinkedList<>();
	static LinkedList<Character> oper = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		size = n / 2;

		int ni = 0, oi = 0;
		char[] c = br.readLine().toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (chk(c[i])) {
				oper.offer(c[i]);
			} else {
				nums.offer(c[i] - '0');
			}
		}
		oper.add('+');
		nums.add(0);

		sel = new boolean[size];

		func(1);

		System.out.println(max);

	}

	public static void func(int idx) {

		LinkedList<Integer> tn = (LinkedList<Integer>) nums.clone();
		LinkedList<Character> to = (LinkedList<Character>) oper.clone();

		for (int i = 0; i < size; i++) {
			if (sel[i]) {
				tn.add(i, calc(tn.remove(i), tn.remove(i), to.remove(i)));
				tn.add(i+1, 0);
				to.add(i, '+');
			}
		}
//		System.out.println(tn);
		while (!to.isEmpty()) {
			tn.offerFirst(calc(tn.pollFirst(), tn.pollFirst(), to.pollFirst()));
		}
		int num = tn.pollFirst();
//		System.out.println(num);
		if (max < num)
			max = num;

		for (int i = idx; i < size; i++) {
			sel[i] = true;
			func(i + 2);
			sel[i] = false;
		}

	}

	public static boolean chk(char c) {
		return c == '*' || c == '-' || c == '+';
	}

	static int calc(int n1, int n2, char op) {
		int n = 0;
		switch (op) {
		case '+':
			n = n1 + n2;
			break;
		case '-':
			n = n1 - n2;
			break;
		case '*':
			n = n1 * n2;
			break;
		}

//		System.out.println(n1 + " " + op + " " + n2 + " = " + n);
		return n;
	}

}
