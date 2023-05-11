import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        int N = wires.length;
        for(int i=0; i<N; i++){
            
            // 특정 연결점을 제거한 그래프 생성 
            List<List<Integer>> gp = getGraph(i, wires);
            
            // v1의 연결갯수
            int v1 = wires[i][0]; 
            boolean [] visit = new boolean [n+1];
            visit[v1] = true;
            dfs(v1, visit, gp);
            
            int cnt =0;
            for(boolean b : visit)
                if(b) cnt++;

            // 한쪽의 연결갯수만 알아도 나머지합을 알 수 있다.
            answer = Math.min(answer, Math.abs(n-2*cnt));
        
        }
        
             
        return answer;
    }
                              
    public static void dfs (int node, boolean [] visit, List<List<Integer>> gp){
        
        for(Integer adj : gp.get(node)){
            if(visit[adj]) continue;
            visit[adj]= true;
            dfs(adj, visit, gp);   
        }
    }                       
    
                              
    
    public static List<List<Integer>> getGraph(int idx, int[][] wires){
        
        List<List<Integer>> gp = new ArrayList<>();

        int N = wires.length+1;
        for(int i =0; i<=N; i++)
            gp.add(new ArrayList<>());
        
        N = wires.length;
        for(int i =0; i<N; i++){
            if(i==idx) continue;
            gp.get(wires[i][0]).add(wires[i][1]);
            gp.get(wires[i][1]).add(wires[i][0]);
        }
        
        return gp;
    }
    
}