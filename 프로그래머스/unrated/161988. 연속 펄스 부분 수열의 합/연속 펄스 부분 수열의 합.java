import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int size = sequence.length;
       
        int [] aArr = new int [size];       
        int [] bArr = new int [size];
        
        int a = -1;
        int b = 1;
        
        for(int i =0 ; i<size; i++){            
            aArr[i] = a;
            bArr[i] = b;
            a*=-1; b*= -1;
        }
    
        long answer1 = compute(sequence, aArr);
        long answer2 = compute(sequence, bArr);
        
        answer = Math.max(answer1, answer2);
        System.out.println(answer);
        
        return answer;
    }
    
    
    public static long compute (int[] sequence, int[] parse){
        
        int size = sequence.length;
        long [] prefix = new long[size];
        
        for(int i =0; i<size; i++){
            if(i==0) prefix[i] = sequence[i]*parse[i];  
            else prefix[i] = prefix[i-1] + sequence[i]*parse[i];
        }
        
        long max = Long.MIN_VALUE;
        int maxIdx =0;
        
        long min = 0;
        int minIdx = -1;
        
        for(int i =0; i< size; i++){
            
            if(max<prefix[i]){
                max = prefix[i];
                maxIdx =i;
            }
            
            if(min>prefix[i]){
                min = prefix[i];
                minIdx = i;
            }
        }
        
        if(maxIdx>minIdx){
            return max-min;     
        }else{
            return max;
        }
        
    }
    
    
}