package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int small = 0;
        int big = 0;
        int now = 2000000001;
        int small_i=0;
        int big_i=n-1;

        while (small_i != big_i) {

            int sum = Math.abs(array[small_i] + array[big_i]);
            System.out.println("now : " + now + " sum : " + sum);

            if (sum < now) {
                now = sum;
                small = array[small_i];
                big = array[big_i];
            }
            if (array[small_i] + array[big_i] < 0) {
                small_i++;
            } else {
                big_i--;
            }

        }
        System.out.println(small + " " + big);
        br.close();
    }
}
