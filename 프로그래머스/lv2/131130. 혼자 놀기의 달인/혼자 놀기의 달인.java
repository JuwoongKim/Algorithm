import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        int N = cards.length;
        boolean [] visit = new boolean [N];
        
        List<Integer> boxList = new ArrayList<>();    
        for(int i =0; i<N; i++){
            
            int j=i;
            int cnt =0;
            while(!visit[j]){
                //System.out.println(j);
                cnt ++;
                visit[j] =true;
                j = cards[j]-1;
            }
            //System.out.println();
            boxList.add(cnt);
        }
        Collections.sort(boxList, (o1,o2)->o2-o1);
        
        if(boxList.size()==1) answer =0;
        else answer = boxList.get(0) * boxList.get(1);  
        
        return answer;
    }
}