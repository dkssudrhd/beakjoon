package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_15655 {
    static int n, m;
    static boolean[] visit;
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

        visit = new boolean[n];
        arr = new int[m];
        dfs(0, 0);
        System.out.print(sb);
        br.close();
    }

    private static void dfs(int depth, int start) {
        if(depth == m) {
            for( int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = numberList[i];
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}
