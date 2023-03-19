import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    public static int answer = Integer.MAX_VALUE;

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int [][] scoreMap = new int[n][n];

        for(int i =0; i<n ; i++){
            scoreMap[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 비트마스킹 집합 순회 

        List<Integer> idxList = new ArrayList<>();

        for(int i =0; i < 1<<n; i++){

            for(int j=0; j<n ; j++){

                if( (i& 1<<j) !=0){
                    idxList.add(j);
                }
            }

            if(idxList.isEmpty()|| idxList.size()==n) continue;

            answer = Math.min(answer, compute(idxList, scoreMap));
            if(answer==0) break;
            idxList.clear();
        }

        System.out.println(answer);

    }

    public static int compute (List<Integer> idxList, int[][] scoreMap){

        int result =0;
        List<Integer> startTeamIdx = new ArrayList<>();
        List<Integer> linkTeamIdx = new ArrayList<>();

        for(int i =0; i<scoreMap.length; i++){

            if(idxList.contains(i)) startTeamIdx.add(i);
            else linkTeamIdx.add(i);

        }
        
        return Math.abs( getScore(startTeamIdx, scoreMap) - getScore(linkTeamIdx, scoreMap));
    }


    public static int getScore (List<Integer> idxList, int[][] scoreMap){

        int score = 0 ;

        for(Integer ele1 : idxList){
            for(Integer ele2 : idxList){
                score += scoreMap[ele1][ele2];
            }
        }

        return score;
    }

}
