import java.util.*;
import java.io.*;
import java.util.stream.*;

/*
 * 문제조건 
 *
 * 독립집합 - 인접하지 않은 정점들의 집합  
 * 독립집합 크기 - 정점의 가중치 합 
 * 최대 독립집합 - 가중치 합 최대의 독립집합             
 * 
 * 예외고려 
 * -1. 독립집합이 없는 경우 있음 
 * -2. 최대 독립집합이 2개 일 수 있음 
 */



class Main{

    public static void main(String [] args )throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //가중치 표현 
        int [] tempWeight = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] weight = new int [n+1];
        for(int i =0 ; i<n; i++ )
            weight[i+1] = tempWeight[i];


        //그래프 표현 ... 2차원 리스트 
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i<n+1; i++)
            graph.add(new ArrayList<>());

        for(int i =0; i<n-1; i++){
            int [] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(input[0]).add(input[1]);
            graph.get(input[1]).add(input[0]); 
        }        



        // dfs , root = 1 
        boolean [] visit = new boolean [n+1];
        int [][] dp = new int [n+1][2];


        dfs(1, visit, graph, weight, dp);

        List<Integer> group = new ArrayList<>();
        visit = new boolean [n+1];
        if(dp[1][1]> dp[1][0]){            
            System.out.println(dp[1][1]);
            dfs2(1, 1, visit,  graph, dp, group); 
            Collections.sort(group);
            for(int ele : group)
                System.out.print(ele +" ");

        }else{
            System.out.println(dp[1][0]);
            dfs2(1, 0, visit,  graph, dp, group); 
            Collections.sort(group);
            for(int ele : group)
                System.out.print(ele +" ");         
        }


    }


    public static void dfs(int node , boolean [] visit, List<List<Integer>> graph ,  int [] weight ,int [][]dp ){

        visit[node] = true; 

        // 리프노드일때 : 인접노드가 하나, 해당 노드가 방문되었을때
        if(graph.get(node).size()==1 &&  visit[graph.get(node).get(0)]){
            dp[node][1] = weight[node];
            dp[node][0] = 0;
           

            // System.out.println("node  : " + node);
            // for(int i =1; i<graph.size(); i++ )
            //     System.out.print(dp[i][1]+ " ");
            // System.out.println();     
            // for(int i =1; i<graph.size(); i++ )
            //     System.out.print(dp[i][0] + " ");
            // System.out.println();            

            return;
    
        }

        // 리프노드가 아닐때 
        int contain = 0;
        int notContain = 0;

        for( int ele : graph.get(node)){
            if(visit[ele]) continue;

            dfs(ele, visit, graph, weight, dp);

            contain += dp[ele][0];
            notContain += Math.max(dp[ele][0], dp[ele][1]);

        }

        dp[node][1] = weight[node] +  contain;
        dp[node][0] = notContain;


        // System.out.println("node  : " + node);
        // for(int i =1; i<graph.size(); i++ )
        //     System.out.print(dp[i][1]+ " ");
        // System.out.println();      
        // for(int i =1; i<graph.size(); i++ )
        //     System.out.print(dp[i][0] + " ");
        // System.out.println();            


        return;
    }


    public static void dfs2(int node, int bit, boolean [] visit, List<List<Integer>> graph,  int [][]dp, List<Integer> group){

     
        visit[node] = true;

        if(bit==1){  // 1 이여서 포함할때 

            group.add(node);

            for(int ele : graph.get(node)){
                if(visit[ele]) continue;
                
                dfs2(ele, 0,visit,  graph, dp, group);     // 무조건 0 이여야 함 
            }

        }else{      // 0 이여서 포함하지 않을때 

            for(int ele : graph.get(node)){
                if(visit[ele]) continue;
                
                // 1이 더크다면 1, 0이 더 크다면 0 
                if(dp[ele][1] > dp[ele][0]) dfs2(ele, 1, visit,  graph, dp, group);   
                else dfs2(ele, 0, visit,  graph, dp, group); 
                
            }            

        }

    }

}