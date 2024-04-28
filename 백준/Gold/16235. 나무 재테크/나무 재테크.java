import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] addE = new int[n+2][n+2];
    int[][] energy = new int[n+2][n+2];
    int[][] ex = new int[n+2][n+2];
    int[][] spread = new int[n+2][n+2];
    PriorityQueue<Integer>[][] trees = new PriorityQueue[n+2][n+2];

    for(int i = 0; i < n + 2; i++) {
      for(int j = 0; j < n + 2; j ++)
        trees[i][j] = new PriorityQueue<>();
    }

    for(int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 1; j < n + 1; j++) {
        addE[i][j] = Integer.parseInt(st.nextToken());
      }
      Arrays.fill(energy[i], 5);
    }



    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      trees[x][y].offer(Integer.parseInt(st.nextToken()));
    }

    int[] dx = {1,0,-1,0,1,1,-1,-1}, dy = {0,1,0,-1,1,-1,1,-1};

    ArrayDeque<Integer> q = new ArrayDeque<>();
    for(int t= 0; t < k; t++) {
      // 봄
      for(int i = 1; i < n + 1; i++) {
        for(int j = 1; j < n + 1; j++) {

          while(!trees[i][j].isEmpty()) {
            int tree = trees[i][j].poll();

            if(energy[i][j] >= tree) {
              q.offer(tree+1);
              energy[i][j] -= tree;
              if((tree+1) % 5 == 0) {
                spread[i][j]++;
              }
            } else {
              ex[i][j] += tree / 2;
            }
          }
          while(!q.isEmpty()) {
            trees[i][j].offer(q.poll());
          }
        }
      }

      // 여름
      for(int i = 1; i < n + 1; i++) {
        for(int j = 1; j < n + 1; j++) {
          energy[i][j] += ex[i][j];
          ex[i][j] = 0;
        }
      }

      // 가을
      for(int i = 1; i < n + 1; i++) {
        for(int j = 1; j < n + 1; j++) {
          if(spread[i][j] > 0) {
            for(int dir = 0; dir < 8; dir++) {
              int nx = i + dx[dir];
              int ny = j + dy[dir];

              for(int l = 0; l < spread[i][j]; l++) {
                trees[nx][ny].offer(1);
              }
            }
            spread[i][j] = 0;
          }
        }
      }

      // 겨울
      for(int i = 1; i < n + 1; i++) {
        for(int j = 1; j < n + 1; j++) {
          energy[i][j] += addE[i][j];
        }
      }
    }

    int answer = 0;
    for(int i = 1; i < n + 1; i++) {
      for(int j = 1; j < n + 1; j++) {
        answer += trees[i][j].size();
      }
    }
    System.out.println(answer);

  }

}