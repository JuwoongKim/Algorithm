import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        
        for(String ele :  babbling){
            
            StringBuilder sb = new StringBuilder("");
            int [] memo = new int [4];
            for(int i =0; i<ele.length(); i++){
                
                sb.append(ele.charAt(i));
                if(sb.toString().equals("aya")){
                    sb = new StringBuilder("");
                    memo[0] = memo[0]+1;
                    clear(memo,0);
                    continue;
                }
                if(sb.toString().equals("ye")){
                    sb = new StringBuilder("");
                    memo[1] = memo[1]+1;
                    clear(memo,1);
                    continue;
                }
                if(sb.toString().equals("woo")){
                    sb = new StringBuilder("");
                    memo[2] = memo[2]+1;
                    clear(memo,2);
                    continue;
                }
                if(sb.toString().equals("ma")){
                    sb = new StringBuilder("");
                    memo[3] = memo[3]+1;
                    clear(memo,3);
                    continue;
                }
            }
            
            boolean check = false;
            if(sb.toString().equals("")){
               
                //System.out.println(Arrays.toString(memo));
                int cnt =0;
                for(int e : memo)
                    if(e>=2) cnt++;
                if(cnt==0) check =true;
            }
            if(check) answer ++;
            
        }
        
        
        return answer;
    }
    
    public static void clear(int [] memo, int n){
     
        for(int i =0; i<memo.length; i++){
            if(i==n)continue;
            if(memo[i]<=1) memo[i]=0;
        }
        
    }
    
    
}