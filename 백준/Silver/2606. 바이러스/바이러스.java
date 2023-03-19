import java.util.*;
import java.io.*;


public class Main {

    public static boolean [] visit ;
    public static void main(String[] args) throws IOException{

        Main T = new Main();
        BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st ;
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        visit = new boolean [V+1];

        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=V; i++) graph.add(new ArrayList<>());

        for(int i =0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int first =Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        System.out.println(T.solution(graph));
    }

    public int solution (List<ArrayList<Integer>> graph){

        int answer = -1; //자기자신 뺴야함
        DFS(1,graph);
        for(boolean temp : visit){
            if(temp ==true) answer ++;
        }
        return answer;
    }

    public void DFS(int V, List<ArrayList<Integer>> graph){
        for(int adjV :  graph.get(V)){
            if(!visit[adjV]){
                visit[adjV]= true;
                DFS(adjV,graph);
            }
        }
    }
}
