import java.util.Scanner;
import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Collections;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static int conNumber;
    public static int conCount;
    public static int count;
    
	public static void main(String args[]) throws Exception
	{	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{   
            
            System.out.print("#"+test_case);
            conNumber = sc.nextInt();
            conCount=50;
            count=0;
            dfs(1);
            System.out.println();
		}        
	}
    
    public static void dfs(int number){

        while(true){

            // 만약 조건 숫자보다 크다면 종료
            if(number > conNumber || count ==conCount){
                return;
            }
            // 출력함 
            count ++;
            System.out.print(" " + number + ".png");

            // 확장 
            dfs(number*10);
 
            // 다음 숫자로 이동 또는 종료 
            if(number%10 ==9) break;
            number ++;
        }
    }    
}