import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int len = timetable.length;
        int time = 540;
        int[] convertTimetable = new int[len]; 
        for(int i = 0; i < len; i++)
            convertTimetable[i] = getTime(timetable[i]);
        Arrays.sort(convertTimetable);
        
        
        int idx = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int curTime = time + i * t;
            cnt = 0;
            
            while(idx < len && convertTimetable[idx] <= curTime && cnt < m) {
                idx++;
                cnt++;
            }
            
        }
        
        if(cnt < m) {
            return getTimetable(time + (n-1) * t);
        }
        
        return getTimetable(convertTimetable[idx-1]-1);
    }
    
    
    int getTime(String str) {
        String[] s = str.split(":");
        
        int ans = Integer.parseInt(s[0]) * 60;
        ans  += Integer.parseInt(s[1]);
        
        return ans;
    }
    
    String getTimetable(int time) {
        return String.format("%02d:%02d", time/60, time % 60);    
    
    }
    
}