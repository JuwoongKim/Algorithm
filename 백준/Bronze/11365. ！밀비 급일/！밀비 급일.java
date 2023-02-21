import java.io.*;

public class Main{

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = "";

        while(!(temp=br.readLine()).equals("END")){
            
            StringBuilder sb = new StringBuilder(temp);
            sb.reverse();
            System.out.println(sb);
        }

    }
}