class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int [] cnt = new int [2];
        
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)=='p' || s.charAt(i)=='P'){
                cnt[0] ++;
            }else if (s.charAt(i)=='y' || s.charAt(i)=='Y') {
                cnt[1] ++;
            }
        }
        
        if(cnt[0] ==cnt[1]) return true;
        else return false;

    }
}