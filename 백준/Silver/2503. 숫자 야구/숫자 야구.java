import java.util.*;
import java.io.*;
import java.util.stream.*;



class Info{

    List<Integer> numberArr;
    int strike;
    int ball;

    public Info(int number , int strike, int ball){

        this.numberArr = parseNumber(number);
        this.strike = strike;
        this.ball = ball; 
    }

    public List<Integer> parseNumber(int number){

        List<Integer> list = new ArrayList<>();
        
        int third = number%10;

        number = number/10;
        int second = number%10;
        
        int first = number/10;

        list.add(first);
        list.add(second);
        list.add(third);
        
        return  list;
    }


    public boolean isSatisfied(int number){

        List<Integer> numberArr = parseNumber(number);
        int strike =0;
        int ball =0;

        for(int ele : numberArr){

            if(this.numberArr.contains(ele)){
                if(this.numberArr.indexOf(ele) == numberArr.indexOf(ele)){
                    strike ++;
                }else{
                    ball ++;
                }
            }
        }

        if(this.strike == strike && this.ball == ball){
            return true;
        }else{
            return false;
        }

    }
}




public class Main{

    public static List<Info> infoList = new ArrayList<>();

    public static int answer = 0;

    public static void main (String [] args)throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n ; i++){

            int [] inputArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            infoList.add(new Info(inputArr[0], inputArr[1], inputArr[2]));
        }

        compute(new ArrayList<>());

         System.out.println(answer);

    }

    public static void compute( List<Integer> list ){

        if(list.size() ==3 ){

             boolean isAnswer = true;

             int number = list.get(0)*100 + list.get(1)*10 + list.get(2);

            for(Info info : infoList){

                if(!info.isSatisfied(number)){
                    isAnswer = false;
                    break;
                }
            }

            if(isAnswer){
                answer ++;
            }
        
            return;

        }

        for(int i = 1 ; i<=9 ; i ++ ){

            if(list.contains(i)) continue;

            list.add(i);
            compute(list);
            list.remove(list.size()-1);
        }
    }
}