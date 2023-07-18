import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int N = Integer.parseInt(br.readLine());
		
		int[] numsCnt = new int[8001];
		int[] nums = new int[N];
		double sum = 0;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			sum += num;
			nums[i] = num; 
			numsCnt[num+4000]++;
		}
		Arrays.sort(nums);
		
		
		int mode = 0;
		int maxCnt = Arrays.stream(numsCnt).max().getAsInt();
		int flag = 0;
		for(int i = 0; i < 8001; i++) {
			if(numsCnt[i] == maxCnt) {
				mode = i - 4000;
				flag++;
				if(flag == 2)
					break;
			}
		}
		
		
		int aver = (int)Math.round(sum / N);
		int median = nums[N/2];
		int range = nums[N-1] - nums[0];
		

		bw.write(aver + "\n" + median + "\n" + mode + "\n" + range);
		
		
		bw.flush();

		////////////////////////////////////////////////////
		br.close();
		bw.close();

	}

}
