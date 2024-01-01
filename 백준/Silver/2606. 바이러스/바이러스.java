import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {


    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
        
        int numOfCom = Integer.parseInt(br.readLine());
        int numOfLink = Integer.parseInt(br.readLine());


        boolean [] visit = new boolean[numOfCom+1];
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i<= numOfCom; i++){
            graph.add(new ArrayList<>());
        }

        // 그래프 연결 정보 생성 
        for(int i =0; i< numOfLink; i++){

            int [] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.get(input[0]).add(input[1]);
            graph.get(input[1]).add(input[0]);

        }


        // 1번시작으로 그래프 탐색  BFS  --> 다음에는 dfs로 풀어보기 

        Queue<Integer> q = new LinkedList<>();
        int answer = 0;

        q.offer(1);
        visit[1] = true;

        while(!q.isEmpty()){

            int temp = q.poll();

            for(int idx : graph.get(temp)){

                if(visit[idx]) continue;

                q.offer(idx);
                visit[idx] = true;
                answer ++;
            }

        }
        
        System.out.println(answer);
    }   

}
