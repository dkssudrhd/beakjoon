package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] x = new long[n + 1];
        long[] y = new long[n + 1];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        x[n] = x[0];
        y[n] = y[0];

        long sum_a = 0, sum_b = 0;
        for (int i=0; i<n; i++){
            sum_a += x[i] * y[i + 1];
            sum_b += x[i + 1] * y[i];
        }
        String area = String.format("%.1f", (Math.abs(sum_a - sum_b) / 2.0));
        System.out.println(area);
        br.close();
    }
}
