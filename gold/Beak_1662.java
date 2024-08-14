package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_1662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(inLength(str));

    }
    public static int inLength(String str){
        int size = 0;

        int n=0;
        int start =0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                if(n==0){
                    start = i;
                }
                n++;

            } else if(str.charAt(i) == ')') {
                n--;
                if(n==0){
                    size += Integer.parseInt(str.substring(start - 1, start)) * inLength(str.substring(start + 1, i)) -1;
                }
            } else if( n==0){
                size++;
            }
        }
        return size;
    }
}