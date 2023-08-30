import java.io.*;
import java.util.*;

class Solution {
    
    static int[][] cell;
    public String[] solution(String[] commands) {
        cell = new int[51][51];
        
        int idx = 1, r = 0, c = 0, tr,tc, tidx;
        String v1, v2;
        for(int i = 1; i < 51; i++)
            for(int j = 1; j < 51; j++)
                cell[i][j] = idx++;
        
        HashMap<Integer,String> hm = new HashMap<>();
        ArrayList<String> print = new ArrayList<>();
        
        for(int i = 0; i < commands.length; i++ ) {
            String[] str = commands[i].split(" ");
            // for(int x = 1; x < 5; x++) {
            //     for (int y = 1; y < 5; y++)
            //         System.out.print(cell[x][y] + " ");
            //     System.out.println(); 
            // }System.out.println(hm); 
            switch(str[0]) {
                    
                case "UPDATE" :
                    if(str.length == 4) {
                        r = Integer.parseInt(str[1]);
                        c = Integer.parseInt(str[2]);
                        idx = getIdx(r, c);
                        hm.put(idx, str[3]);
                    } else if (str.length == 3) {
                        v1 = str[1];
                        v2 = str[2];
                        for(int key : hm.keySet()) {
                            if(hm.get(key).equals(v1)) {
                                hm.put(key, v2);
                            }
                        }
                    }
                    break;
                    
                case "MERGE" :
                    r = Integer.parseInt(str[1]);
                    c = Integer.parseInt(str[2]);
                    tr = Integer.parseInt(str[3]);
                    tc = Integer.parseInt(str[4]);
     
                    idx = getIdx(r,c);
                    tidx =getIdx(tr,tc);
                    
                    if(idx == tidx)
                        break;
                    
                    for(int x = 1; x < 51; x++) {
                        for(int y = 1; y < 51; y++) {
                            if(cell[x][y] == tidx)
                                cell[x][y] = idx;
                        }     
                    }
                    
                    if(!hm.containsKey(idx) && hm.containsKey(tidx)) 
                        hm.put(idx, hm.get(tidx));
                    hm.remove(tidx);
                    
                    cell[tr][tc] = cell[r][c];
                    break;
                    
                    
                case "UNMERGE" :
                    r = Integer.parseInt(str[1]);
                    c = Integer.parseInt(str[2]);
                    
                    idx = getIdx(r,c);
                    
                    int cnt = 1;
                    for(int x = 1; x < 51; x++) {
                        for(int y = 1; y < 51; y++) {
                            if(cell[x][y] == idx)
                                cell[x][y] = cnt;
                            cnt++;
                        }     
                    }

                    if(hm.containsKey(idx)) 
                        hm.put(cell[r][c], hm.get(idx));
                    if(cell[r][c] != idx)
                        hm.remove(idx);
                    
                    break;
                    
                case "PRINT" :
                    r = Integer.parseInt(str[1]);
                    c = Integer.parseInt(str[2]);
                    idx = getIdx(r, c);
                    if(hm.containsKey(idx)) 
                        print.add(hm.get(idx));
                    else
                        print.add("EMPTY");
                    break;
            }      
        }
        
        String[] answer = new String[print.size()];
        
        for(int i = 0; i < print.size(); i++)
            answer[i] = print.get(i);
        
        return answer;
    }
    
    static int getIdx(int x, int y) {
        return cell[x][y];
    }
    
}