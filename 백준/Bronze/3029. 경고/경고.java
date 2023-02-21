import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String [] current = br.readLine().split(":");
        String [] future = br.readLine().split(":");

        int inputSameCnt = 0;
        for(int k=0; k<3; k++){
            if(current[k].equals(future[k])) inputSameCnt ++;
        }

        if(inputSameCnt == 3 ){
            System.out.println("24:00:00");
            return;
        }

        StringBuilder sb = new StringBuilder("");
        boolean isBorrow =false;

        for(int i = current.length-1; i>=0 ; i--){

            int tCurrent = Integer.parseInt(current[i]);
            int tFuture = Integer.parseInt(future[i]);
            if(isBorrow) {
                tFuture--;
                isBorrow = false;
            }
            if(tCurrent>tFuture){
                if(i==0) tFuture +=24;
                else tFuture +=60;
                isBorrow = true;
            }

            int value = tFuture-tCurrent;
            StringBuilder subSb= new StringBuilder(Integer.toString(value));
            if (value<10) subSb.insert(0,"0");
            subSb.insert(0,":");
            sb.insert(0,subSb.toString());
        }

        sb.deleteCharAt(0);
        System.out.println(sb.toString());

    }
}