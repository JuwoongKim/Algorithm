class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = {};
 
        // 당구대의 가로 길이 m, 세로 길이 n
        int [] sp = new int [] {startX, startY};
                
        int N = balls.length;
        answer = new int [N];
        
        for(int i =0; i<N; i++){            
            int d = getMinDistance(sp, balls[i], m, n);
            answer[i] = d;
        }
        
        return answer;
    }
    
    public static int getMinDistance (int [] sp, int [] ep, int m,int n ) {
        
        int d = Integer.MAX_VALUE;
        int x1 = sp[0];  int y1 = sp[1];
        int x2 = ep[0];  int y2 = ep[1];
        // 당구대의 가로 길이 m, 세로 길이 n
        
        int w =0;   int h =0;
        
        //동 
        if(  !(y1==y2 && x1<x2) ){
            w= 2*m- (x1 +x2);
            h = Math.abs(y1-y2);
            d= Math.min(d, getDistance(w,h));
        }
        
        //남 
        if(  !(x1==x2 && y1>y2) ){
            w = Math.abs(x1-x2);
            h = y1+y2;
            d= Math.min(d, getDistance(w,h));
        }
        
        //서
        if( !(y1==y2 && x1>x2)  ){
            w = x1 +x2;
            h = Math.abs(y1-y2);
            d = Math.min(d, getDistance(w,h));            
        }
        
        //북 
        if(  !(x1==x2 && y1<y2)   ){
            w = Math.abs(x1-x2);
            h = 2*n-(y1+y2);
            d= Math.min(d, getDistance(w,h));            
        }
        
      
        return d;
    }
    
    public static int getDistance(int w, int h){
        
        double d  =   Math.pow(w,2) +  Math.pow(h,2); 
        return  (int)d;
        
    }
    
    
}