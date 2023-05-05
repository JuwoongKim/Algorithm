import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> second = new HashMap<>();
        
        for(int ele : topping)
            second.put(ele, second.getOrDefault(ele,0)+1);
        
        for(int ele : topping){
            first.put(ele, second.getOrDefault(ele,0)+1);
            
            if(second.containsKey(ele)){
                int temp = second.get(ele)-1;
                if(temp==0) second.remove(ele);
                else second.put(ele, temp);
            }        
            if(first.size() == second.size()) {
                // System.out.println(first);
                // System.out.println(second);
                answer ++;
            }
        }
        
        return answer;
    }
}