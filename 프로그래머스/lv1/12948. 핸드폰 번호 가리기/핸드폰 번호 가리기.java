class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int startIdx = phone_number.length()-4;

        StringBuilder sb = new StringBuilder("");
        for(int i =0; i< startIdx; i++){
            sb.append("*");
        }

        sb.append(phone_number.substring(startIdx));
        answer = sb.toString();
        
        return answer;
    }
}