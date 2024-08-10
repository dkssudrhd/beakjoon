package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1806 {

    static int[] array;
    static int n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        array = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int small = 100000;
        int start = 0;
        int finish = 0;

        int sum =0;

        while(true){

            if( sum < s ){
                if(finish >=n){
                    break;
                }
                sum += array[finish];
                finish++;
                if(sum >= s && small > finish - start){
                    small = finish - start;
                }
            } else{
                sum -= array[start];
                start++;
                if(sum >= s && small > finish-start){
                    small = finish - start;
                }
            }
        }
        if(small == 100000){
            System.out.println(0);
        } else {
            System.out.println(small);
        }

    }
}