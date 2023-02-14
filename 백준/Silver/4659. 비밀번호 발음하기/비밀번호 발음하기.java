import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        List<Character> vowels = Arrays.asList('a','e','i','o','u');



        while(!str.equals("end")){

            // 모음 반드시 포함
            boolean isSatisfied = true;
            boolean hasVow = false;
            int isVow=0;
            int isCon=0;

            for(int i =0 ; i<str.length() ; i++){

                char temp = str.charAt(i);

                // 1번쨰 조건
                if(vowels.contains(temp)) {
                    hasVow = true;
                    isVow ++;
                    isCon =0;
                    if(isVow==3){
                        isSatisfied =false;
                        break;
                    }
                }else{
                    isCon ++;
                    isVow=0;
                    if(isCon==3){
                        isSatisfied =false;
                        break;
                    }
                }


                // 3번쨰 조건을 위한...
                if(i != str.length()-1 && temp != 'e' && temp !='o'){

                    if(temp == str.charAt(i+1)){
                        isSatisfied=false;
                        break;
                    }
                }
            }


            if(!hasVow) isSatisfied =false;

            if(isSatisfied) System.out.println( "<"+str +">"+" is acceptable.");
            else System.out.println( "<"+str +">"+" is not acceptable.");

            str =br.readLine();
        }


    }

}
