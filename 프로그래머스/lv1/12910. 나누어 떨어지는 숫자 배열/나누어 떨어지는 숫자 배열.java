import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            if(arr[i]%divisor==0) list.add(arr[i]);
        }
        
    
        int[] answer ={};
        if(list.size()==0) answer = new int [] {-1};
        else answer = list.stream().sorted().mapToInt(i -> i).toArray();
        
        
        return answer;
    }
}