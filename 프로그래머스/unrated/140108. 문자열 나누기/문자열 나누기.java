import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        while(s.length()!=0){
            answer ++;       
            s = func(s);
        }
                
        return answer;
    }
    
    
    public static String func(String s ){
        
        int match =0;
        int unMatch =0; 
        char first = s.charAt(0);
        
        int i=0;
        for(i =0; i<s.length(); i++){
            if(first == s.charAt(i)) match ++;
            else unMatch ++;          
            if(match ==unMatch) break;
        }
        
        if(i==s.length()) return "";
        else return s.substring(i+1);
        
    }
    
    
    
}