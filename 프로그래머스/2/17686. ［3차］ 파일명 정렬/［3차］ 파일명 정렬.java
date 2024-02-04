import java.util.*;

class Solution {
    
    static class File implements Comparable<File> {
        String Origin;
        String HEAD;
        int NUMBER;
        
        File(String a, String h, int n) {
            Origin = a;
            HEAD = h;
            NUMBER = n;
            
        }
        
        public int compareTo(File o) {
            int val = this.HEAD.compareTo(o.HEAD);
            
            if(val == 0)
                return this.NUMBER - o.NUMBER;
            return val;
            
        }
         public String toString() {
                return this.Origin;
            }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        List<File> list = new ArrayList<>();
        
        for(int i = 0; i < files.length; i++) {
            String file = files[i];
            
            String[] set = new String[3];
            int st = 0, en = file.length();
            
            l : for(int j = 0; j < file.length(); j++) {
                if(Character.isDigit(file.charAt(j)) && st == 0) {
                    st = j;
                    for(int k = j+1; k < file.length(); k++) {
                        if(!Character.isDigit(file.charAt(k))) {
                            en = k;
                            break l;
                        }
                    }
                }
            }
            if(en > st + 5)
                en = st + 5;
            set[0] = file.substring(0, st);
            set[0] = set[0].toLowerCase();
            set[1] = file.substring(st,en);
            
            list.add(new File(file, set[0], Integer.parseInt(set[1])));
        }
        Collections.sort(list);
        for(int i = 0; i < files.length; i++)
            answer[i] = list.get(i).Origin;
        
        return answer;
    }
}