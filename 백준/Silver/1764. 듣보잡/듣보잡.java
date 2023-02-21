import java.util.*;
import java.io.*;

public class Main{

    public static void main(String [] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());


        SortedMap<String, Integer> map = new TreeMap<>(); 

        // n 연산 
        for(int i =0; i<n ; i++){
            String temp = br.readLine(); 
            map.put(temp, 1);

        }

        // m 연산 
        for(int i = 0 ; i<m ; i++){
            String temp = br.readLine(); 
            map.put(temp, map.getOrDefault(temp,0) +1);
        }


        // 정답용 자료구조 
        List<String> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){

            if(entry.getValue()==2){
                answer.add(entry.getKey());
            }
        }

        System.out.println(answer.size());
        answer.stream().forEach(System.out::println);


    }
}