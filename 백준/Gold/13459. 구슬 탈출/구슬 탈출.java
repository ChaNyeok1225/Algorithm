import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {

  static int answer, n, m;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    char[][] map = new char[n][];

    for(int i = 0; i < n; i++)
      map[i] = br.readLine().toCharArray();

    execute(map, 0);

    System.out.println(answer);
  }

  static void execute(char[][] map, int cnt) {
    if(cnt == 10 || answer == 1)
      return;

    for(int dir = 0; dir < 4 && answer == 0; dir++) {
      char[][] nxtMap = new char[n][];
      for(int i = 0; i < n; i++)
        nxtMap[i] = map[i].clone();

      if(move(nxtMap, dir))
        execute(nxtMap, cnt+1);
    }
  }

  static boolean move(char[][] map, int dir) {
    int place, start, end, step;
    boolean holeFlag, redFlag = false;

    switch (dir) {
      case 0 : case 1 :
        if(dir == 0) {
          start = 0;
          end = m;
          step = 1;
        } else {
          start = m - 1;
          end = -1;
          step = -1;
      }

        for(int i = 0; i < n; i++) {
          place = 0;
          holeFlag = false;
          for(int j = start; j != end; j += step) {

            char c = map[i][j];
            if(c == '#') {
              place = j + step;
              holeFlag = false;
            }
            else if(c == 'O')
              holeFlag = true;
            else if(c == 'R' || c == 'B') {
              if(holeFlag) {
                if(c == 'R')
                  redFlag = true;
                else
                  return false;
              } else {
                if(place != j){
                  map[i][place] = map[i][j];
                  map[i][j] = '.';
                }
                place += step;
              }
            }
          }
        }
        break;

      case 2: case 3:
        if(dir == 2) {
          start = 0;
          end = n;
          step = 1;
        } else {
          start = n - 1;
          end = -1;
          step = -1;
        }

        for(int i = 0; i < m; i++) {
          place = 0;
          holeFlag = false;
          for(int j = start; j != end; j += step) {
            char c = map[j][i];
            if(c == '#') {
              place = j + step;
              holeFlag = false;
            }
            else if(c == 'O')
              holeFlag = true;
            else if(c == 'R' || c == 'B') {
              if(holeFlag) {
                if(c == 'R')
                  redFlag = true;
                else
                  return false;
              } else {
                if(place != j) {
                  map[place][i] = map[j][i];
                  map[j][i] = '.';
                }
                place += step;
              }
            }
          }
        }
        break;
    }

    if(redFlag)
      answer = 1;

    return true;

  }
}