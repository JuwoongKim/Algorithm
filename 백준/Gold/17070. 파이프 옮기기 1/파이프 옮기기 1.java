import java.util.*;
import java.io.*;
import java.util.stream.*;

class Main{

    public static int answer = 0;
    public static int [][] map;
    public static int [] modeR = {0, 1, 1};   // 가로 세로 대각선  
    public static int [] modeC = {1, 0, 1};
    public static int desR;
    public static int desC;
    
    
    public static void main(String [] args )throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        desR = n-1;
        desC = n-1;

        //map 정보갱신 
        map = new int [n][n];
        for(int i =0; i<n; i++){
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs (0,1,0); 
        System.out.println(answer);
    }


    public static void dfs (int r, int c, int mode) {

        if(r==desR && c ==desC){
            answer++;
            return;
        }

        for(int i =0; i<3; i++){

            if(mode==0  && i==1  )    continue;         // 가로이면 
            else if(mode ==1 && i==0) continue;         // 세로이면  
   
            int nextR = r + modeR[i];
            int nextC = c + modeC[i];    
            if( !isPassible(i, nextR, nextC)) continue;
            dfs(nextR, nextC, i);

        }


        
    }

    public static boolean isPassible(int mode , int r , int c ){

        int n = map.length;

        if(  r<0 || r>= n || c<0 || c>=n || map[r][c] == 1) return false;

        if(mode ==0){   // 가로 
//            if(  r<0 || r>= n || c-1<0 || c-1>=n || map[r][c-1] == 1) return false;

        }else if(mode ==1){ // 세로             
//            if(  r-1 <0 || r-1 >= n || c<0 || c>=n || map[r-1][c] == 1) return false;

        }else if (mode ==2){ // 대각선 
            if(  r<0 || r>= n || c-1<0 || c-1>=n || map[r][c-1] == 1) return false;
            if(  r-1 <0 || r-1>= n || c<0 || c>=n || map[r-1][c] == 1) return false;

        }

        return true;
    }


}


