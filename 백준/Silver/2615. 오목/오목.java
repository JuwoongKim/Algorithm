import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    
    public static int [][] map = new int [19][19];

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

        for(int i =0 ; i<19 ; i++){
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int r =0; r <19; r ++){
            for(int c =0 ; c<19 ; c ++){

                if(map[r][c]== 0) continue;

                if(map[r][c]== 1){

                    if(isSatisfied(r ,c , 1)){

                        System.out.println(1);
                        System.out.println((r+1) + " "+ (c+1));

                        return;
                    }

                    continue;
                } 

                if(map[r][c]== 2) {
                 
                    if(isSatisfied(r ,c , 2)){

                        System.out.println(2);
                        System.out.println((r+1) + " "+ (c+1));

                        return;
                    }                 
                    continue;

                }
            }

           
        
        }


        System.out.println(0);
         
    }


    public static boolean isSatisfied(int r, int c , int ele){

 
        // 4 가지 방법중 하나라도 성공하면 성공임

        // 오른쪽 직선 

        int tempR =r;
        int tempC =c;
        int tempCnt = 1; 
        while(true){

            tempC ++;
            if(tempC>=19 || map[tempR][tempC] !=ele) break;

            tempCnt ++;
        }

        if(tempCnt==5){
            if( c==0 ) return true;
            if( map[r][c-1] != ele) return true;
        }



        // 오른쪽 아래 대각선 
        tempR =r;
        tempC =c;
        tempCnt = 1; 
        

        while(true){

            tempR ++;
            tempC ++;
  
            if( tempR>=19 || tempC>=19 || map[tempR][tempC] !=ele) break;

            tempCnt++;
        }

        if(tempCnt==5){

            if(r==0 || c ==0) return true;
            if( map[r-1][c-1] != ele) return true;

        }


        // 아래
        tempR =r;
        tempC =c;
        tempCnt = 1; 
        
        while(true){

            tempR ++;
            if( tempR>=19 || tempC>=19 || map[tempR][tempC] !=ele) break;
            tempCnt++;
        }

        if(tempCnt==5){

            if(r==0) return true;
            if(map[r-1][c] !=ele) return true;

        }





        // 오른쪽 위  대각선 
        tempR =r;
        tempC =c;
        tempCnt = 1; 
        
        while(true){

            tempR --;
            tempC ++;
            if( tempR<0  || tempC>=19 || map[tempR][tempC] !=ele) break;

            tempCnt++;
        }

        if(tempCnt==5){

            if(r==18 || c==0) return true;
            if(map[r+1][c-1] != ele) return  true;

        }

        return false;
    }
}
