import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        //짝수라면 
        if(s.length()%2==0){
            answer= s.substring(s.length()/2-1,s.length()/2+1);
        }else{
            answer = String.valueOf(s.charAt((s.length()/2)));
         }
        
        
        return answer;
    }
}