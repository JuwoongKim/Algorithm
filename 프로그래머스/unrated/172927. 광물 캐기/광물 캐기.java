import java.util.*;

class Solution {
    
    public static int [][] info;
    public static int answer;
    public static Map<String, Integer> map;
    
    public int solution(int[] picks, String[] minerals) {
        
        info = new int [][] {{1,1,1},{5,1,1},{25,5,1}};
        answer = Integer.MAX_VALUE;
        
        map = new HashMap<>();
        map.put("diamond",0);
        map.put("iron",1);
        map.put("stone",2);
    
        // 재귀를 통해서 도끼의 사용 순서를 정함 
        rec( new ArrayList<>() , picks, minerals);
        
        return answer;
    }
    
    public static void rec (   List<Integer> order ,int[] picks, String[] minerals) {
        
        if(isEmpty(picks)){
            // 결정된 순서대로 피로도 연산을 수행함 
            // System.out.println(order);
            int score = getScore(order, minerals);
            answer = Math.min(answer, score);
        }
        
        for(int i=0; i<3; i++){
            if(picks[i]==0) continue;
            
            picks[i] --;
            order.add(i);
            rec(order, picks, minerals);
            order.remove(order.size()-1);
            picks[i] ++;
        }
    }
    
    
    
    public static int getScore(List<Integer> order , String[] minerals){
        
        int score =0;
        int mIdx =0;
        boolean isFinished = false;
        
        for( int pick : order){
            
            for(int i =0; i<5; i++){     
                score += info[pick][map.get(minerals[mIdx])];
                mIdx ++;
                if(mIdx== minerals.length){
                    isFinished = true;  break;
                }
            } 
            if(isFinished) break;
        }
        return score;
    }
    
    public static boolean isEmpty(int[] picks){
        
        for(int pick : picks)
            if(pick!=0) return false;
        
        return true;
    }
    
    
    
    
    
}