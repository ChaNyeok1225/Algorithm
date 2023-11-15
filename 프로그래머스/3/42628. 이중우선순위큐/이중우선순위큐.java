import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int len = operations.length;
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int i = 0; i < len; i++) {
            switch(operations[i]) {
                case "D 1" :
                    if(!ts.isEmpty())
                        ts.pollLast();
                    break;
                    
                case "D -1" :
                    if(!ts.isEmpty())
                        ts.pollFirst();
                    break;
                    
                default :
                    ts.add(Integer.parseInt(operations[i].substring(2)));
                    break;
            }
        }
        int[] answer = new int[2];
        
        if(!ts.isEmpty()) {
            answer[0] = ts.last();
            answer[1] = ts.first();
        }
        
        return answer;
    }
}