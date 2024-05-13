import java.util.*;
import java.util.Map.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int i = 0; i < people.length; i++) {
            map.put(people[i], map.getOrDefault(people[i], 0) + 1);
        }
        
        int sum, ex;
        Entry<Integer, Integer> entry;
        while(!map.isEmpty()) {
            entry = map.pollFirstEntry();
            if(entry.getValue() != 1) {
                map.put(entry.getKey(), entry.getValue()-1);
            }
            
            sum = entry.getKey();
            
            while(true) {
                ex = limit - sum;
                entry = map.floorEntry(ex);
                
                if(entry == null) {
                    break;
                } else {
                    sum += ex;
                    if(entry.getValue() != 1) {
                         map.put(entry.getKey(), entry.getValue()-1);
                    } else {
                        map.remove(entry.getKey());
                    }
                }
                
            }
            
            
            answer++;            
        }
        
        return answer;
    }
}