package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak_2195 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        int[] array = new int[p.length()+1];
        Arrays.fill(array, Integer.MAX_VALUE);


        array[0] = 1;
        for(int i=1; i<=p.length(); i++){
            int k=1;
            while(k<=i){
                if(!s.contains(p.substring(i-k, i))){
                    break;
                } else{

                    if(k==i){
                        array[i] = 1;
                    }
                    else if(array[i] > array[i-k] + 1) {
                        array[i] = array[i - k] + 1;

                    }
                }
                k++;
            }
        }

        System.out.println(array[p.length()]);

    }
}
