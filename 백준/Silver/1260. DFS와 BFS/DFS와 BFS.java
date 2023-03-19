import java.util.*;
import java.io.*;

public class Main {

    public static List<Integer> dAnswer= new ArrayList<>();
    public static List<Integer> bAnswer = new ArrayList<>();
    public  static boolean [] visit ;

    public static void main(String[] args) throws IOException{

        Main T = new Main();
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());

        visit = new boolean [V+1];

        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=V; i++) graph.add(new ArrayList<Integer>());
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        for(ArrayList<Integer> list : graph){
            Collections.sort(list);
        }

        T.DFS(startV,graph);
        Arrays.fill(visit,false);
        T.BFS(startV, graph);
        StringBuilder sb = new StringBuilder("");
        for(int ele : dAnswer) sb.append(ele+" ");
        sb.append("\n");
        for(int ele : bAnswer) sb.append(ele+" ");
        System.out.println(sb.toString());
    }

    public void DFS(int start , List<ArrayList<Integer>> graph){

        visit[start]= true;
        dAnswer.add(start);

        for(int ele : graph.get(start)){
            if(! visit[ele]){
                DFS(ele, graph);
            }
        }
    }
    public void BFS(int start , List<ArrayList<Integer>> graph){

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){

            int temp = q.poll();
            visit[temp]=true;
            bAnswer.add(temp);

            for(int ele : graph.get(temp)){
                if(!visit[ele]){
                    visit[ele]= true;
                    q.offer(ele);
                }
            }
        }
    }

}
