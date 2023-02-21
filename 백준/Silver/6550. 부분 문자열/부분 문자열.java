import java.util.*;
import java.io.*;


public class Main{

    public static void main(String [] args) throws IOException {


        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String str = "";
        
        while( (str =br.readLine())!=null){

            StringTokenizer st = new StringTokenizer(str, " ");

            String[] s = st.nextToken().split("");
            String[] t = st.nextToken().split("");

            Queue tq = new LinkedList<>();

            for(String tEle : t){
                tq.offer(tEle);
            }

            
            StringBuilder sb = new StringBuilder();
            for(String sEle : s){
                
                while(!tq.isEmpty()){

                    if(sEle.equals(tq.poll())){
                        sb.append(sEle);
                        break;
                    }
                }
            }

            if(s.length == sb.length()){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }

 
    }

}