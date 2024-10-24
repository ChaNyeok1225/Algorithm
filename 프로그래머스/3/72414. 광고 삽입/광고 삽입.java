import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int answer = 0;
        
        int totalLen = getTime(play_time);
        int advLen = getTime(adv_time) - 1;
        
        int[] arr = new int[totalLen + 2];
        for(String log : logs) {
            String[] se = log.split("-");
            arr[getTime(se[0])]++;
            arr[getTime(se[1])]--;
        }
        
        long viewer = 0, sum = 0, max = 0;
        long[] acc = new long[totalLen + 2];
        for(int i = 0; i <= totalLen; i++) {
            viewer += arr[i];
            acc[i] = viewer;
        }
        
        for(int i = 0; i < advLen; i++) {
            sum += acc[i];
        }
        
        for(int i = advLen; i <= totalLen; i++) {
            sum += acc[i];
            
            if(max < sum) {
                max = sum;
                answer = i - advLen;
            }
            
            sum -= acc[i - advLen];
        }
        
        return getTimeStamp(answer);
    }
    
    int getTime(String timeInfo) {
        String[] hms = timeInfo.split(":");
        return Integer.parseInt(hms[0]) * 3600 + Integer.parseInt(hms[1]) * 60 + Integer.parseInt(hms[2]);
    }
    
    String getTimeStamp(int time) {
        int hour = time / 3600;
        time %= 3600;
        int minute = time / 60;
        time %= 60;
        int sec = time;
        return String.format("%02d:%02d:%02d",hour, minute, sec);
    }
}