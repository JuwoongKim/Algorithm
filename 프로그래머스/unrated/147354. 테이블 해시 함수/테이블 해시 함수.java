import java.util.*;
import java.util.stream.*;


class Solution {
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data , (r1, r2) ->
                    {
                        int bit =r1[col-1]-r2[col-1]; 
                        if(bit==0){
                            return r2[0]-r1[0];
                        }else{
                            return bit;
                        }   
                    });
        
        
    
        
        for(int j=row_begin; j <=row_end; j++ ){
            final int k = j;
            if(k==row_begin) answer = Arrays.stream(data[k-1]).map(i -> (int)i%k).sum();
            else{
                int temp =  Arrays.stream(data[k-1]).map(i -> (int)i%k).sum(); 
                 answer = answer ^ temp;
            }
            
        }
        
        return answer;
    }
    

    
    
    
    
}