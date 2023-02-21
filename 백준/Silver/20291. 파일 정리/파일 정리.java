import java.util.*;
import java.io.*;

public class Main{

    public static void main(String [] args) throws IOException {

        SortedMap<String, Integer> map = new TreeMap<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());

        for(int i =0; i<n ; i++){

            String str = br.readLine();
            int idx = str.indexOf(".");
            map.put(str.substring(idx+1),map.getOrDefault(str.substring(idx+1),0)+1);
             
        }

        for( Map.Entry<String, Integer> entry : map.entrySet() ){

            System.out.println(entry.getKey() + " "+ entry.getValue());
        }

    }
}