
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;

        int R = board.length;
        int C = board[0].length;
        
        int length = 0;        
        for(int r =0 ; r<R; r++){
            for(int c =0; c<C; c++){
                if(board[r][c]==1)
                    length = Math.max(length, compute(r,c, board));
            }
        }
        
        answer = length*length;
        return answer;
    }
    
    public static int compute(int r, int c, int [][] board){
        
            
        if(r-1<0 || c-1<0) return 1;

        int length = Math.min(board[r-1][c] , board[r][c-1]);
        length = Math.min(length, board[r-1][c-1]);
        
        board[r][c] =length +1;
        return board[r][c];
        
    }
    
    
}