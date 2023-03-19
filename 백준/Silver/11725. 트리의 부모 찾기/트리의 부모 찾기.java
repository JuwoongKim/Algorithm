
import java.io.*;
import java.util.*;

public class Main {


    public static int [] parentTable ;
    public static boolean [] visit;
    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer st ;
        int V = Integer.parseInt(br.readLine());

        parentTable = new int [V+1];
        visit = new boolean [V+1];

        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=V; i++) graph.add(new ArrayList<Integer>());

        for(int i=0; i< V-1; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        T.DFS(1, graph);
        for(int i=2; i<=V; i++){
            System.out.println(parentTable[i]);
        }
    }

    public void DFS(int start, List<ArrayList<Integer>>graph){

        visit[start] = true;
        for(int adj : graph.get(start)){
            if(!visit[adj]){
                parentTable[adj] = start;
                DFS(adj,graph);
            }
        }
    }

}
