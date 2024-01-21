import java.util.*;

class Solution {
    
    class Data {
        String name;
        int idx;
        
        Data(String a, int b) {
            name = a;
            idx = b;
        }
    }
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
            return 5 * cities.length;
        }
        
        List<Data> list = new ArrayList<>();
        
        loop : for(int i = 0; i < cities.length; i++) {
            String str = cities[i].toLowerCase();
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            for(int j = 0; j < list.size(); j++) {
                Data cur = list.get(j);
                if(cur.name.equals(str)) {
                    cur.idx = i;
                    answer++;
                    continue loop; 
                }
                if(min > cur.idx) {
                    min = cur.idx;
                    minIdx = j;
                }
            }
            
            if(list.size() < cacheSize)
                list.add(new Data(str, i));
            else {
                Data d = list.get(minIdx);
                d.name = str;
                d.idx = i;
            }
            answer += 5;
            
        }
        
        
        return answer;
    }
}