class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0);
        
        if(!Character.isDigit(first)){            
            answer = Integer.valueOf(s.substring(1));
            if(first == '-') answer *= -1;  
                
        }else{
            answer = Integer.valueOf(s);
        }
        
        return answer;
    }
}