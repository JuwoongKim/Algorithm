import java.util.*;
import java.io.*;

public class Main{

    public static void main(String [] args) throws IOException {


        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        
        
        String [] strArr = br.readLine().split("");

        for( int idx =0 ; idx <strArr.length; idx ++){


            if(strArr[idx].equals(" ")){
                
                while(!stack.isEmpty())
                    sb.append(stack.pop());
                
                sb.append(strArr[idx]);
                continue;
            }

            if(strArr[idx].equals("<")){

                while(!stack.isEmpty())
                    sb.append(stack.pop());

                
                while(!strArr[idx].equals(">")){
                     sb.append(strArr[idx]);
                     idx ++;
                }    
                sb.append(strArr[idx]);
                continue;
            }

            stack.push(strArr[idx]);

        } 
        
        while(!stack.isEmpty())
            sb.append(stack.pop());
        

        System.out.println(sb);

    }
}