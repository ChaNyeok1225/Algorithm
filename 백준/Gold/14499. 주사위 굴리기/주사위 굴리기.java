import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());



    int[][] map = new int[n][m];
    for(int i = 0; i < n; i++) {
      st=  new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }



    int[] dx = {0, 0,0,-1,1}, dy = {0, 1,-1,0,0};
    int[] dice = {0,0,0,0,0,0};
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < k; i++) {
      int inst = Integer.parseInt(st.nextToken());

      int nx = x + dx[inst];
      int ny = y + dy[inst];

      if(nx < 0 || nx >= n || ny < 0 || ny >= m)
        continue;

      moveDIce(inst, dice);

      if(map[nx][ny] == 0) {
        map[nx][ny] = dice[3];
      } else {
        dice[3] = map[nx][ny];
        map[nx][ny] = 0;
      }
      sb.append(dice[1]).append("\n");
      x = nx;
      y = ny;
    }
    System.out.print(sb);

  }

  static void moveDIce(int inst, int[] dice) {
    int tmp;
    switch (inst) {
      case 1 :
        tmp = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[3];
        dice[3] = dice[5];
        dice[5] = tmp;
        break;

      case 2 :
        tmp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[3];
        dice[3] = dice[4];
        dice[4] = tmp;
        break;

      case 3 :
        tmp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[3];
        dice[3] = tmp;
        break;

      case 4:
        tmp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[2];
        dice[2] = dice[1];
        dice[1] = tmp;
        break;
    }

  }

}