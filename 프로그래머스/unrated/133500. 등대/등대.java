import java.util.*;


class Solution {
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        // 그래프 생성 
        for(int i =0; i<=n; i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge : lighthouse){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // 트리디피 연산 
        boolean [] visit = new boolean [n+1];
        int [][] dp = new int [n+1][2]; 
        
        //루트노드를 1로 고정 
        dfs(1, graph, visit, dp);        
        answer = Math.min(dp[1][0], dp[1][1]);
    
        return answer;
    }
    
    public static void dfs (int node, List<List<Integer>> graph, boolean [] visit, int [][] dp){
        
        // 노드 방문 
        visit[node] = true;
        
        //리프노드일때 
        if(graph.get(node).size()==1 && visit[graph.get(node).get(0)]){
            
            dp [node][1] = 1;
            dp [node][0] = 0;
            return; 
        }
        
        //리프노드가 아닐때  
        dp [node][1] = 1;
        dp [node][0] = 0;   
        for(int adjacent : graph.get(node)){
            
            if(visit[adjacent]) continue;
            
            dfs(adjacent, graph, visit, dp);
            
            dp [node][1] += Math.min(dp[adjacent][1], dp[adjacent][0]); // 있으면 상관없음   
            dp [node][0] += dp[adjacent][1];                            // 없으면 무조건 1이어야함 
        }
        
    }
    
    
}