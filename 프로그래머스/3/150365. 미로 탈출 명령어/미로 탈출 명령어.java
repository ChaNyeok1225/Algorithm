import java.util.*;

// d > l > r > u
class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int rd = Math.abs(x - r);
        int cd = Math.abs(y - c);
        
        int distance = rd + cd;
        int restDistance = k - distance;
        
        if(restDistance < 0 || (restDistance & 1) == 1)
            return "impossible";
        
        StringBuilder answer = new StringBuilder();
        char[] ch = {'d', 'l', 'r','u'};
        int[] dr = {1, 0, 0, -1}, dc = {0, -1, 1, 0};
        int flag;
        while(true) {
            flag = distanceCheck(x, y, r, c, k);
            
            if(flag == 0) {
                answer.append(getShortPath(x, y, r, c));
                break;
            } else if(flag == 1) {
                for(int dir = 0; dir < 4; dir++) {
                    if(OOB(x + dr[dir], y + dc[dir], n, m) || distanceCheck(x + dr[dir], y + dc[dir], r, c, k - 1) == -1)
                        continue;
                    x += dr[dir];
                    y += dc[dir];
                    answer.append(ch[dir]);
                    break;
                }
            }
            k--;
        }
        
        return answer.toString();
    }
    
    boolean OOB(int x, int y, int n, int m) {
        return x < 1 || x > n || y < 1 || y > m;
    }
    
    int distanceCheck(int x, int y, int r, int c, int k) {
        int flag = k - (Math.abs(x - r) + Math.abs(y - c));
        if(flag > 0)
            return 1;
        else if(flag == 0)
            return 0;
        else 
            return -1;
    } 
    
    String getShortPath(int x, int y, int r, int c) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        int rd = Math.abs(x - r);
        int cd = Math.abs(y - c);
        
        char ch = 'u';
        if(x < r)
            ch = 'd';
        for(int i = 0; i < rd; i++)
            sb.append(ch);
        list.add(sb.toString());
        sb.setLength(0);
        
        ch = 'l';
        if(y < c)
            ch = 'r';
        for(int i = 0; i < cd; i++)
            sb.append(ch);
        list.add(sb.toString());
        sb.setLength(0);
        
        Collections.sort(list);
        for(String str : list)
            sb.append(str);
        return sb.toString();
    }
    
}