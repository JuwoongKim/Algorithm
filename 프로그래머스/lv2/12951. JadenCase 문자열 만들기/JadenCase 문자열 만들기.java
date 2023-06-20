import java.util.*; 

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String [] arr = s.toLowerCase().split("");
        StringBuilder sb = new StringBuilder("");
        
        for(int i =0; i< arr.length; i++){
            
            // 첫문자가 알파벳이라면 
            if(i==0){
                if(Character.isAlphabetic(arr[i].charAt(0))){
                    arr[i] = arr[i].toUpperCase();
                }   
                sb.append(arr[i]);
                continue;
            }

            // 공백이후의 문자가 알파벳벳이라면 
            if(arr[i-1].equals(" ") && Character.isAlphabetic(arr[i].charAt(0))){
                arr[i] = arr[i].toUpperCase(); 
            }
            sb.append(arr[i]);    
        }
        
        answer = sb.toString();
        
        
        return answer;
    }
}