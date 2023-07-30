import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int cntZero;
	static int cntMinus;
	static int cntOne;
	
	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		int[][] paper = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) 
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		
//		for(int i = 0; i < n; i++)
//			System.out.println(Arrays.toString(paper[i]));
		
		func(paper, n, 0, 0);
		
		System.out.println(cntMinus);
		System.out.println(cntZero);
		System.out.println(cntOne);
		////////////////////////////////////////////////////
		br.close();
	}

	static void func(int[][] paper, int n, int x, int y) {
		boolean flag = false;
		
		int num = paper[x][y];
		L : for(int i = x; i < x + n; i++) {
			for(int j = y; j < y + n; j++) {
				if(paper[i][j] != num) {
					flag = true;
					break L ;
				}
			}
		}
		
		if(flag) {
//			System.out.println("true");
			func(paper,n/3, x + 0, y + 0);
			func(paper,n/3, x + n/3, y + 0);
			func(paper,n/3, x + n/3*2, y + 0);
			func(paper,n/3, x + 0, y + n/3);
			func(paper,n/3, x + n/3, y + n/3);
			func(paper,n/3, x + n/3*2, y + n/3);
			func(paper,n/3, x + 0, y + n/3*2);
			func(paper,n/3, x + n/3, y + n/3*2);
			func(paper,n/3, x + n/3*2, y + n/3*2);
		} else {
			if(num == 0)
				cntZero++;
			else if(num == -1)
				cntMinus++;
			else if (num == 1) 
				cntOne++;
		}
	}

}
