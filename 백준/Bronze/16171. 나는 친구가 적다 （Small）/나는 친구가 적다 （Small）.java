import java.util.*;
import java.io.*;


public class Main{

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine().replaceAll("[0-9]", "");
        String k = br.readLine() ;  

        if(s.contains(k)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }

    }

}