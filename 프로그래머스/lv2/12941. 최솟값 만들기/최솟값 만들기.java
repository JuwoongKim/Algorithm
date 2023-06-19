import java.util.*;



class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);

        int len = B.length - 1;
        for(int i =0; i<B.length; i++){
            answer += A[i]*B[len-i];
        }
        
        return answer;
    }
}