import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> list= new ArrayList<>();
        
        Stack<Integer> st = new Stack<>();
        
        for(int i =0; i< arr.length; i++){
            if(st.isEmpty() || st.peek()==arr[i]){
                st.push(arr[i]);
            }else{           
                list.add(st.pop());
                st.clear();
                st.push(arr[i]);
            }     
        }
        if(!st.isEmpty())
            list.add(st.pop());
        
        int [] answer = list.stream().mapToInt(i->i).toArray(); 
        
        return answer;
    }
}