import java.util.*;

class Solution {
    public int[] solution(String s) {
                
        Map<String, Integer> map = new HashMap<>();
        int N = s.length();
        int [] answer = new int [N];
        String [] arr = s.split("");
        
        for(int i =0; i<N; i++){
            
            if(!map.containsKey(arr[i])){
                answer[i] = -1;
            }else{
                answer[i] = i - map.get(arr[i]);
            }
            map.put(arr[i], i);
        }
        
        

        
        
        
        return answer;
    }
}