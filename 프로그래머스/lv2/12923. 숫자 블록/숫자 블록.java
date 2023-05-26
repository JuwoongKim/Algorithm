import java.util.*;

class Solution {
    
    public int[] solution(long begin, long end) {
        
        int N = (int)(end-begin+1);
        
        int[] answer = new int [N];
        
        // answer[1]=0;
        
        int idx =0;
        for(long i = begin; i<=end; i++, idx++){
            if(i!=1)
                answer[idx] = getNumber(i);
            else
                answer[idx]=0;
        }
        
        return answer;
    }
    
    public static int getNumber(long num){
        
        int bd = (int)Math.sqrt(num);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i =2; i<=bd; i++){
            if(num%i==0) {
                list.add(i);
                if(num/i<=10000000)
                list.add( (int)(num/i));
            }
        }
        
        // 소수이면 
        if(list.size()==0) return 1;
        
        
        // 소수가 아니면 가장 큰 값 
        Collections.sort(list,(o1,o2) -> o2-o1);
        
        return list.get(0);
        
    }
    
    
    
}
