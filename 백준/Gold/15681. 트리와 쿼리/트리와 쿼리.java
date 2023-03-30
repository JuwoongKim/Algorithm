import java.util.*;
import java.io.*;
import java.util.stream.*;


class Main{

    public static void main(String [] args ) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 그래프 생성 및 표현  ... 더블 링크드리스트로 표현 
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i<=N; i++)
            graph.add(new ArrayList<>());
            
        for(int i =0; i<N-1; i++){

            int [] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(input[0]).add(input[1]);
            graph.get(input[1]).add(input[0]);

        }
        
        // 그래프 dfs 탐색 
        boolean [] visit = new boolean [N+1];
        int [] treeDP = new int [N+1];
        int result = dfs(R, visit, graph, treeDP);

        // // 루트의 노드 수 
        // System.out.println(result);
        // // 트리디피 
        // System.out.println(Arrays.toString(treeDP));

        for(int i =0; i<Q; i++ ){
            int num = Integer.parseInt(br.readLine());
            System.out.println(treeDP[num]);
        }
    }

    public static int dfs(int node , boolean []visit, List<List<Integer>>graph,int [] treeDP ){

        visit[node] = true;
        
        int numOfNode= 1; 
        for(int ele : graph.get(node)){

            if(visit[ele]) continue;

            numOfNode += dfs(ele, visit, graph, treeDP);
        }

        treeDP[node] = numOfNode;
        return numOfNode;
    }



}