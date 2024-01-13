import java.util.*;

class Solution {
    
    static class Data {
        String uid;
        int type;
        
        Data(String a, int t) {
            uid = a;
            type = t;
        }
    }
    
    public String[] solution(String[] record) {
        int n = record.length;
        
        HashMap<String,String> map = new HashMap<>();
        List<Data> lst = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] str = record[i].split(" ");
            
            if("Enter".equals(str[0])) {
                lst.add(new Data(str[1], 0));
                map.put(str[1], str[2]);
            } else if("Leave".equals(str[0])) {
                lst.add(new Data(str[1], 1));
            } else if("Change".equals(str[0])) {
                map.put(str[1], str[2]);
                
            }
        }
        
        String[] answer = new String[lst.size()];
        
        for(int i = 0; i < lst.size(); i++) {
            Data cur = lst.get(i);
            
            answer[i] = map.get(cur.uid);
            if(cur.type == 0) 
                answer[i] += "님이 들어왔습니다.";
            else
                answer[i] += "님이 나갔습니다.";
        }        
        return answer;
    }
}