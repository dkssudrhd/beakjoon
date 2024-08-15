package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_15656 {
    static int n, m;
    static int[] arr;
    static int[] numberList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numberList = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numberList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numberList);


        arr = new int[m];
        dfs(0, 0);
        System.out.print(sb);
        br.close();
    }

    private static void dfs(int depth, int start){
        if(depth == m){
            for (int j : arr) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start ; i< numberList.length; i++){
            arr[depth] = numberList[i];
            dfs(depth+1, i);
        }
    }
}
