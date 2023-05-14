import java.util.*;

class Solution {
    
    public static Map<Character, Integer> map;
    public static int answer;
    public int solution(int n, String[] data) {

        answer=0;
        map = new HashMap<>();
        map.put('A' , 0);
        map.put('C' , 1);
        map.put('F' , 2);
        map.put('J' , 3);
        map.put('M' , 4);
        map.put('N' , 5);
        map.put('R' , 6);
        map.put('T' , 7);
                
        int [] arr = new int [8];
        boolean [] visit = new boolean [8];
        rec(0,arr,visit,data);
        
        return answer;
    }
    
    
    public static void rec(int idx, int [] arr,  boolean [] visit ,String[] data){
        
        if(idx == arr.length){
            if(isSatisfied(arr,data)){
                answer ++;
            }    
            return;
        }
        
        for(int i =0; i<8; i++){
            if(visit[i]) continue;     
            visit[i] = true;
            arr[idx] =i;
            rec(idx+1, arr, visit, data);
            visit[i] = false;
        }
    }
    
    public static boolean isSatisfied( int [] arr, String[] data){
             
        for(String s : data){
            
            char st = s.charAt(0);
            char ed = s.charAt(2);
            String op = String.valueOf(s.charAt(3));
            int bd = Integer.parseInt(String.valueOf(s.charAt(4) ));
            int pd = Math.abs( arr[map.get(st)] - arr[map.get(ed)] )-1;
            
            switch(op){              
                case "=" :
                    if(pd!=bd) return false;
                    break;
                    
                case "<":
                    if(pd>=bd) return false;
                    break;
                    
                case ">":
                    if(pd<=bd) return false;
                    break;              
            }
        }
        
        return true;
    }
    
    
    
    
}