import java.util.*;
import java.io.*;


public class Main {
    
    static  String [] strArr;

    public static void main(String [] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        strArr = new String [n];

        // 값 입력 
        for(int i =0; i<n; i++){
            strArr[i] = br.readLine();
        }

        // 정답생성 
        List<String> answer = new ArrayList<>();

        int lt = 0;
        int rt = n-1;


        // 연산 
        while(lt <= rt){

            if(lt==rt) {
                answer.add(strArr[lt]);
                break;
            }

            int compareBit =strArr[lt].compareTo(strArr[rt]);

            if(compareBit ==0)                  // 동일하다면 다음것으로 탐색 
                compareBit = (isLt(lt, rt)) ? -1 : 1; 
            
            if(compareBit<0)                   // 왼쪽이 더 우선순위가 높다 
                answer.add(strArr[lt++]);
            else                                // 오른쪽이 더 우선순위가 높다
                answer.add(strArr[rt--]);

        }

        //출력 
        for(int i =0, k=1 ; i< answer.size() ; i++, k++){

            System.out.print(answer.get(i));
            if(k%80==0){
                System.out.println();
            }
        }

    }

    
    public static boolean isLt(int lt, int rt){

        int tempLt = lt;  int tempRt = rt ;

        do{
            tempLt ++;  tempRt --;
            if(tempLt >=tempRt)
                return true;

        }while(strArr[tempLt].compareTo(strArr[tempRt])==0);

        if( strArr[tempLt].compareTo(strArr[tempRt]) <0  ){
            return true;
        }else{
            return false;
        }
    }
}
