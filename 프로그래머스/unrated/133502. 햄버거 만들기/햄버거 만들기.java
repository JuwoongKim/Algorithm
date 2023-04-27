import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        
        int N = ingredient.length; 
        for(int i =0; i<N; i++){
          
            if(list.size()>=3 && ingredient[i]==1){
                int top = list.get(list.size()-1);
                int mid = list.get(list.size()-2);
                int bot = list.get(list.size()-3);
                if(top==3 && mid ==2 && bot==1){
                    answer ++;
                    for(int j=0; j<3; j++)
                        list.remove(list.size()-1);
                    continue;
                }
            }  
            list.add(ingredient[i]);      
        }
        
        
        return answer;
    }
}