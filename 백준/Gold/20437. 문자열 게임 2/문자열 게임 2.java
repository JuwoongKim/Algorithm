import java.util.*;
import java.io.*;


public class Main {
    

    public static void main(String [] args) throws IOException{

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int n = Integer.parseInt(br.readLine());


         for(int i =0; i<n ; i++){

            // 필요한 자료구조 만듬 
            Map<String , List<Integer>> idxMap = makeIdxMap();

            // 자료구조 정보 저장 
            int j =0;
            for(String s : Arrays.asList(br.readLine().split(""))){

                idxMap.get(s).add(j);
                j++;
            }

            // k 입력 
            int k = Integer.parseInt(br.readLine());

            
            // 연산
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE; 
            for(Map.Entry<String , List<Integer>> entry : idxMap.entrySet()){

                if(entry.getValue().size()<k)
                    continue;

                for(int h =0; h+k-1<entry.getValue().size() ; h++){

                    int tempLength = entry.getValue().get(h+k-1) - entry.getValue().get(h)+1;
                    min = Integer.min(min,tempLength);
                    max = Integer.max(max,tempLength ); 
                }        

            }

            if(min==Integer.MAX_VALUE && max==Integer.MIN_VALUE){
                System.out.println("-1");
            }else{
                System.out.println(min + " " + max);
            }
        }

    }


    public static Map<String , List<Integer>> makeIdxMap(){

        Map<String , List<Integer>> idxMap = new HashMap<>();
        char c = 'a';

        for(int i =0; i<26;i++){
            idxMap.put(String.valueOf(c), new ArrayList<>());
            c++;
        }

        return idxMap;
    }


}
