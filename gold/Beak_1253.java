package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Beak_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] array = new int[n];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            map.put(array[i], 1);
        }
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(map.get(array[i] + array[j]).equals(1)){
                    map.put(array[i] + array[j], 2);
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}
