import java.util.*;

class Node{
    int idx;
    int value;
    public Node (int idx, int value){
        this.idx = idx;
        this.value = value;
    }
}

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Stack<Node> st = new Stack<>();
        int N = numbers.length;
        answer = new int [N] ;
        for(int i =0; i<N; i++){
            
            if(st.size()!=0){
                while(st.size()!=0 && st.peek().value<numbers[i]){
                    Node node = st.pop();
                    answer[node.idx] = numbers[i] ;
                }
            }
            st.push(new Node(i, numbers[i]));
        }
        
        while(st.size()!=0){
            Node node = st.pop();
            answer[node.idx] = -1;
        }
        
        return answer;
    }
}