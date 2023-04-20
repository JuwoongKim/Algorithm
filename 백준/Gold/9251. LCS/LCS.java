import java.util.*;
import java.io.*;

class Main{

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b= br.readLine();

        int aN = a.length();
        int bN = b.length();

        String [] aArr = new String [aN+1];
        String [] bArr = new String [bN+1]; 
        int [][] dp = new int [bN+1][aN+1];

        makeArr(a, aArr);
        makeArr(b, bArr);

        for(int r =1; r<=bN; r++){
            for(int c =1; c<=aN; c++){
                if(bArr[r].equals(aArr[c])){ 
                    //단어가 일치할떄 
                    dp[r][c] = dp[r-1][c-1]+1;
                    continue;
                }else{
                    //일치하지 않을때 
                    dp[r][c] = Math.max(dp[r][c-1] , dp[r-1][c]);
                    continue;
                }
            }
        }

        System.out.println(dp[bN][aN]);

    }


    public static void makeArr(String s , String [] sArr){

        int sN = s.length();
        for(int i =0; i<sN; i++){
            sArr[i+1] = s.substring(i, i+1);
        }
    }
}