import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    public static int answer = Integer.MAX_VALUE;

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int [] sList = new int[n];
        int [] bList = new int[n];

        for(int i =0; i<n ; i++){

            st = new StringTokenizer(br.readLine());
            sList[i] = Integer.parseInt(st.nextToken());
            bList[i] = Integer.parseInt(st.nextToken());
        }

        // 비트마스킹 집합 순회 

        List<Integer> idxList = new ArrayList<>();

        for(int i =0; i < 1<<n; i++){

            for(int j=0; j<n ; j++){

                if( (i& 1<<j) !=0){
                    idxList.add(j);
                }
            }

            if(idxList.isEmpty()) continue;

            answer = Math.min(answer, compute(idxList, sList, bList));
            if(answer==0) break;
            idxList.clear();
        }

        System.out.println(answer);

    }

    public static int compute (List<Integer> idxList, int[] sList, int []bList ){

        int sMulti=1;
        int bSum =0;
        for(int idx : idxList){
            sMulti *= sList[idx];
            bSum += bList[idx];
        }
 
        return Math.abs(sMulti-bSum);
    }
}
