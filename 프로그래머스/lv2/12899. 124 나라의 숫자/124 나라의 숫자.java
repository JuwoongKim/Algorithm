import java.util.*;

class Solution {

    public String solution(int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder("");
        
        int temp;
        while(n!=0){      
            temp = n%3;
            sb.append(String.valueOf(temp));
            
            if(temp==0) n = n/3 -1;
            else n = n/3;
        }
        
        sb.reverse();
        
        for(int i =0; i<sb.length(); i ++){
            
            char ch = sb.charAt(i);
            if(ch == '0'){
                sb.setCharAt(i, '4');
            }else if (ch == '1'){
                sb.setCharAt(i, '1');
            }else{
                sb.setCharAt(i, '2');
            }
            
        }
        
        answer = sb.toString();
        
        return answer;
    }
    

    
    
}