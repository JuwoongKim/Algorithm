import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        
        Map<String, Integer> map = getMap(name, yearning);
        
        List<Integer> answerList = new ArrayList<>();
        
        int R = photo.length;
         
        for(int r=0; r<R; r++){
            int sum=0;
            int C = photo[r].length;
            for(int c=0; c<C; c++){
                if(map.containsKey(photo[r][c]))
                    sum += map.get(photo[r][c]);
            }
            answerList.add(sum);
        }
        
        answer = answerList.stream().mapToInt(i->i).toArray();        
        return answer;
    }
    
    public static Map<String, Integer> getMap(String[] name, int[] yearning){
     
        Map<String, Integer> map = new HashMap<>();
        
        int N = name.length;
        for(int i =0; i<N; i++){
            map.put(name[i], yearning[i]);  
        }
        return map;        
    }
    
    
}