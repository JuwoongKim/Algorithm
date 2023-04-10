import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
    
        Map<String, Integer> map  = getMap(players);
            
        
        for(String player : callings){
            swap(player, players, map);
        }
        
        answer = players;
        return answer;
    }
    
    public static Map<String, Integer> getMap(String[] players){
        
        Map<String, Integer> map = new HashMap<>();
        
        int N = players.length;
        for(int i =0;i<N; i++)
            map.put(players[i],i);
        
        return map;
    }
    
    
    
    
    
    public static void swap(String player, String []players, Map<String, Integer> map){
       
        //불러진 선수 이름의 등수를 찾는다.     
        int gd = map.get(player);
        
        //이전 선수의 이름을 찾는다.
        String prePlayer = players[gd-1];
        
        //map의 정보를 갱신한다.
        map.put(player, gd-1);
        map.put(prePlayer, gd);
        
        //선수 배열의 정보를 갱신한다.
        players[gd-1] = player;
        players[gd] = prePlayer;
            
    }
    
    
    
}