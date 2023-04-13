import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};

        int N = targets.length;
        answer = new int [N]; 
        
        for(int i =0; i<N; i++)
            answer [i] = getCnt(targets[i], keymap);
        
        return answer;
    }
    
    public static int getCnt(String target, String[] keymap){
        
        int tempSum =0;
        boolean noElement = false;
        
        for(String str : target.split("")){
            int temp=Integer.MAX_VALUE;
            
            for(String key : keymap)
                if(key.contains(str))
                    temp = Math.min(temp,key.indexOf(str)+1);

            if(temp==Integer.MAX_VALUE){
                tempSum = -1;
                break;
            }
            tempSum +=temp;
        }
        
        return tempSum;
    }
    
    
}

