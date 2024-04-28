import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    int[] p = new int[N*N]; // 서로소집합
    int[][] map = new int[N][N]; // 인구 맵

    int idx = 0;
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        p[idx] = idx++;
      }
    }

    int[] mP = new int[N*N];
    boolean isContinue = true;
    int[] dx = {1,0}, dy = {0,1};
    int[][] sumMap = new int[N][N];
    int[][] cnt = new int[N][N];
    int ans = 0;
    int pIdx;
    while(isContinue) {
      isContinue = false;
      for(int i = 0; i < N; i++) {
        Arrays.fill(sumMap[i], 0);
        Arrays.fill(cnt[i], 0);
      }
      mP = p.clone();

      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          int tx = i + 1;
          int ty = j + 1;

          if(tx < N) {
            int diff = Math.abs(map[i][j] - map[tx][j]);
            if (L <= diff && diff <= R && union(i * N + j, tx * N + j, mP)) {
              if(!isContinue) {
                ans++;
                isContinue = true;
              }
            }
          }

          if(ty < N) {
            int diff = Math.abs(map[i][j] - map[i][ty]);
            if (L <= diff && diff <= R && union(i * N + j, i * N + ty, mP)) {
              if(!isContinue) {
                ans++;
                isContinue = true;
              }
            }
          }
        }
      }

      pIdx = 0;
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          int pnum = find(pIdx, mP);
          sumMap[pnum / N][pnum % N] += map[i][j];
          cnt[pnum / N][pnum % N]++;
          pIdx++;
        }
      }

      pIdx = 0;
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          int pnum = find(pIdx, mP);
          int c = cnt[pnum / N][pnum % N];
          if(c > 1) {
            map[i][j] = sumMap[pnum / N][pnum % N] / c;
          }
          pIdx++;
        }
      }

    }

    System.out.println(ans);

  }

  static int find(int a, int[] p) {
    if(a == p[a]) return a;
    return p[a] = find(p[a], p);
  }

  static boolean union(int a, int b, int[] p) {
    a = find(a, p);
    b = find(b, p);

    if(a == b) return false;

    p[b] = a;
    return true;
  }

}