import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException{

        int answer =0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String str;
        for(int i =0; i <num; i++){
            str = br.readLine();
            if(isGroup(str)){
                answer ++;
            }
        }

        System.out.println(answer);
    }


    public static boolean isGroup(String str){

        boolean result = true;

        List<Character> check = new ArrayList<>();

        for(int i=0; i<str.length(); i++){

            if(check.contains(str.charAt(i))){
                result = false;
                break;
            }

            if(i==str.length()-1){
                check.add(str.charAt(i));
                continue;
            }

            if( str.charAt(i)==str.charAt(i+1) ){
                continue;
            }else{
                check.add(str.charAt(i));
            }

        }

        return result;
    }

}
