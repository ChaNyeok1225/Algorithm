import java.util.*;

class Solution {
    
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoTime, posTime, opStart, opEnd;
        videoTime = convertToTime(video_len);
        posTime = convertToTime(pos);
        opStart = convertToTime(op_start);
        opEnd = convertToTime(op_end);
        
        for(String command : commands) {
            if(opStart <= posTime && posTime < opEnd) 
                posTime = opEnd;
            
            switch(command) {
                    case "next" :
                        posTime += 10;
                        posTime = posTime < videoTime ? posTime : videoTime; 
                        break;
                    
                    case "prev" :
                        posTime -= 10;
                        posTime = posTime > 0 ? posTime : 0;
                        break;
            }
        }
        if(opStart <= posTime && posTime < opEnd) 
                posTime = opEnd;
        
        String answer = String.format("%02d:%02d",posTime/60, posTime%60);
        
        return answer;
    }
    
    int convertToTime(String str) {
        String[] time = str.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
}