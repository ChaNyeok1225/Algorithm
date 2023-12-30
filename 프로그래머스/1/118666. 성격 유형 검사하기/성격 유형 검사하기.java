import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int size = survey.length;
        int[] res = new int[4];
        for(int i = 0; i < size; i++) {
            
            int idx = ques(survey[i]);
            int base = 0;
            switch(survey[i].charAt(0)) {
                case 'R' : case 'C' : case 'J' : case 'A' :
                    base = -4 + choices[i];
                    break;
                default : 
                    base = 4 - choices[i];    
            }
            
            res[idx] += base;
        }
        
        if(res[0] <= 0)
            answer += "R";
        else
            answer += "T";

        if(res[1] <= 0)
            answer += "C";
        else
            answer += "F";

        if(res[2] <= 0)
            answer += "J";
        else
            answer += "M";
        
        if(res[3] <= 0)
            answer += "A";
        else
            answer += "N";
        
        
        
        return answer;
    }
    
    static int ques(String str) {
        switch(str) {
            case "RT": case "TR":
                return 0;
            case "FC" : case "CF":
                return 1;
            case "MJ" : case "JM" :
                return 2;
            case "AN" : case "NA" :
                return 3;
            default :
                return -1;
        }
        
        
    }
    
}