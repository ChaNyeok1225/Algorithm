import java.util.*;
import java.util.Map.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int len = records.length;
        
        TreeMap<String, Integer> accMap = new TreeMap<>();
        HashMap<String, Integer> historyMap = new HashMap<>();
        
        String[] record;
        int time, inTime;
        for(int i = 0; i < len; i++) {
            
            record = records[i].split(" ");
            time = convertTime(record[0]);
            
            if(record[2].equals("IN")) {
                historyMap.put(record[1], time);
            } else {
                inTime = historyMap.remove(record[1]);
                accMap.put(record[1], accMap.getOrDefault(record[1], 0) + time - inTime);
            }
        }
        
        int maxTime = 23 * 60 + 59;
        
        for(Entry<String, Integer> entry : historyMap.entrySet()) {
            accMap.put(entry.getKey(), accMap.getOrDefault(entry.getKey(), 0) + maxTime - entry.getValue());
        }
        
        int[] answer = new int[accMap.size()];
        int idx = 0, price = 0;
        for(int value : accMap.values()) {
            price = fees[1] + (int)Math.ceil((value - fees[0] > 0 ? value - fees[0] : 0) / (double)fees[2]) * fees[3];
            
            answer[idx++] = price;
        }
        
        
        return answer;
    }
    
    int convertTime(String Time) {
        String[] hm = Time.split(":");
        
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}