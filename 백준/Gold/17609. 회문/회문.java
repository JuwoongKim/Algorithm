import java.util.*;
import java.io.*;


public class Main{


    public static void main( String [] args ) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));

        int t = Integer.parseInt(br.readLine());
        
        for(int i =0; i <t; i++){

            String[] strArr = br.readLine().split("");
 
            int lt = 0; int rt = strArr.length -1;

            int answer =0; 
            while(lt<rt){

                if(!strArr[lt].equals(strArr[rt])){

                    if(isPersudoPalindrome(strArr, lt+1, rt) || isPersudoPalindrome(strArr, lt, rt-1)) answer =1;
                    else answer =2;
                    break;
                }
                
                lt ++; rt --;
            }

            System.out.println(answer);
        }

    }

    public static boolean isPersudoPalindrome(String [] strArr, int lt, int rt){

        while(lt<rt){
            
            if(!strArr[lt].equals(strArr[rt]))
                return false;

            lt ++; rt--;
        }
        return true;
    }



}

