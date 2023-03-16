import java.util.*;
import java.util.stream.*;
import java.io.*;



public class Main{

  

    public static List<String> cardList =new ArrayList<>();
    public static Set<String> memoSet = new HashSet<>();


    public static void main(String args []) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<n ; i++){
            cardList.add(br.readLine());
        }
        
        compute(k, new ArrayList<Integer>());
        System.out.println(memoSet.size());
    }

    public static void compute(int k, List<Integer> idxList){

        // 종료조건 
        if(k==0){

            StringBuilder sb = new StringBuilder("");
            for(Integer idx : idxList){
                sb.append(cardList.get(idx));
            }
            memoSet.add(sb.toString());
            return;
        } 

        for( int i =0; i<cardList.size() ; i++ ){
            if(idxList.contains(i)) continue;
            idxList.add(i);
            compute(k-1, idxList);
            idxList.remove(idxList.size()-1);
        }

    }

}