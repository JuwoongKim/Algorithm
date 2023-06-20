import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> st = new Stack<>();
        
        for(Character c : s.toCharArray()){
            if(st.isEmpty()){
                st.add(c);
                continue;
            }
            if(st.peek() == c)
                st.pop();
            else 
                st.push(c);
        }
        
        if(st.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }
            
        return answer;
    }
}