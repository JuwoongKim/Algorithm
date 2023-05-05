import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();
        
        int i =1;
        
        for(int ele : order){
            
            while(i<ele){
                st.push(i);
                i++;
            }
            
            if(i==ele){
                i++;
                answer ++;
                continue;
            }
            
            if(i>ele){
                if(st.peek()==ele){
                    st.pop();
                    answer ++;
                    continue;
                }
            }
            
            break;
        }
        
        
        
        return answer;
    }
}