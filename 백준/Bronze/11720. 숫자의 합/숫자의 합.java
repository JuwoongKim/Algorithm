import java.util.*;
import java.util.stream.Stream;
import java.io.*;


public class Main{

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int sum = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

    }
}