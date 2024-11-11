import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Node {
        Node[] next;

        Node() {
            next = new Node[26];
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] words = new char[c][r];
        char[] word;
        for(int i = r - 1; i >= 0; i--) {
            word = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                words[j][i] = word[j];
            }
        }

        Node root = new Node(), tmp;
        int cnt, max = 0;
        for(int i = 0; i < c; i++) {
            tmp = root;
            cnt = 0;
            for(int j = 0; j < r; j++) {
                if(tmp.next[words[i][j] - 'a'] == null) {
                    tmp.next[words[i][j] - 'a'] = new Node();
                    cnt = -1000;
                } else {
                    cnt++;
                    max = max > cnt ? max : cnt;
                }
                tmp = tmp.next[words[i][j] - 'a'];
            }
        }
        System.out.println(r - 1 - max);
    }
}