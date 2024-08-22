package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_2473 {

    static long[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new long[n];

        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0; i < n; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        long sum = Long.MAX_VALUE;
        long[] finish = new long[3];

        Arrays.sort(array);

        for(int i=0; i < n-2; i++){
            long start = array[i];
            int middle = i+1;
            int end = n-1;

            while(middle < end){
                long nowMiddle = array[middle];
                long nowEnd = array[end];

                if(sum > Math.abs(start + nowMiddle + nowEnd)){
                    sum = Math.abs(start + nowMiddle + nowEnd);
                    finish[0] = start;
                    finish[1] = nowMiddle;
                    finish[2] = nowEnd;
                }
                if(Math.abs(start + nowMiddle + nowEnd) ==0){
                    break;
                } else if(start + nowMiddle + nowEnd > 0){
                    end--;
                } else{
                    middle++;
                }
            }
        }
        System.out.println(finish[0] + " " + finish[1] + " " + finish[2]);
        br.close();
    }
}
