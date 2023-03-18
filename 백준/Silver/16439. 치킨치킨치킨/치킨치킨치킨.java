import java.util.*;
import java.util.stream.*;
import java.io.*;



public class Main {
    
    public static int MAX_LEVEL = 3;

    public static int answer = Integer.MIN_VALUE;

    public static void main (String [] args) throws IOException {


        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] arr = new int [n][m];
        
        for(int i =0; i <n; i++){
            arr[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, new ArrayList<>(), arr, m);
        System.out.println(answer);
    
    }

    public static void dfs(int level, List<Integer> memo, int[][] arr, int m){

        if(level ==MAX_LEVEL){

            int result = getResult(memo, arr);
            answer = Math.max(answer, result);
            return;
        }


        // 치킨 선택 
        for(int i =0 ; i<m ; i++){

            if(memo.contains(i)) continue;

            memo.add(i);
            dfs(level+1, memo, arr, m);
            memo.remove(memo.size()-1);

        }


    }


    public static int  getResult(List<Integer> memo, int[][] arr){

        int sum =0;

        for(int i =0; i<arr.length ; i++){

            int temp= Integer.MIN_VALUE;

            for(int idx : memo){
                
                temp = Math.max(temp, arr[i][idx]);
            }
            sum += temp;
        }        
        return sum;
    }

}
