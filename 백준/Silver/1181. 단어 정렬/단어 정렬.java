import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args)throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        SortedSet<String> set = new TreeSet<>( 
            
            new Comparator<String>(){

                @Override   //값이 음수이면 우선순위가 높아짐 
                public int compare(String o1, String o2){

                    if(o1.length() != o2.length()){
                        return o1.length() - o2.length();   

                    }else{
                        
                        return o1.compareTo(o2);    // 사전순으로 앞서면 음수반환 
                    }
                }
            }

        );

        for(int i =0; i<n ; i++){
            set.add(br.readLine());
        }

        for(String ele : set){
            System.out.println(ele);
        }

    }
    
}
