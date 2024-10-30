import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] diff = new int[n - 1];
        for(int i = 0; i < n - 1; i++)
            diff[i] = arr[i+1] - arr[i];
        Arrays.sort(diff);

        int answer = 0;
        for(int i = 0; i < n - k; i++)
            answer += diff[i];

        System.out.println(answer);
    }
}