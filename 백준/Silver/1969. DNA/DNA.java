import java.util.*;
import java.io.*;


public class Main{



    public static void main( String [] args ) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] strArr = new String [n][m];

        for (int i =0; i <n ; i ++){
            strArr[i] = br.readLine().split("");
        }

        Character temp = 'A';
        List<String> list = new ArrayList<>();
        for(int i =0; i < 26 ; i++){
            list.add(String.valueOf(temp));
            temp ++;
        }
        

        String [] answer = new String [m];
        int sum =0; 

        for(int c =0; c<m ; c++){
            
            String eleStr = "";
            int eleSum = Integer.MAX_VALUE;

            for(String ele : list){

                int tempSum =0;
                for(int r =0; r<n ; r++){

                    if(!ele.equals(strArr[r][c])){
                        tempSum ++;
                    }
                }

                if(tempSum<eleSum){
                    eleStr = ele;
                    eleSum = tempSum;
                }
            }

            answer[c]=eleStr;
            sum += eleSum;
            
        }

        for(int i=0; i<m; i++){
            System.out.print(answer[i]);    
        }
        System.out.println();
        System.out.println(sum);


    }

}
