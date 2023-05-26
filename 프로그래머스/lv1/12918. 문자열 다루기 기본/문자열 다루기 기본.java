class Solution {
    public boolean solution(String s) {

        // 길이 확인 
        if( !(s.length()==4 ||s.length()==6) ) return false;
 
        // 숫자여부 확인 
        String replaced = s.replaceAll("[0-9]","");
        if(replaced.length()!=0) return false;
        
        return true;
    }
}