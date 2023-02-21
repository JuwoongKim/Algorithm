import java.util.*;
import java.util.stream.Stream;
import java.io.*;


public class Main{

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 2차원 큐 생성 
        Queue<Queue<String>> rq = new LinkedList<>(); 
        String temp ="";
        while( (temp =br.readLine())!=null){

            String [] strArr = temp.split("");
            Queue<String> cq = new LinkedList<>();

            for(String str : strArr){
                cq.offer(str);
            }
            rq.offer(cq);

        }


        StringBuilder sb = new StringBuilder("");
        while(!rq.isEmpty()){

            Queue<String> cq = rq.poll();

            if(cq.isEmpty()){
                continue;
            }

            sb.append(cq.poll());
            rq.offer(cq);
        }


        System.out.println(sb);

    }
}