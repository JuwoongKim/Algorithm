import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    
    public static int [][] map ;
    public static boolean[][] visit;

    public static int answer = Integer.MAX_VALUE;
    public static int MAX_LEVEL = 3;

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int [n][n];
        visit = new boolean[n][n];

        for(int i =0; i<n ; i++){
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer ::parseInt).toArray();
        }

        dfs(0, 0);
        System.out.println(answer);

    }


    public static void dfs (int level, int money ){


        if(level ==MAX_LEVEL){

            answer = Math.min(answer, money);
            return;
        }

        for(int r =1; r<map.length-1 ; r++){
            for(int c =1; c<map.length-1; c++){

                if(isOverlap(r,c)) continue;

                changeVisit(r, c);
                money += getCost(r, c);

                dfs(level+1, money);

                changeVisit(r, c);
                money -= getCost(r, c);
            }
        }

    }


    public static boolean isOverlap(int r, int c){

        if(visit[r][c] || visit[r][c+1] || visit[r+1][c] || visit[r][c-1] || visit[r-1][c]){
            return true;
        }

        return false;
    }



    public static void changeVisit(int r, int c ){

        // 동
        visit[r][c+1] = (visit[r][c+1]) ? false : true;
        // 남
        visit[r+1][c] = (visit[r+1][c]) ? false : true;
        // 서
        visit[r][c-1] = (visit[r][c-1]) ? false : true;
        // 북
        visit[r-1][c] = (visit[r-1][c]) ? false : true;

    }

    public static int getCost(int r, int c){
        return  map[r][c] + map[r][c+1] + map[r+1][c] + map[r][c-1] + map[r-1][c];
    }


}
