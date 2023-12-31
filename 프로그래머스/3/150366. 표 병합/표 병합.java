import java.util.*;

class Solution {
    
    static class Data {
        String data;
        Data nxt = null;
        
        Data(String str) {
            data = str;
        }
        
        public String toString() {
            Data d = find(this);
            return d.data;
        }
        
    }
    static public Data find(Data tmp) {
        if(tmp.nxt == null) return tmp;
        return tmp.nxt = find(tmp.nxt);
    }
    
    public String[] solution(String[] commands) {
        StringBuilder sb = new StringBuilder();
        Queue<Data> q= new ArrayDeque<>();
        Data[][] cells = new Data[51][51];
        for(int i = 1; i < 51; i++) {
            for(int j = 1; j < 51; j++)
                cells[i][j] = new Data("");
        }
        
        int n = commands.length;
        for(int s = 0; s < n; s++) {
            String[] inst = commands[s].split(" ");
            
            // System.out.println(commands[s]);
            
            switch(inst[0]) {
                case "UPDATE" :
                    
                    if(inst.length == 4) {
                        Data d = find(cells[Integer.parseInt(inst[1])][Integer.parseInt(inst[2])]);
                        d.data = inst[3];
                    } else {
                        for(int i = 1; i < 51; i++) 
                            for(int j = 1; j < 51; j++) {
                                if(cells[i][j] == null) continue;
                                if(inst[1].equals(cells[i][j].data)) 
                                    cells[i][j].data = inst[2];
                            }
                    }
                    break;
                    
                case "MERGE" :
                    Data a = find(cells[Integer.parseInt(inst[1])][Integer.parseInt(inst[2])]);
                    Data b = find(cells[Integer.parseInt(inst[3])][Integer.parseInt(inst[4])]);
                    if(a == b)
                        continue;
                    
                    if(a.data != "" || b.data == "")
                        b.nxt = a;
                    else 
                        a.nxt = b;
                    
                    break;
                    
                case "UNMERGE" :
                    int r = Integer.parseInt(inst[1]);
                    int c = Integer.parseInt(inst[2]);
                    Data cell = find(cells[r][c]);
                    String val = cell.data;
                    
                     for(int i = 1; i < 51; i++) 
                            for(int j = 1; j < 51; j++) {
                                if(i == r && j == c) continue;
                                if(cell == find(cells[i][j]))  {
                                    q.offer(cells[i][j]);
                                    System.out.println(cells[i][j].data);
                                    System.out.println(i + ", " + j);
                                }
                            }
                    
                    while(!q.isEmpty()) {
                        Data tmp = q.poll();
                        System.out.println(tmp);
                        tmp.data = "";
                        tmp.nxt = null;
                    }
                    cells[r][c].data = val;
                    cells[r][c].nxt =null;
                    
                    break;
                    
                case "PRINT" :
                    String tmp = cells[Integer.parseInt(inst[1])][Integer.parseInt(inst[2])].toString();
                    if("".equals(tmp))
                        tmp = "EMPTY";
                    sb.append(tmp).append(" ");
                    break;
            }
        
        // for(int i = 1; i < 5; i++) {
        //     for(int j = 1; j < 5; j++)
        //         System.out.print(cells[i][j] + ", ");
        //     System.out.println();
        // }
        
        }
        
        return sb.toString().split(" ");
    }
}