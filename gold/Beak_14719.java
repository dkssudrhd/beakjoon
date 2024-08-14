package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] array = new int[w][h];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i< w ; i++){
            int high = Integer.parseInt(st.nextToken());
            for(int j=0; j< high; j++){
                array[i][j] = 1;
            }
        }

        int sum = 0;
        for(int i=0; i< h; i++){
            boolean start = false;
            int count = 0;
            for(int j=0; j< w; j++){
                if(array[j][i] == 1 && !start){
                    start = true;
                } else if(array[j][i] == 1){
                    sum += count;
                    count = 0;
                }
                if(start){
                    if(array[j][i] == 0){
                        count++;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
