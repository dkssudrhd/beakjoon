package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] box = new int[1001];

        int big_size =0;
        int big_where=0;
        int start =1000;
        int finish = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            box[a] = b;
            if(big_size < b){
                big_size = b;
                big_where = a;
            }
            if(start > a){
                start = a;
            }
            if(finish < a){
                finish = a;
            }
        }

        int sum=0;
        int now_size = box[start];
        for(int i=start; i<= big_where ; i++){
            if(now_size < box[i]){
                now_size = box[i];
            }
            sum += now_size;
        }

        now_size = box[finish];
        for(int i=finish; i> big_where; i--){
            if(now_size < box[i]){
                now_size = box[i];
            }
            sum += now_size;
        }
        System.out.println(sum);
    }
}
